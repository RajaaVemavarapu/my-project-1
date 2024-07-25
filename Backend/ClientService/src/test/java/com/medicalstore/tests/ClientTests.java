package com.medicalstore.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.medicalstore.controller.ClientController;
import com.medicalstore.entity.Client;
import com.medicalstore.service.ClientService;

class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1L, "John", "Doe", "1234567890", "Address 1", "john@example.com", "1990-01-01", "john_doe", "password"));

        when(clientService.getAllClients()).thenReturn(clients);

        ResponseEntity<List<Client>> response = clientController.getAllClients();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clients, response.getBody());
    }

    @Test
    void testGetClientById() {
        Long id = 1L;
        Client client = new Client(id, "John", "Doe", "1234567890", "Address 1", "john@example.com", "1990-01-01", "john_doe", "password");

        when(clientService.getClientById(id)).thenReturn(client);

        ResponseEntity<Client> response = clientController.getClientById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    void testAddClient() {
        Client client = new Client(null, "John", "Doe", "1234567890", "Address 1", "john@example.com", "1990-01-01", "john_doe", "password");
        Client savedClient = new Client(1L, "John", "Doe", "1234567890", "Address 1", "john@example.com", "1990-01-01", "john_doe", "password");

        when(clientService.saveClient(client)).thenReturn(savedClient);

        ResponseEntity<Client> response = clientController.addClient(client);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedClient, response.getBody());
    }

    @Test
    void testDeleteClient() {
        Long id = 1L;
        ResponseEntity<Void> response = clientController.deleteClient(id);

        verify(clientService, times(1)).deleteClientById(id);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testUpdateClient() {
        Long id = 1L;
        Client updatedClient = new Client(id, "John", "Doe", "1234567890", "Updated Address", "john@example.com", "1990-01-01", "john_doe", "password");

        when(clientService.getClientById(id)).thenReturn(new Client(id, "John", "Doe", "1234567890", "Address 1", "john@example.com", "1990-01-01", "john_doe", "password"));
        when(clientService.saveClient(any(Client.class))).thenReturn(updatedClient);

        ResponseEntity<Client> response = clientController.updateClient(id, updatedClient);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedClient.getAddress(), response.getBody().getAddress());
    }
}
