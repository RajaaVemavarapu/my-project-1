package com.medicalstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.entity.Stock;
import com.medicalstore.exception.StockNotFoundException;
import com.medicalstore.repository.StockRepository;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        Stock stock= stockRepository.findById(id).get();
        if(stock==null) {
        	throw  new StockNotFoundException("Stock not found");
        }
        return stock;
                             
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
   }

    public void deleteStockById(Long id) {
        stockRepository.deleteById(id);
    }
    
    public Stock getStockByMedicineId(Long medicineId) {
        return stockRepository.findByMedicineId(medicineId);
    }
    
}

