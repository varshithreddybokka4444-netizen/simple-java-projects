package com.librarymanagement.app;

import org.junit.jupiter.api.Test;

//import static junit.framework.Assert.assertEquals;
  import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    @Test
    void testAddition() {
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.add(2, 3);
        assertEquals(9, result);
    }
}
