package com.librarymanagement.service;
import com.librarymanagement.model.*;
import com.librarymanagement.repository.BookRepository;

public class CatalogService {


        private BookRepository bookRepository;

        public CatalogService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

    public ServiceResult addBook(String title,String author,String publisher,String isbn) {
        if (title == null) {
            return new ServiceResult(false, "Invalid Book title!");
        } else if (author == null) {
            return new ServiceResult(false, "Invalid Author name!");
        } else if (publisher == null) {
            return new ServiceResult(false, "Invalid publisher name!");
        } else if (isbn == null) {
            return new ServiceResult(false, "Invalid ISBN number!");
        }

        Book book = new Book(title, author, publisher, isbn);
        bookRepository.addBook(book);

        return null;
    }
    public ServiceResult updateBook(String title,String author,String publisher,String isbn){
        if (title == null) {
            return new ServiceResult(false, "Invalid Book title!");
        } else if (author == null) {
            return new ServiceResult(false, "Invalid Author name!");
        } else if (publisher == null) {
            return new ServiceResult(false, "Invalid publisher name!");
        }
        Book book = bookRepository.findByIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
                return null;
    }
    public ServiceResult updateBookTitle(String title,String isbn){
        if (title == null) {
            return new ServiceResult(false, "Invalid Book title!");
        }
        Book book = bookRepository.findByIsbn(isbn);
        book.setTitle(title);
        return null;
    }
    public ServiceResult updateBookAuthor(String author,String isbn){
            if (author == null) {
            return new ServiceResult(false, "Invalid Author name!");
           }
        Book book = bookRepository.findByIsbn(isbn);

        book.setAuthor(author);
        return null;
    }
}






