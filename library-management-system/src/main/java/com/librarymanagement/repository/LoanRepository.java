package com.librarymanagement.repository;
import java.util.*;
public class LoanRepository{
    Map<String,String> map = new HashMap<>();
    public void recordLoan(String bookCopyId,String memberId){
        map.put(bookCopyId,memberId);
    }
}
