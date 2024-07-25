package com.medicalStore.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicalStore.dto.MedicineDto;


@FeignClient(name="MEDICINESERVICE")
public interface MedicineDao {
	
	
	 @GetMapping("/medicines/get/{id}")
	public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Long id);
	
	 @PutMapping("/medicines/update/{id}")
	    public ResponseEntity<MedicineDto> updateMedicine(@PathVariable Long id, @RequestBody MedicineDto updatedMedicine);
}

