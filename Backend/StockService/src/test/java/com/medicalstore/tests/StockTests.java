package com.medicalstore.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.medicalstore.controller.StockController;
import com.medicalstore.entity.Stock;
import com.medicalstore.service.StockService;

 class StockTests {

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllStock() {
        // Mock data
        List<Stock> stockList = new ArrayList<>();
        Stock stock1 = new Stock(1L, 20.0, LocalDate.now(), 10, "Location1", 1L);
        stockList.add(stock1);

        // Stubbing the service method
        when(stockService.getAllStock()).thenReturn(stockList);

        // Calling the controller method
        ResponseEntity<List<Stock>> response = stockController.getAllStock();

        // Verifying the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetStockById() {
        // Mock data
        Stock stock = new Stock(1L, 20.0, LocalDate.now(), 10, "Location1", 1L);

        // Stubbing the service method
        when(stockService.getStockById(1L)).thenReturn(stock);

        // Calling the controller method
        ResponseEntity<Stock> response = stockController.getStockById(1L);

        // Verifying the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stock, response.getBody());
    }

    @Test
    void testAddStock() {
        // Mock data
        Stock stock = new Stock(1L, 20.0, LocalDate.now(), 10, "Location1", 1L);

        // Stubbing the service method
        when(stockService.saveStock(stock)).thenReturn(stock);

        // Calling the controller method
        ResponseEntity<Stock> response = stockController.addStock(stock);

        // Verifying the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(stock, response.getBody());
    }

    @Test
    void testDeleteStock() {
        // Calling the controller method
        ResponseEntity<Void> response = stockController.deleteStock(1L);

        // Verifying the response
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(stockService, times(1)).deleteStockById(1L);
    }

    @Test
    void testGetStockByMedicineId() {
        // Mock data
        Stock stock = new Stock(1L, 20.0, LocalDate.now(), 10, "Location1", 1L);

        // Stubbing the service method
        when(stockService.getStockByMedicineId(1L)).thenReturn(stock);

        // Calling the controller method
        ResponseEntity<Stock> response = stockController.getStockByMedicineId(1L);

        // Verifying the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stock, response.getBody());
    }
}
