package com.medicalstore.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.medicalstore.exception.SalesNotFoundException;

public class SalesNotFoundExceptionTest {

    @Test
    void testConstructorAndGetMessage() {
        // Arrange
        String errorMessage = "Sales not found.";

        // Act
        SalesNotFoundException exception = new SalesNotFoundException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testResponseStatusAnnotation() throws NoSuchMethodException {
        // Arrange
        ResponseStatus annotation = SalesNotFoundException.class.getAnnotation(ResponseStatus.class);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, annotation.value());
    }
}
