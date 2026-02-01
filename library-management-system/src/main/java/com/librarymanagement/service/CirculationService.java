package com.librarymanagement.service;
import com.librarymanagement.model.BookCopy;
import com.librarymanagement.model.Loan;
import com.librarymanagement.model.Member;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.MemberRepository;
import com.librarymanagement.repository.LoanRepository;

import java.time.Clock;
import java.time.LocalDate;


public class CirculationService {
    private MemberRepository memberRepository;
    private BookCopyRepository bookCopyRepository;
    private LoanRepository loanRepository;
    public CirculationService(MemberRepository memberRepository, BookCopyRepository bookCopyRepository, LoanRepository loanRepository) {
        this.memberRepository = memberRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.loanRepository = loanRepository;
    }
    public void issueBook(String memberId,String bookCopyId) {
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
        BookCopy copy = bookCopyRepository.findBookCopyById(bookCopyId);
   copy.setAvailability(false);

    }
    public void returnBook(String bookCopyId){

        if(loanRepository.bookIssued(bookCopyId)){
            Loan loan = loanRepository.getLoan(bookCopyId);
            if(loan.isActive()){
                loanRepository.closeLoan(bookCopyId);
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

}
