package com.medicalstore.dao;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medicalstore.dto.ClientDto;



@FeignClient(name="CLIENTSERVICE",url="http://localhost:1234")
public interface ClientDao {
	
		@GetMapping("/clients/get/{id}")
	    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id);
		
		@GetMapping("/clients/getClient/{id}")
	    public ClientDto getClientByIds(@PathVariable Long id);

}
