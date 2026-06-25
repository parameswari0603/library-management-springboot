package org.example.libraryapp.controller;

import org.example.libraryapp.entity.Loan;
import org.example.libraryapp.service.BorrowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/borrow")
    public Loan borrow(
            @RequestParam Long memberId,
            @RequestParam Long bookId) {

        return borrowService.borrow(memberId, bookId);
    }

    @PostMapping("/return/{loanId}")
    public String returnBook(@PathVariable Long loanId) {

        borrowService.returnBook(loanId);

        return "Book returned successfully";
    }
}