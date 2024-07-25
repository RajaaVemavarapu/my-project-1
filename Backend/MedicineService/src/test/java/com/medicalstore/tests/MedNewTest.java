package com.medicalstore.tests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.medicalstore.controller.MedicineController;
import com.medicalstore.dao.StockDao;
import com.medicalstore.entity.MedicineEntity;
import com.medicalstore.service.MedicineService;


@WebMvcTest(MedicineController.class)
 class MedNewTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicineService medicineService;
    @MockBean
    private StockDao stockDao;

    @Test
    void testGetAllMedicines_Success() throws Exception {
        when(medicineService.getAllMedicines()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/medicines/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
     void testGetMedicineById_Success() throws Exception {
        MedicineEntity mockMedicine = new MedicineEntity();
        mockMedicine.setId(1L);
        mockMedicine.setName("Test Medicine");
        when(medicineService.getMedicineById(1L)).thenReturn(mockMedicine);

        mockMvc.perform(get("/medicines/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Medicine"));
    }

    @Test
    void testAddMedicine_Success() throws Exception {
        MedicineEntity newMedicine = new MedicineEntity();
        newMedicine.setId(1L);
        newMedicine.setName("New Medicine");

        when(medicineService.saveMedicine(ArgumentMatchers.any(MedicineEntity.class))).thenReturn(newMedicine);

        mockMvc.perform(post("/medicines/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"New Medicine\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("New Medicine"));
    }

    @Test
     void testUpdateMedicineQuantity_Success() throws Exception {
        MedicineEntity updatedMedicine = new MedicineEntity();
        updatedMedicine.setId(1L);
        updatedMedicine.setName("Test Medicine");
        updatedMedicine.setQuantity(50);

        when(medicineService.updateMedicineQuantity(1L, 50)).thenReturn(updatedMedicine);

        mockMvc.perform(put("/medicines/quantityUpdate/1/50"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Medicine"))
                .andExpect(jsonPath("$.quantity").value(50));
    }

  

}

