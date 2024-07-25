package com.medicalStore.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.medicalStore.entity.CartServiceEntity;
import com.medicalStore.repository.CartServiceRepository;

@Service
public class CartService {
	@Autowired
	CartServiceRepository cartServiceRepository;
	
	 public CartServiceEntity saveCart(CartServiceEntity cart) {
	    	
	        return cartServiceRepository.save(cart);
	    }
	 public CartServiceEntity getCart(Long id) {
		 return cartServiceRepository.findById(id).get();
	 }

}
