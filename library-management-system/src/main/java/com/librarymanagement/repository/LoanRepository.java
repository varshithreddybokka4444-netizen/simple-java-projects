package com.librarymanagement.repository;
import java.util.*;
public class LoanRepository{
    Map<String,String> map = new HashMap<>();
    public void recordLoan(String bookCopyId,String memberId){
        map.put(bookCopyId,memberId);
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
