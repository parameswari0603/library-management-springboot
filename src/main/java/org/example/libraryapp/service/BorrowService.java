package org.example.libraryapp.service;

import org.example.libraryapp.entity.Book;
import org.example.libraryapp.entity.BookStatus;
import org.example.libraryapp.entity.Loan;
import org.example.libraryapp.entity.Member;
import org.example.libraryapp.repository.BookRepository;
import org.example.libraryapp.repository.LoanRepository;
import org.example.libraryapp.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class BorrowService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;

    public BorrowService(BookRepository bookRepository,
                         MemberRepository memberRepository,
                         LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }

    @Transactional
    public Loan borrow(Long memberId, Long bookId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getStatus() == BookStatus.BORROWED) {
            throw new RuntimeException("Book is already borrowed");
        }

        book.setStatus(BookStatus.BORROWED);

        Loan loan = new Loan();
        loan.setMember(member);
        loan.setBook(book);
        loan.setBorrowDate(LocalDate.now());

        bookRepository.save(book);

        return loanRepository.save(loan);
    }

    @Transactional
    public void returnBook(Long loanId) {

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        Book book = loan.getBook();

        book.setStatus(BookStatus.AVAILABLE);

        loan.setReturnDate(LocalDate.now());

        bookRepository.save(book);
        loanRepository.save(loan);
    }
}