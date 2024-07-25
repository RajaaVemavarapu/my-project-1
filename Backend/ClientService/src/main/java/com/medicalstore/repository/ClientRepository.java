package com.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalstore.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
