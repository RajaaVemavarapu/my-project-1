package com.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.medicalstore.entity.MedicineEntity;


@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity,Long>{

}
