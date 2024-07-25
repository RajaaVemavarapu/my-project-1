package com.medicalStore.controller;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.medicalStore.dao.ClientDao;
import com.medicalStore.dao.MedicineDao;
import com.medicalStore.dto.ClientDto;
import com.medicalStore.dto.MedicineDto;
import com.medicalStore.entity.CartServiceEntity;
import com.medicalStore.exception.ResourceNotFoundException;
import com.medicalStore.service.CartService;
 
 
 
 
@RestController
@RequestMapping("/cart")
public class CartServiceController {
	@Autowired
	CartService cartService;
	@Autowired
	ClientDao clientDao;
	@Autowired
	MedicineDao medicineDao;
	@PostMapping("/addCart")
    public ResponseEntity<CartServiceEntity> addAdmin(@RequestBody CartServiceEntity cart) {
		CartServiceEntity newCart = cartService.saveCart(cart);
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }
	@GetMapping("/getCart/{id}")
	public CartServiceEntity getCart(@PathVariable Long id) {
		return cartService.getCart(id);
	}
	@GetMapping("/getClient/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id){
		ResponseEntity<ClientDto> client=clientDao.getClientById(id);
		if(client==null) {
			throw new ResourceNotFoundException("Client Not Found");
		}
		return client;
	}
	 @GetMapping("/medicines/get/{id}")
		public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Long id){
		 ResponseEntity<MedicineDto> medicine=medicineDao.getMedicineById(id);
		 if(medicine==null) {
			 throw new ResourceNotFoundException("medicine Not Found");
		 }
		 return medicine;
	 }
}