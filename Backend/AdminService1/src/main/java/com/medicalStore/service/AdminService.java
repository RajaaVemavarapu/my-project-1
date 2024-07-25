package com.medicalStore.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.medicalStore.repository.AdminRepository;
import com.medicalStore.exception.AdminNotFoundException;

import com.medicalStore.entity.Admin;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                              .orElseThrow(() -> new AdminNotFoundException("Admin not found"));
    }

    public Admin saveAdmin(Admin admin) {
    	
        return adminRepository.save(admin);
    }

    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }
//    public Admin getAdminByUsername(String username) {
//        return adminRepository.findByUsername(username);
//    }
}

