package com.librarymanagement.model;
public class Book{
    private String title;
    private String author;
    private  String publisher;
   private final String isbn;
    Book(String title, String author, String publisher, String isbn){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {

        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {

        this.publisher = publisher;
    }
    public String getISBN() {
        return isbn;
    }




}