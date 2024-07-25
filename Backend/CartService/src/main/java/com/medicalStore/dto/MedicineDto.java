package com.medicalStore.dto;

import java.time.LocalDate;

public class MedicineDto {
	private Long id;

	   
    private String name;

   
    private String dosage;

   
    private double price;

   
    private LocalDate expirationDate;

   
    private String manufacturer;

    
    private String batchNumber;

   
    private LocalDate manufacturingDate;
    
    private String description;

    private long stockId;

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

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
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

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	@Override
	public String toString() {
	    return "MedicineDto [id=" + id + ", name=" + name + ", dosage=" + dosage + ", price=" + price
	            + ", expirationDate=" + expirationDate + ", manufacturer=" + manufacturer + ", batchNumber=" + batchNumber
	            + ", manufacturingDate=" + manufacturingDate + ", description=" + description + ", stockId=" + stockId + "]";
	}

	
    
    

}
