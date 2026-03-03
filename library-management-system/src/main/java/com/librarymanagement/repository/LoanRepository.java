package com.librarymanagement.repository;
import java.time.LocalDate;
import java.util.*;
import com.librarymanagement.model.Loan;

public class LoanRepository{
HashMap<String,Loan> map = new HashMap<>();
    public void recordLoan(String bookCopyId, String memberId, LocalDate issueDate){

      Loan loan = new Loan(bookCopyId,memberId,issueDate);
      map.put(bookCopyId,loan);
    }
    public String getMemberIdForcopy(String bookCopyId){
        Loan loan = map.get(bookCopyId);
        return (loan!=null)? loan.getMemberId() : null;
    }
    public boolean bookIssued(String bookCopyId){
   if(map.containsKey(bookCopyId)){
        Loan loan = map.get(bookCopyId);
     return loan.isActive();
       }
       else{
           return false;
        }
    }
    public void removeRecord(String bookCopyId){
        map.remove(bookCopyId);
    }
    public Loan getLoan(String bookCopyId){
        return map.get(bookCopyId);
    }
    public void closeLoan(String bookCopyId){
        Loan loan = map.get(bookCopyId);
        loan.setActive(false);
    }
    public List<Loan> getActiveLoansByMember(String memberId){
        List<Loan> activeLoans = new ArrayList<>();
        for(Loan loan : map.values()){
            if(loan.getMemberId().equals(memberId)){
                activeLoans.add(loan);
            }
        }
        return activeLoans;
    }

}
