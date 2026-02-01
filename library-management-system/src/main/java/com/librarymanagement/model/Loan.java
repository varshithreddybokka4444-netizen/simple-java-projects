package com.librarymanagement.model;
import java.time.LocalDate;
public class Loan {
    String bookCopyId;
    String memberId;
    LocalDate dueDate;
    int renewCount = 0;
    boolean isActive = true;
    public Loan(String bookCopyId, String memberId, LocalDate issueDate) {
        this.bookCopyId = bookCopyId;
        this.memberId = memberId;
        dueDate = issueDate.plusDays(14);
    }
    public void renewLoan(){
        dueDate = dueDate.plusDays(14);
    }
    public boolean isOverDue(LocalDate today){
        return today.isAfter(dueDate);
    }
    public void closeLoan(){
        isActive = false;
    }
}
