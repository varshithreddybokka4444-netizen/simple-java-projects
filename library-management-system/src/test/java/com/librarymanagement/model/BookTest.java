package com.librarymanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldCreateBookWithCorrectValues() {
        Book book = new Book("Adventures of Sherlock Holmes",
                "Arthur Conan Doyle",
                "Penguin",
                "978-0140057249");


        assertEquals("978-0140057249", book.getIsbn());
        assertEquals("Adventures of Sherlock Holmes",book.getTitle());
        assertEquals("Arthur Conan Doyle",book.getAuthor());
        assertEquals("Penguin",book.getPublisher());

    }
    @Test
    void shouldAllowUpdatingDescriptiveFields() {
        Book book = new Book("Adventures of Sherlock Holmes",
                "Arthur Conan Doyle",
                "Penguin",
                "978-0140057249");
        book.setTitle("Sherlock Holmes(updated)");
        book.setAuthor("Sir Arthur");
        book.setPublisher("Penguin London");

        assertEquals("978-0140057249", book.getIsbn());
        assertEquals("Sherlock Holmes(updated)",book.getTitle());
        assertEquals("Sir Arthur",book.getAuthor());
        assertEquals("Penguin London",book.getPublisher());
    }
    @Test
    void isbnShouldRemainUnchanged() {
        Book book = new Book("Adventures of Sherlock Holmes",
                "Arthur Conan Doyle",
                "Penguin",
                "978-0140057249");
        assertEquals("978-0140057249", book.getIsbn());

    }
}