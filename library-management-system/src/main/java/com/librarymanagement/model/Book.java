package com.librarymanagement.model;
public class Book{
    private String title;
    private String author;
    private  String publisher;
   private final String isbn;
   public Book(String title, String author, String publisher, String isbn){
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
    public String getIsbn() {
        return isbn;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Title :").append(title).append("\n")
                .append("Author :").append(author).append("\n")
                .append("Publisher :").append(publisher).append("\n")
                .append("ISBN :").append(isbn).append("\n");
        return sb.toString();
    }
}

