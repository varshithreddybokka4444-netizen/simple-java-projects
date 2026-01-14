package com.librarymanagement.repository;

import java.util.*;
import com.librarymanagement.model.Book;

public class BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book findByIsbn(String isbn) {
        return books.get(isbn);
    }

    public Collection<Book> findAll() {
        return Collections.unmodifiableCollection(books.values());
    }
}
