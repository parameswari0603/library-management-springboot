package org.example.libraryapp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Loan> loans = new ArrayList<>();

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
