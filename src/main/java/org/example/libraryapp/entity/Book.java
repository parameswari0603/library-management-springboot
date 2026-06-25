package org.example.libraryapp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @Enumerated(EnumType.STRING)
    private BookStatus status = BookStatus.AVAILABLE;

    private boolean deleted = false;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = BookStatus.AVAILABLE;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}