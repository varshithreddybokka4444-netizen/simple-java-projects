package com.librarymanagement.service;
import com.librarymanagement.model.*;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.BookRepository;
import com.librarymanagement.service.Validator;

public class CatalogService {


    private BookRepository bookRepository;
    private BookCopyRepository bookCopyRepository;
    public CatalogService(BookRepository bookRepository,BookCopyRepository bookCopyRepository) {
        this.bookRepository = bookRepository;
        this.bookCopyRepository = bookCopyRepository;
    }

Validator validator = new Validator();
    public ServiceResult addBook(Book book) throws InvalidBookException {
        if(bookRepository.hasBook(book.getIsbn())){
            throw new InvalidBookException("Book with the isbn already exists!");
        }
        validator.validate(book.getTitle(),"Title");
        validator.validate(book.getAuthor(),"Author");
        validator.validate(book.getPublisher(),"Publisher");
        validator.validate(book.getIsbn(),"ISBN");

        bookRepository.addBook(book);
        return new ServiceResult(true, "Book added successfully!");
    }


    public ServiceResult updateBook(String title,String author,String publisher,String isbn){
        Book book = bookRepository.findByIsbn(isbn);
        if(book == null){
            throw new IllegalStateException("Book not found");
        }
        if (title != null) {
            book.setTitle(title);
        }
        if (author != null) {
            book.setAuthor(author);
        }
        if (publisher != null) {
            book.setPublisher(publisher);
        }
        return new ServiceResult(true, "Book updated successfully!");
    }

    public ServiceResult addBookCopy(String isbn) throws Exception {
        validator.validate(isbn,"ISBN");
        if(!bookRepository.hasBook(isbn)){
                throw new Exception("Please add book before adding BookCopy!");
            }

        String bookCopyId = generateCopyId();
        BookCopy copy = new BookCopy(isbn,bookCopyId);
        bookCopyRepository.addCopy(copy);

        return new ServiceResult(true, "Book Copy added Successfully! ");

    }





    int copyCounter = 1;
    private String generateCopyId(){
        return String.format("CPY%03d",copyCounter++);
    }

     }










