package com.medicalStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.medicalStore.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	// Admin findByUsername(String username);

}
