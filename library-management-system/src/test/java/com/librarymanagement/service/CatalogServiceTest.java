package com.librarymanagement.service;

import com.librarymanagement.model.Book;
import com.librarymanagement.model.BookCopy;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.BookRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogServiceTest {
    @Test
    public void shouldAddBook()throws Exception{
        BookRepository bookRepository = new BookRepository();
        BookCopyRepository bookCopyRepository =  new BookCopyRepository();

        CatalogService catalogService = new CatalogService(bookRepository,bookCopyRepository);

        Book book = new Book("Adventures of Sherlock Holmes",
                "Arthur Conan Doyle",
                "Penguin",
                "978-0140057249");
        ServiceResult result = catalogService.addBook(book);


        assertTrue(result.isSuccess());
    }
    @Test
    public void shouldThrowExceptionifAllDeatailsNotGiven(){
        BookRepository bookRepository = new BookRepository();
        BookCopyRepository bookCopyRepository =  new BookCopyRepository();

        CatalogService catalogService = new CatalogService(bookRepository,bookCopyRepository);

        Book book = new Book("Adventures of Sherlock Holmes",
                "Arthur Conan Doyle",
                null,
                "978-0140057249");
      //  ServiceResult result = catalogService.addBook(book);
        assertThrows(Exception.class,()->catalogService.addBook(book));
    }

    @Test
    public void shouldAddBookCopy() throws Exception {
       BookRepository bookRepository = new BookRepository();
       BookCopyRepository bookCopyRepository =  new BookCopyRepository();

       CatalogService catalogService = new CatalogService(bookRepository,bookCopyRepository);

       Book book = new Book("Adventures of Sherlock Holmes",
               "Arthur Conan Doyle",
               "Penguin",
               "978-0140057249");
       catalogService.addBook(book);
       ServiceResult result = catalogService.addBookCopy(book.getIsbn());

       assertTrue(result.isSuccess());
   }
   @Test
   public void shouldThrowExceptionIfBookNotAdded(){
       BookRepository bookRepository = new BookRepository();
       BookCopyRepository bookCopyRepository =  new BookCopyRepository();
       CatalogService catalogService = new CatalogService(bookRepository,bookCopyRepository);

       assertThrows(Exception.class,()->catalogService.addBookCopy("ISBN-1"));
   }
   @Test
    public void shouldThrowExcetionIfIsbnOfBookCopyIsNull(){
       BookRepository bookRepository = new BookRepository();
       BookCopyRepository bookCopyRepository =  new BookCopyRepository();
       CatalogService catalogService = new CatalogService(bookRepository,bookCopyRepository);
       assertThrows(Exception.class,()->catalogService.addBookCopy(null));
   }
}