package com.medicalstore.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicalstore.dto.MedicinDto;



@FeignClient(name="MEDICINESERVICE",url="http://localhost:9093")
public interface MedicineDao {
	
	
	 @GetMapping("/medicines/get/{id}")
	public ResponseEntity<MedicinDto> getMedicineById(@PathVariable Long id);
	
	 @PutMapping("/medicines/update/{id}")
	    public ResponseEntity<MedicinDto> updateMedicine(@PathVariable Long id, @RequestBody MedicinDto updatedMedicine);
	 
	 @PutMapping("/medicines/quantityUpdate/{id}/{quantity}")
	    public ResponseEntity<MedicinDto> updateMedicineQuantity(@PathVariable("id") long id,@PathVariable("quantity") int quantity);
	 @PutMapping("medicines/update")
	
	    public MedicinDto update(@RequestBody MedicinDto medicine);
	 
	 
}

