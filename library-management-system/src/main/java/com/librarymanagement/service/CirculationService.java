package com.librarymanagement.service;
import com.librarymanagement.model.BookCopy;
import com.librarymanagement.model.Member;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.MemberRepository;
import com.librarymanagement.repository.LoanRepository;

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

        loanRepository.recordLoan(bookCopyId,memberId);
        BookCopy copy = bookCopyRepository.findBookCopyById(bookCopyId);
   copy.setAvailability(false);

    }

}
