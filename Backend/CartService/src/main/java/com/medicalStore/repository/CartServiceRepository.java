package com.medicalStore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalStore.entity.CartServiceEntity;

@Repository
public interface CartServiceRepository extends JpaRepository<CartServiceEntity,Long>{

}

