package com.librarymanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookCopyTest {

    @Test
    void shouldCreateBookCopyWithCorrectIdentity() {
        BookCopy copy = new BookCopy(
                "978-0140057249",
                "978-0140057249-001"
        );

        assertEquals("978-0140057249", copy.getIsbn());
        assertEquals("978-0140057249-001", copy.getBookCopyId());
    }

    @Test
    void availabilityShouldBeMutableState() {
        BookCopy copy = new BookCopy(
                "978-0140057249",
                "978-0140057249-001"
        );

        copy.setAvailability(false);

        assertFalse(copy.isAvailable());
    }
}
