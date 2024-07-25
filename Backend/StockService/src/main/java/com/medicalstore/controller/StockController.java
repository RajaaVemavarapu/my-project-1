package com.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalstore.entity.Stock;
import com.medicalstore.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;
   

    @GetMapping("/allStocks")//mapping HTTP GET requests to stocks
    public ResponseEntity<List<Stock>> getAllStock() //method to retrieve all stocks
    {
        List<Stock> stocks = stockService.getAllStock();//calling the service to get all stocks
        return new ResponseEntity<>(stocks, HttpStatus.OK);//returning response with all stocks
    } 
    @GetMapping("/get/{id}")//mapping HTTP GET requests to stocks
    public ResponseEntity<Stock> getStockById(@PathVariable Long id)//method to retrieve stock by id
    {
        Stock stock = stockService.getStockById(id);//calling the service to get all stock by id
        return new ResponseEntity<>(stock, HttpStatus.OK);//returning response with stock
    }

    @PostMapping("/saveStock")//mapping HTTP POST requests to stocks
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock)//method to add new stock
    {
        Stock newStock = stockService.saveStock(stock);//calling the service to get new stock
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);//returning response with new stock
   }


    @DeleteMapping("/delete/{id}")//mapping HTTP DELETE requests to stocks
    public ResponseEntity<Void> deleteStock(@PathVariable Long id)//method to delete stock
    {
        stockService.deleteStockById(id);//calling the service to delete stock by id
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);//returning response with no content
    }
    
    @GetMapping("/stockbymedicine/{medicineId}")//mapping HTTP GET requests to stocks by medicine id
    public ResponseEntity<Stock> getStockByMedicineId(@PathVariable Long medicineId) //method to retrieve stock by medicine id
    {
        Stock stock = stockService.getStockByMedicineId(medicineId);//calling the service to get stock by medicine id
        if (stock != null) {
            return new ResponseEntity<>(stock, HttpStatus.OK);//returning response with stock
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//returning response with not found status
        }
    }
        
        
        
       
        

    
}

