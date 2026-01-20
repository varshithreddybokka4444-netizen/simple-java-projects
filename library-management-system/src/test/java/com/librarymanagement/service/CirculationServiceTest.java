package com.librarymanagement.service;

import com.librarymanagement.model.BookCopy;
import com.librarymanagement.model.Member;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.LoanRepository;
import com.librarymanagement.repository.MemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculationServiceTest {
    @Test
    void shouldIssueBookWhenMemberIsActiveAndCopyIsAvailable() {

        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy copy = new BookCopy("ISBN-1", "COPY-1");
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.addMember(member);
        BookCopyRepository bookCopyRepository= new BookCopyRepository();
        bookCopyRepository.addCopy(copy);
        LoanRepository loanRepository = new LoanRepository();
        CirculationService circulationService =
                new CirculationService(memberRepository, bookCopyRepository, loanRepository);

        circulationService.issueBook("M1", "COPY-1");

        assertEquals("M1",loanRepository.getMemberIdForcopy("COPY-1"));
        assertFalse(copy.isAvailable());

    }
}
}