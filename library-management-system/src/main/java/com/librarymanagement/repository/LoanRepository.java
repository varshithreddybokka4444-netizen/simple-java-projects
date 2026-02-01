package com.librarymanagement.repository;
import java.time.LocalDate;
import java.util.*;
import com.librarymanagement.model.Loan;

public class LoanRepository{
List<Loan> = new
    public void recordLoan(String bookCopyId, String memberId, LocalDate issueDate){
      Loan loan = new Loan(bookCopyId,memberId,issueDate);
    }
    public String getMemberIdForcopy(String bookCopyId){
        return map.get(bookCopyId);
    }
    public boolean bookIssued(String bookCopyId){
        return map.containsKey(bookCopyId);
    }
    public void removeRecord(String bookCopyId){
        map.remove(bookCopyId);
    }
}
