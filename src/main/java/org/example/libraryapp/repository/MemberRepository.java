package org.example.libraryapp.repository;

import org.example.libraryapp.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}