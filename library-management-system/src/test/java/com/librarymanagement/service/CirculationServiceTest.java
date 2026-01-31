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
        LoanRepository loanRepository = new LoanRepository();
        CirculationService circulationService =
                createCirculationService(member,copy, loanRepository);
        circulationService.issueBook("M1", "COPY-1");

        circulationService.issueBook("M1", "COPY-1");

        assertEquals("M1", loanRepository.getMemberIdForcopy("COPY-1"));
        assertFalse(copy.isAvailable());
    }
        @Test
        void shouldNotIssueBookWhenCopyIsAlreadyIssued() {
            Member member = new Member("M1", "Alice", "alice@test.com");
            BookCopy copy = new BookCopy("ISBN-1", "COPY-1");
            LoanRepository loanRepository = new LoanRepository();
            CirculationService circulationService =
                    createCirculationService(member,copy, loanRepository);
            circulationService.issueBook("M1", "COPY-1");

            circulationService.issueBook("M1", "COPY-1");
            assertThrows(IllegalStateException.class,() ->
                    circulationService.issueBook("M1", "COPY-1"));
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
                LoanRepository loanRepository = new LoanRepository();
                CirculationService circulationService =
                        createCirculationService(member,copy, loanRepository);
                circulationService.issueBook("M1", "COPY-1");
                member.setIsActive(false);
                assertThrows(IllegalStateException.class, () ->
                        circulationService.issueBook("M1", "COPY-1")
                );

            }
            @Test
    public void shouldReturnBookWhenCopyIsIssued(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy copy = new BookCopy("ISBN-1", "COPY-1");
        LoanRepository loanRepository = new LoanRepository();
                CirculationService circulationService =
                        createCirculationService(member,copy, loanRepository);
        circulationService.issueBook("M1", "COPY-1");
        circulationService.returnBook(copy.getBookCopyId());
        assertFalse(loanRepository.bookIssued(copy.getBookCopyId()));
            }
            @Test
            public void shouldNotAllowReturningBookTwice(){
       Member member = new Member("M1", "Alice", "alice@test.com");
       BookCopy copy = new BookCopy("ISBN-1", "COPY-1");

       LoanRepository loanRepository = new LoanRepository();

       CirculationService circulationService =
             createCirculationService(member,copy, loanRepository);
                circulationService.issueBook("M1", "COPY-1");
       circulationService.returnBook(copy.getBookCopyId());

       assertThrows(IllegalStateException.class,()->circulationService.returnBook(copy.getBookCopyId()));
   }
   @Test
   public void shouldNotReturnBookWhenCopyIsNotIssued(){
       Member member = new Member("M1", "Alice", "alice@test.com");
       BookCopy bookCopy = new BookCopy("ISBN-1", "COPY-1");

       LoanRepository loanRepository = new LoanRepository();
       CirculationService circulationService =
               createCirculationService(member, bookCopy, loanRepository);
       assertThrows(IllegalStateException.class,()->circulationService.returnBook(bookCopy.getBookCopyId()));
   }

private CirculationService createCirculationService(Member member,BookCopy bookCopy,LoanRepository loanRepository){
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.addMember(member);
        BookCopyRepository bookCopyRepository = new BookCopyRepository();
        bookCopyRepository.addCopy(bookCopy);
        return new CirculationService(memberRepository,bookCopyRepository,loanRepository);
   }
   public void shouldRenewLoanWhenBookIsIssued(){

   }

}

