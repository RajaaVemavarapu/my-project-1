package com.medicalstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.entity.Client;
import com.medicalstore.exception.ClientNotFoundException;
import com.medicalstore.repository.ClientRepository;

@Service("medicalStoreClientService")
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                               .orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}

