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
        BookCopyRepository bookCopyRepository = new BookCopyRepository();
        bookCopyRepository.addCopy(copy);
        LoanRepository loanRepository = new LoanRepository();
        CirculationService circulationService =
                new CirculationService(memberRepository, bookCopyRepository, loanRepository);

        circulationService.issueBook("M1", "COPY-1");

        assertEquals("M1", loanRepository.getMemberIdForcopy("COPY-1"));
        assertFalse(copy.isAvailable());
    }
        @Test
        void shouldNotIssueBookWhenCopyIsAlreadyIssued() {
            Member member2 = new Member("M1", "Alice", "alice@test.com");
            BookCopy copy2 = new BookCopy("ISBN-1", "COPY-1");
            MemberRepository memberRepository2 = new MemberRepository();
            memberRepository2.addMember(member2);
            BookCopyRepository bookCopyRepository2 = new BookCopyRepository();
            bookCopyRepository2.addCopy(copy2);
            LoanRepository loanRepository2 = new LoanRepository();
            CirculationService circulationService2 =
                    new CirculationService(memberRepository2, bookCopyRepository2, loanRepository2);

            circulationService2.issueBook("M1", "COPY-1");
            assertThrows(IllegalStateException.class,() ->
                    circulationService2.issueBook("M1", "COPY-1"));
        }
            @Test
            void shouldNotIssueBookIfMemberIsNotFound() {

                BookCopy copy = new BookCopy("ISBN-1", "COPY-1");
                MemberRepository memberRepository = new MemberRepository();

                BookCopyRepository bookCopyRepository = new BookCopyRepository();
                bookCopyRepository.addCopy(copy);
                LoanRepository loanRepository = new LoanRepository();
                CirculationService circulationService =
                        new CirculationService(memberRepository, bookCopyRepository, loanRepository);

                assertThrows(NullPointerException.class, () ->
                        circulationService.issueBook("M1", "COPY-1")
                );

            }

            @Test
            void shouldNotIssueBookIfMemberIsNotActive() {
                Member member = new Member("M1", "Alice", "alice@test.com");
                BookCopy copy = new BookCopy("ISBN-1", "COPY-1");
                MemberRepository memberRepository = new MemberRepository();
                memberRepository.addMember(member);
                BookCopyRepository bookCopyRepository = new BookCopyRepository();
                bookCopyRepository.addCopy(copy);
                LoanRepository loanRepository = new LoanRepository();
                CirculationService circulationService =
                        new CirculationService(memberRepository, bookCopyRepository, loanRepository);
                member.setIsActive(false);
                assertThrows(IllegalStateException.class, () ->
                        circulationService.issueBook("M1", "COPY-1")
                );

            }
        }

