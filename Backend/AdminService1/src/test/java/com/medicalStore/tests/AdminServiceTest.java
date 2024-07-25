package com.medicalStore.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.medicalStore.entity.Admin;
import com.medicalStore.exception.AdminNotFoundException;
import com.medicalStore.repository.AdminRepository;
import com.medicalStore.service.AdminService;

public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAdmins() {
        // Given
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin(1L, "John","Parvez@123"));
        admins.add(new Admin(2L, "Jane","Parvez@1233"));
        when(adminRepository.findAll()).thenReturn(admins);

        // When
        List<Admin> result = adminService.getAllAdmins();

        // Then
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getUserName());
        assertEquals("Jane", result.get(1).getUserName());
    }

    @Test
    public void testGetAdminById_ExistingId() {
        // Given
        Admin admin = new Admin(1L, "John","Suheb@123");
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        // When
        Admin result = adminService.getAdminById(1L);

        // Then
        assertEquals("John", result.getUserName());
    }

    @Test
    public void testGetAdminById_NonExistingId() {
        // Given
        when(adminRepository.findById(1L)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(AdminNotFoundException.class, () -> adminService.getAdminById(1L));
    }

    @Test
    public void testSaveAdmin() {
        // Given
        Admin admin = new Admin(1L, "John","Ganesh@345");
        when(adminRepository.save(admin)).thenReturn(admin);

        // When
        Admin result = adminService.saveAdmin(admin);

        // Then
        assertEquals("John", result.getUserName());
    }

    @Test
    public void testDeleteAdminById() {
        // Given
        Long adminId = 1L;

        // When
        adminService.deleteAdminById(adminId);

        // Then
        verify(adminRepository, times(1)).deleteById(adminId);
    }
}

