package com.medicalstore.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalstore.entity.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	List<Stock> findByPurchaseDateBetween(LocalDate startDate, LocalDate endDate);
	 Stock findByMedicineId(Long medicineId);
	
	
}
