package com.librarymanagement.service;
import com.librarymanagement.model.BookCopy;
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
   loanRepository.recordLoan(bookCopyId,memberId);
   BookCopy copy = findBookCopyById(bookCopyId);
   copy.setAvailability(false);
    }

}
