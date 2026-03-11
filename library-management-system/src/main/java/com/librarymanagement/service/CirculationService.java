package com.librarymanagement.service;
import com.librarymanagement.model.BookCopy;
import com.librarymanagement.model.Loan;
import com.librarymanagement.model.Member;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.MemberRepository;
import com.librarymanagement.repository.LoanRepository;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;


public class CirculationService {
    private MemberRepository memberRepository;
    private BookCopyRepository bookCopyRepository;
    private LoanRepository loanRepository;
    private static int borrowLimit = 3;
    public CirculationService(MemberRepository memberRepository, BookCopyRepository bookCopyRepository, LoanRepository loanRepository) {
        this.memberRepository = memberRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.loanRepository = loanRepository;
    }
    public void issueBook(String memberId,String bookCopyId) throws IllegalStateException {
        BookCopy copy = bookCopyRepository.findBookCopyById(bookCopyId);

        if(copy == null){
            throw new LibraryException("Book copy not found");
        }
        if (borrowedBooks(memberId) >= borrowLimit) {
            throw new IllegalStateException(
                    "Borrow limit exceeded! Maximum allowed: " + borrowLimit
            );
        }

        if (loanRepository.bookIssued(bookCopyId)) {
            throw new IllegalStateException("Book already issued");
        }
        Member member =  memberRepository.fingMemberById(memberId);
        if (member == null) {
            throw new NullPointerException( "Member not found");
        }
        if(!member.isActive()){
            throw new IllegalStateException("Member is not active!");
        }
        Clock clock = Clock.systemDefaultZone();
        LocalDate today = LocalDate.now(clock);

        loanRepository.recordLoan(bookCopyId,memberId,today);

       copy.setAvailability(false);

    }
    public void returnBook(String bookCopyId){

        if(loanRepository.bookIssued(bookCopyId)){
            Loan loan = loanRepository.getLoan(bookCopyId);
            if(loan.isActive()){
                loanRepository.closeLoan(bookCopyId);
                BookCopy copy = bookCopyRepository.findBookCopyById(bookCopyId);
                copy.setAvailability(true);
            }
            else{
                throw new IllegalStateException("Book already returned!");
            }
        }
        else {
            throw new IllegalStateException("Book was never Issued!");
        }

    }
    public void renewLoan(String bookCopyId){

            Loan loan = loanRepository.getLoan(bookCopyId);
            if(loan==null) {
                throw new IllegalStateException("Book is not Issued!");
            }
                if(!loan.isActive()){
                throw new IllegalStateException("Book is Already returned!");
            }
        loan.renewLoan();
    }
    public boolean isAvailable(String bookCopyId){
        return !loanRepository.bookIssued(bookCopyId);
    }
    public List<Loan> getActiveLoansForMember(String memberId){
    return loanRepository.getActiveLoansByMember(memberId);
    }
    private int borrowedBooks(String memberId){
        return loanRepository.getActiveLoansByMember(memberId).size();
    }

}
