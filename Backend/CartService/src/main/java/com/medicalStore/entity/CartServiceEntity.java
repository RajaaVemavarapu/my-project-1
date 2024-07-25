package com.medicalStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class CartServiceEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long medicineId;
	private Long clientId;

	public CartServiceEntity() {
		super();

	}

	public CartServiceEntity(Long id, Long medicineId, Long clientId) {
		super();
		this.id = id;
	
		this.medicineId = medicineId;
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "CartServiceEntity [id=" + id  + ", medicineId=" + medicineId + ", clientId="
				+ clientId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}
