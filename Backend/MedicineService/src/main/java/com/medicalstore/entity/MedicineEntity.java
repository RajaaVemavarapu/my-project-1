package com.medicalstore.entity;
import java.time.LocalDate;

import jakarta.persistence.*;
@Entity
@Table(name="medicine")
public class MedicineEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private LocalDate expirationDate;
    private LocalDate manufacturingDate;
    private String description;
    private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
		
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public MedicineEntity(Long id,  String name,double price, LocalDate expirationDate, LocalDate manufacturingDate, String description, int quantity) {
		super();
		this.id = id;
		this.name = name;	
		this.price = price;
		this.expirationDate = expirationDate;	
		this.manufacturingDate = manufacturingDate;
		this.description = description;	
		this.quantity = quantity;
	}
	public MedicineEntity() {
		super();
		
	}
	@Override
	public String toString() {
		return "MedicineEntity [id=" + id + ", name=" + name + ", price=" + price + ", expirationDate=" + expirationDate
				+ ", manufacturingDate=" + manufacturingDate + ", description=" + description + ", quantity=" + quantity
				+ "]";
	}
	
	public MedicineEntity(long id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
	
	

   

}