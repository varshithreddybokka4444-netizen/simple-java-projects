package com.librarymanagement.repository;

import com.librarymanagement.model.BookCopy;

import java.util.*;

public class BookCopyRepository {
    private final Map<String, BookCopy> copies = new HashMap<>();
    public void addCopy(BookCopy copy){
        copies.put(copy.getBookCopyId(),copy);
    }
    public BookCopy findCopyById(String copyId){
        return copies.get(copyId);
    }
    public Collection<BookCopy> allCopies(){
        return Collections.unmodifiableCollection(copies.values());
    }
}
