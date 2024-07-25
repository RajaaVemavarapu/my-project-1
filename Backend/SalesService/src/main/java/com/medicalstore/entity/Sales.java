package com.medicalstore.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="sales")
public class Sales {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Long  clientId;

    private Long medicinesId;
    

    @NotNull(message = "Total price is required")
    private double totalPrice;

    @NotNull(message = "Date is required")
    private String dateTime;

	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(Long id, Long clientId, Long medicinesId,
			@NotNull(message = "Total price is required") double totalPrice,
			@NotNull(message = "Date is required") String dateTime) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.medicinesId = medicinesId;
		this.totalPrice = totalPrice;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getMedicinesId() {
		return medicinesId;
	}

	public void setMedicinesId(Long medicinesId) {
		this.medicinesId = medicinesId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", clientId=" + clientId + ", medicinesId=" + medicinesId + ", totalPrice="
				+ totalPrice + ", dateTime=" + dateTime + "]";
	}
    
}