package com.librarymanagement.model;

public class BookCopy {
    private final String isbn;
    private final String bookCopyID;
    private boolean available = true;
    public BookCopy(String isbn, String bookCopyID){
        this.isbn = isbn;
        this.bookCopyID = bookCopyID;
    }
    public void setAvailability(boolean available){
       this.available = available;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getBookCopyId() {
        return bookCopyID;
    }
    public boolean isAvailable() {
        return available;
    }

}
