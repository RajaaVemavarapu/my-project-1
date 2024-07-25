package com.medicalstore.dao;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medicalstore.dto.StockDto;



@FeignClient(name="STOCKSERVICE")
public interface StockDao {
	 @LoadBalanced
	 @GetMapping("stocks/get/{id}")
	    public ResponseEntity<StockDto> getStockById(@PathVariable Long id); 
	
   
}
