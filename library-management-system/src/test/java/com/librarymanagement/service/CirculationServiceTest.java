package com.librarymanagement.service;

import com.librarymanagement.model.BookCopy;
import com.librarymanagement.model.Loan;
import com.librarymanagement.model.Member;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.LoanRepository;
import com.librarymanagement.repository.MemberRepository;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

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

//        circulationService.issueBook("M1", "COPY-1");

        assertEquals("M1", loanRepository.getMemberIdForcopy("COPY-1"));
        assertFalse(copy.isAvailable());
    }
        @Test
        void ShouldNotIssueBookWhenCopyIsAlreadyIssued() {
            Member member = new Member("M1", "Alice", "alice@test.com");
            BookCopy copy = new BookCopy("ISBN-1", "COPY-1");
            LoanRepository loanRepository = new LoanRepository();
            CirculationService circulationService =
                    createCirculationService(member,copy, loanRepository);
            circulationService.issueBook("M1", "COPY-1");

//            circulationService.issueBook("M1", "COPY-1");
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
   @Test
    public void shouldRenewLoanWhenBookIsIssued(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy bookCopy = new BookCopy("ISBN-1", "COPY-1");

        LoanRepository loanRepository = new LoanRepository();
        CirculationService circulationService =
                createCirculationService(member, bookCopy, loanRepository);
       circulationService.issueBook("M1", "COPY-1");
        circulationService.renewLoan("COPY-1");
        Loan loan = loanRepository.getLoan("COPY-1");
       Clock clock = Clock.systemDefaultZone();
       LocalDate today = LocalDate.now(clock);

       assertFalse(loan.isOverDue(today));

    }
    @Test
    public void shouldNotRenewLoanWhenBookIsNotIssued(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy bookCopy = new BookCopy("ISBN-1", "COPY-1");

        LoanRepository loanRepository = new LoanRepository();
        CirculationService circulationService =
                createCirculationService(member, bookCopy, loanRepository);


        assertThrows(IllegalStateException.class,
                () -> circulationService.renewLoan("COPY-1"));

    }
    @Test
    public void shouldNotRenewLoanWhenBookIsReturned(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy bookCopy = new BookCopy("ISBN-1", "COPY-1");

        LoanRepository loanRepository = new LoanRepository();
        CirculationService circulationService =
                createCirculationService(member, bookCopy, loanRepository);
        circulationService.issueBook("M1", "COPY-1");
        circulationService.returnBook("COPY-1");
        assertThrows(IllegalStateException.class,
                () -> circulationService.renewLoan("COPY-1"));

    }
    @Test
    public void shouldShowBookAvailableWhenNotIssued(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy bookCopy = new BookCopy("ISBN-1", "COPY-1");

        LoanRepository loanRepository = new LoanRepository();

        CirculationService circulationService = createCirculationService(member,bookCopy,loanRepository);

        boolean Available = circulationService.isAvailable(bookCopy.getBookCopyId());
        assertTrue(Available);

    }
    @Test
    public void shouldReturnFalseWhenBookNotAvailable(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy bookCopy = new BookCopy("ISBN-1", "COPY-1");
        LoanRepository loanRepository = new LoanRepository();

        CirculationService circulationService = createCirculationService(member,bookCopy,loanRepository);

        circulationService.issueBook(member.getMemberId(),bookCopy.getBookCopyId());

        boolean Available = circulationService.isAvailable(bookCopy.getBookCopyId());
        assertFalse(Available);
    }
    @Test
    public void shouldReturnActiveLoansForMembers(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy bookCopy = new BookCopy("ISBN-1", "COPY-1");
        LoanRepository loanRepository = new LoanRepository();

        CirculationService circulationService = createCirculationService(member,bookCopy,loanRepository);

        circulationService.issueBook(member.getMemberId(),bookCopy.getBookCopyId());

        List<Loan>  loans = circulationService.getActiveLoansForMember(member.getMemberId());
        assertEquals(1, loans.size());
        assertEquals(loans.get(0).getMemberId(),member.getMemberId());
        assertTrue(loans.get(0).isActive());
    }
     @Test
    public void shouldNotLendMoreThanLoanLimit(){
        Member member = new Member("M1", "Alice", "alice@test.com");
        BookCopy bookCopy1 = new BookCopy("ISBN-1", "COPY-1");
        BookCopy bookCopy2 =new BookCopy("ISBN-2", "COPY-2");
        BookCopy bookCopy3 =new BookCopy("ISBN-3", "COPY-3");
        BookCopy bookCopy4 =new BookCopy("ISBN-4", "COPY-4");
        LoanRepository loanRepository = new LoanRepository();
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.addMember(member);
        BookCopyRepository bookCopyRepository = new BookCopyRepository();
        bookCopyRepository.addCopy(bookCopy1);
        bookCopyRepository.addCopy(bookCopy2);
        bookCopyRepository.addCopy(bookCopy3);
        bookCopyRepository.addCopy(bookCopy4);

        CirculationService circulationService =
                new CirculationService(memberRepository,bookCopyRepository,loanRepository);
       circulationService.issueBook(member.getMemberId(),bookCopy1.getBookCopyId());
        circulationService.issueBook(member.getMemberId(),bookCopy2.getBookCopyId());
        circulationService.issueBook(member.getMemberId(),bookCopy3.getBookCopyId());
        assertThrows(IllegalStateException.class, () ->
                circulationService.issueBook(member.getMemberId(), bookCopy4.getBookCopyId())
        );



    }



private CirculationService createCirculationService(Member member,BookCopy bookCopy,LoanRepository loanRepository){
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.addMember(member);
        BookCopyRepository bookCopyRepository = new BookCopyRepository();
        bookCopyRepository.addCopy(bookCopy);
        return new CirculationService(memberRepository,bookCopyRepository,loanRepository);
   }


}

