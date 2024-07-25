package com.medicalstore.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.medicalstore.controller.SalesController;
import com.medicalstore.dao.ClientDao;
import com.medicalstore.dao.MedicineDao;
import com.medicalstore.dto.ClientDto;
import com.medicalstore.dto.MedicinDto;
import com.medicalstore.entity.Sales;
import com.medicalstore.service.SalesService;

@ExtendWith(MockitoExtension.class)
class SalesServiceTest {

    @Mock
    private SalesService salesService;

    @Mock
    private ClientDao clientDao;

    @Mock
    private MedicineDao medicineDao;

    @InjectMocks
    private SalesController salesController;

    private Sales sales;

    @BeforeEach
     void setUp() {
        sales = new Sales();
    }

    @Test
     void testGetAllSales() {
        List<Sales> salesList = new ArrayList<>();
        salesList.add(new Sales(1L, 1L, 1L, 100.0, "2024-03-20"));
        salesList.add(new Sales(2L, 2L, 2L, 200.0, "2024-03-21"));

        when(salesService.getAllSales()).thenReturn(salesList);

        ResponseEntity<List<Sales>> response = salesController.getAllSales();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(salesList, response.getBody());
    }
	    @Test
	     void testPurchaseMedicine() {
	        Long clientId = 1L;
	        Long medicineId = 1L;
	        Integer quantitiesSold = 10;

	        Sales newSales = new Sales(1L, clientId, medicineId, 100.0, "2024-03-20");

	        when(salesService.purchaseMedicine(clientId, medicineId, quantitiesSold)).thenReturn(newSales);

	        ResponseEntity<Sales> response = salesController.purchaseMedicine(clientId, medicineId, quantitiesSold);

	        assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        assertEquals(newSales, response.getBody());
	    }

	    @Test
	    void testDeleteSale() {
	        Long id = 1L;

	        ResponseEntity<Void> response = salesController.deleteSale(id);

	        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	        verify(salesService, times(1)).deleteSaleById(id);
	    }

	    @Test
	    void testGetClient() {
	        Long clientId = 1L;
	        ClientDto clientDto = new ClientDto();

	        when(clientDao.getClientById(clientId)).thenReturn(ResponseEntity.ok(clientDto));

	        assertEquals(clientDto, salesController.get(clientId));
	    }

	    @Test
	    void testGetMedicineById() {
	        Long medicineId = 1L;
	        MedicinDto medicineDto = new MedicinDto();

	        when(medicineDao.getMedicineById(medicineId)).thenReturn(ResponseEntity.ok(medicineDto));

	        assertEquals(medicineDto, salesController.getMedicineById(medicineId));
	    }

	    @Test
	    void testGetSalesByClientId() {
	        Long clientId = 1L;
	        List<Sales> sales = new ArrayList<>();
	        sales.add(new Sales(1L, clientId, 1L, 100.0, "2024-03-20"));
	        sales.add(new Sales(2L, clientId, 2L, 200.0, "2024-03-21"));

	        // Mock the behavior of salesService.getSalesByClientId(clientId)
	        when(salesService.getSalesByClientId(clientId)).thenReturn(sales);

	        // Call the method under test
	        ResponseEntity<List<Sales>> response = salesController.getSalesByClientId(clientId);

	        // Assert the response
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(sales, response.getBody());
	    }
	    @Test
	    void testGetAndSetId() {
	        Long id = 1L;
	        sales.setId(id);
	        assertEquals(id, sales.getId());
	    }

	    @Test
	    void testGetAndSetClientId() {
	        Long clientId = 10L;
	        sales.setClientId(clientId);
	        assertEquals(clientId, sales.getClientId());
	    }

	    @Test
	    void testGetAndSetMedicinesId() {
	        Long medicinesId = 20L;
	        sales.setMedicinesId(medicinesId);
	        assertEquals(medicinesId, sales.getMedicinesId());
	    }

	    @Test
	    void testGetAndSetTotalPrice() {
	        double totalPrice = 50.0;
	        sales.setTotalPrice(totalPrice);
	        assertEquals(totalPrice, sales.getTotalPrice(), 0.001);
	    }

	    @Test
	    void testGetAndSetDateTime() {
	        String dateTime = "2024-04-17";
	        sales.setDateTime(dateTime);
	        assertEquals(dateTime, sales.getDateTime());
	    }

	    @Test
	    void testConstructor() {
	        Long id = 1L;
	        Long clientId = 10L;
	        Long medicinesId = 20L;
	        double totalPrice = 50.0;
	        String dateTime = "2024-04-17";
	        Sales sales = new Sales(id, clientId, medicinesId, totalPrice, dateTime);
	        assertNotNull(sales);
	        assertEquals(id, sales.getId());
	        assertEquals(clientId, sales.getClientId());
	        assertEquals(medicinesId, sales.getMedicinesId());
	        assertEquals(totalPrice, sales.getTotalPrice(), 0.001);
	        assertEquals(dateTime, sales.getDateTime());
	    }
	}
