package com.medicalstore.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.medicalstore.dto.ClientDto;

public class ClientDtoTest {

    private ClientDto clientDto;

    @BeforeEach
    public void setUp() {
        clientDto = new ClientDto();
    }

    @Test
    public void testGetAndSetId() {
        Long id = 1L;
        clientDto.setId(id);
        assertEquals(id, clientDto.getId());
    }

    @Test
    public void testGetAndSetFirstName() {
        String firstName = "John";
        clientDto.setFirstName(firstName);
        assertEquals(firstName, clientDto.getFirstName());
    }

    @Test
    public void testGetAndSetLastName() {
        String lastName = "Doe";
        clientDto.setLastName(lastName);
        assertEquals(lastName, clientDto.getLastName());
    }

    @Test
    public void testGetAndSetContactNumber() {
        String contactNumber = "1234567890";
        clientDto.setContactNumber(contactNumber);
        assertEquals(contactNumber, clientDto.getContactNumber());
    }

    @Test
    public void testGetAndSetAddress() {
        String address = "123 Main St";
        clientDto.setAddress(address);
        assertEquals(address, clientDto.getAddress());
    }

    @Test
    public void testGetAndSetEmail() {
        String email = "john@example.com";
        clientDto.setEmail(email);
        assertEquals(email, clientDto.getEmail());
    }

    @Test
    public void testGetAndSetDateOfBirth() {
        String dateOfBirth = "1990-01-01";
        clientDto.setDateOfBirth(dateOfBirth);
        assertEquals(dateOfBirth, clientDto.getDateOfBirth());
    }

    @Test
    public void testGetAndSetUsername() {
        String username = "john_doe";
        clientDto.setUsername(username);
        assertEquals(username, clientDto.getUsername());
    }

    @Test
    public void testGetAndSetPassword() {
        String password = "password123";
        clientDto.setPassword(password);
        assertEquals(password, clientDto.getPassword());
    }
}
