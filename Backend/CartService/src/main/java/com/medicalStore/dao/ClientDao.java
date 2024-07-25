package com.medicalStore.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medicalStore.dto.ClientDto;

@FeignClient(name="CLIENTSERVICE",url="http://localhost:9092")
public interface ClientDao {
	 @GetMapping("/clients/get/{id}")
	    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id);
 
}
