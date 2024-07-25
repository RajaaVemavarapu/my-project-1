package com.medicalstore.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.dao.ClientDao;
import com.medicalstore.dao.MedicineDao;
import com.medicalstore.dto.ClientDto;
import com.medicalstore.dto.MedicinDto;
import com.medicalstore.entity.Sales;
import com.medicalstore.exception.SalesNotFoundException;
import com.medicalstore.repository.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository saleRepository;

private ClientDao clientDao; // Assuming you have a ClientDao
    
    public SalesService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
	@Autowired
	private MedicineDao medicineDao;
	@Autowired
	private SalesRepository salesRepository;
	
	public List<Sales> getAllSales() {
		return saleRepository.findAll();
	}

	public void deleteSaleById(Long id) {
		saleRepository.deleteById(id);
	}

	public Sales saveSales(Sales sales) {

		// Get the client ID from the sales entity

		Long clientId = sales.getClientId();

		// Fetch the client by ID

		ClientDto client = clientDao.getClientById(clientId).getBody();

		if (client == null) {

			throw new SalesNotFoundException("Client with ID " + clientId + " not found");

		}

		// Get the list of medicine IDs from the sales entity

		Long medicineId = sales.getMedicinesId();

		// Iterate through each medicine ID

		// Fetch the medicine by ID

		MedicinDto medicine = medicineDao.getMedicineById(medicineId).getBody();

		if (medicine == null) {

			throw new SalesNotFoundException("Medicine with ID " + medicineId + " not found");

		}

		// Save the sales entity

		return saleRepository.save(sales);

	}

	public Sales purchaseMedicine(Long clientId, Long medicineId, Integer quantitySold) {
		// Fetch the client by ID
		ClientDto client = clientDao.getClientById(clientId).getBody();
		if (client == null) {
			throw new SalesNotFoundException("Client with ID " + clientId + " not found");
		}

		// Fetch the medicine by ID
		MedicinDto medicine = medicineDao.getMedicineById(medicineId).getBody();
		if (medicine == null) {
			throw new SalesNotFoundException("Medicine with ID " + medicineId + " not found");
		}
		medicine.getName();
		// Check if the quantity sold is not negative
		if (quantitySold <= 0) {
			throw new IllegalArgumentException(
					"Quantity sold for medicine with ID " + medicineId + " cannot be negative");
		}

		// Check if there is enough stock available
		int availableQuantity = medicine.getQuantity();
		if (availableQuantity < quantitySold) {
			throw new SalesNotFoundException("Insufficient stock for medicine with ID " + medicineId);
		}

		// Calculate the total price
		double totalPrice = medicine.getPrice() * quantitySold;

		// Update the stock quantity
		int updatedQuantity = availableQuantity - quantitySold;
		medicine.setQuantity(updatedQuantity);
		medicineDao.update(medicine);

		// Create a new Sales entity
		Sales sale = new Sales();
		sale.setClientId(clientId);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		// Format the LocalDateTime object
		String formattedDateTime = LocalDateTime.now().format(formatter);
		sale.setDateTime(formattedDateTime);
		sale.setMedicinesId(medicineId); // Use Collections.singletonList to create a list with a single element
		sale.setTotalPrice(totalPrice);
		// Save the sale record
		return saleRepository.save(sale);
	}
	public List<Sales> getSalesByClientId(Long clientId) {
        return saleRepository.findByClientId(clientId);
    }
}
