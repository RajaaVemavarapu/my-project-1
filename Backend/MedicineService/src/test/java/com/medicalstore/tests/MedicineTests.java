//package com.medicalstore.tests;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;

//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.medicalstore.controller.MedicineController;
//import com.medicalstore.entity.MedicineEntity;
//import com.medicalstore.service.MedicineService;
//
//@ExtendWith(MockitoExtension.class)
//public class MedicineTests {
//
//    @Mock
//    private MedicineService medicineService;
//
//    @InjectMocks
//    private MedicineController medicineController;
//
//    private MedicineEntity testMedicine;
//
//    @BeforeEach
//    public void setUp() {
//        testMedicine = new MedicineEntity();
//        testMedicine.setId(1L);
//        testMedicine.setName("Test Medicine");
//        testMedicine.setDosage("Test Dosage");
//        testMedicine.setPrice(10.0);
//        testMedicine.setExpirationDate(LocalDate.now().plusDays(30));
//        testMedicine.setManufacturer("Test Manufacturer");
//        testMedicine.setBatchNumber("12345");
//        testMedicine.setManufacturingDate(LocalDate.now());
//        testMedicine.setDescription("Test Description");
//        testMedicine.setQuantity(100);
//    }
//
//    @Test
//    public void testGetAllMedicines() {
//        List<MedicineEntity> medicines = new ArrayList<>();
//        medicines.add(testMedicine);
//
//        when(medicineService.getAllMedicines()).thenReturn(medicines);
//
//        ResponseEntity<List<MedicineEntity>> response = medicineController.getAllMedicines();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(medicines, response.getBody());
//    }
//
//   
//    @Test
//    public void testAddMedicine() {
//        when(medicineService.saveMedicine(testMedicine)).thenReturn(testMedicine);
//
//        ResponseEntity<MedicineEntity> response = medicineController.addMedicine(testMedicine);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(testMedicine, response.getBody());
//    }
//
//    @Test
//    public void testUpdateMedicine() {
//        MedicineEntity updatedMedicine = testMedicine;
//        updatedMedicine.setName("Updated Test Medicine");
//
//        when(medicineService.updateMedicine(1L, updatedMedicine)).thenReturn(updatedMedicine);
//
//        ResponseEntity<MedicineEntity> response = medicineController.updateMedicine(1L, updatedMedicine);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(updatedMedicine, response.getBody());
//    }
//
//    @Test
//    public void testUpdateMedicineQuantity() {
//        int newQuantity = 200;
//
//        when(medicineService.updateMedicineQuantity(1L, newQuantity)).thenReturn(testMedicine);
//
//        ResponseEntity<MedicineEntity> response = medicineController.updateMedicineQuantity(1L, newQuantity);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(testMedicine, response.getBody());
//    }
//}
//
//    
//
//
package com.medicalstore.tests;


import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.medicalstore.controller.MedicineController;
import com.medicalstore.dto.StockDto;
import com.medicalstore.entity.MedicineEntity;
import com.medicalstore.exception.MedicineNotFoundException;
import com.medicalstore.exception.StockNotFoundException;
import com.medicalstore.repository.MedicineRepository;
import com.medicalstore.service.MedicineService;
 

@ExtendWith(MockitoExtension.class)

//@WebMvcTest(MedicineController.class)
 class MedicineTests {
	  @Autowired
	    private MockMvc mockMvc;

    @Mock
    private MedicineRepository medicineRepository;
    
    @InjectMocks
    private MedicineService medicineService;

    private MedicineEntity testMedicine;
    
    private StockDto stockDto;
   
    @Autowired
    private MedicineController medicineController;
    
   
   
    @BeforeEach
   
    public void setUp() {
        testMedicine = new MedicineEntity();
        stockDto = new StockDto();
        testMedicine.setId(1L);
        testMedicine.setName("Test Medicine");
       
        testMedicine.setPrice(10.0);
        testMedicine.setExpirationDate(LocalDate.now().plusDays(30));
        
        
        testMedicine.setManufacturingDate(LocalDate.now());
        testMedicine.setDescription("Test Description");
        testMedicine.setQuantity(100);
    }
    

    @Test
     void testGetAllMedicines() {
        List<MedicineEntity> medicines = new ArrayList<>();
        medicines.add(testMedicine);

        when(medicineRepository.findAll()).thenReturn(medicines);

        List<MedicineEntity> result = medicineService.getAllMedicines();

        assertEquals(medicines.size(), result.size());
        assertEquals(medicines.get(0), result.get(0));
    }





    @Test
    void testSaveMedicine() {
        when(medicineRepository.save(testMedicine)).thenReturn(testMedicine);

        MedicineEntity result = medicineService.saveMedicine(testMedicine);

        assertEquals(testMedicine, result);
    }

    @Test
    void testUpdateMedicine() {
        when(medicineRepository.findById(1L)).thenReturn(Optional.of(testMedicine));

        MedicineEntity updatedMedicine = new MedicineEntity();
        updatedMedicine.setId(1L);
        updatedMedicine.setName("Updated Test Medicine");
     
        updatedMedicine.setPrice(20.0);
        updatedMedicine.setExpirationDate(LocalDate.now().plusDays(60));
        
      
        updatedMedicine.setManufacturingDate(LocalDate.now().minusDays(10));
        updatedMedicine.setDescription("Updated Test Description");
        updatedMedicine.setQuantity(200);

        when(medicineRepository.save(testMedicine)).thenReturn(updatedMedicine);

        MedicineEntity result = medicineService.updateMedicine(1L, updatedMedicine);

        assertEquals(updatedMedicine, result);
    }

    @Test
     void testUpdateMedicine_NotFound() {
        when(medicineRepository.findById(2L)).thenReturn(Optional.empty());

        MedicineEntity updatedMedicine = new MedicineEntity();
        updatedMedicine.setId(2L);
        updatedMedicine.setName("Updated Test Medicine");

        MedicineNotFoundException exception = assertThrows(MedicineNotFoundException.class, () -> {
            medicineService.updateMedicine(2L, updatedMedicine);
        });

        assertEquals("Medicine not found", exception.getMessage());
    }

    @Test
     void testUpdateMedicineQuantity() {
        int initialQuantity = testMedicine.getQuantity();
        int updatedQuantity = 50; // For example, updating to 50

        when(medicineRepository.findById(1L)).thenReturn(Optional.of(testMedicine));

        // Calculate the expected quantity based on the current quantity and the update
        int expectedQuantity = initialQuantity - updatedQuantity;

        when(medicineRepository.save(testMedicine)).thenReturn(testMedicine);

        MedicineEntity result = medicineService.updateMedicineQuantity(1L, updatedQuantity);

        assertEquals(expectedQuantity, result.getQuantity());
    }



    @Test
    void testUpdateMedicineQuantity_NotFound() {
        when(medicineRepository.findById(2L)).thenReturn(Optional.empty());

        int newQuantity = 200;

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            medicineService.updateMedicineQuantity(2L, newQuantity);
        });

        assertEquals("No value present", exception.getMessage());
    }
    @Test
    void testMedicineToString() {
        String expectedString = "MedicineEntity [id=1, name=Test Medicine, price=10.0, expirationDate=" +
                LocalDate.now().plusDays(30) + ", manufacturingDate=" + LocalDate.now() +
                ", description=Test Description, quantity=100]";

        assertEquals(expectedString, testMedicine.toString());
    }
    @Test
    void testMedicineParameterizedConstructor() {
        Long id = 1L;
        String name = "Test Medicine";
        double price = 10.0;
        LocalDate expirationDate = LocalDate.now().plusDays(30);
        LocalDate manufacturingDate = LocalDate.now();
        String description = "Test Description";
        int quantity = 100;

        MedicineEntity medicine = new MedicineEntity(id, name, price, expirationDate, manufacturingDate, description, quantity);

        assertEquals(id, medicine.getId());
        assertEquals(name, medicine.getName());
        assertEquals(price, medicine.getPrice());
        assertEquals(expirationDate, medicine.getExpirationDate());
        assertEquals(manufacturingDate, medicine.getManufacturingDate());
        assertEquals(description, medicine.getDescription());
        assertEquals(quantity, medicine.getQuantity());
    }
    @Test
     void testSetAndGetId() {
        Long id = 1L;
        stockDto.setId(id);
        assertEquals(id, stockDto.getId());
    }
    @Test
     void testSetAndGetPurchasePrice() {
        double purchasePrice = 10.5;
        stockDto.setPurchasePrice(purchasePrice);
        assertEquals(purchasePrice, stockDto.getPurchasePrice(), 0.001); // delta for double comparison
    }
    @Test
     void testSetAndGetPurchaseDate() {
        String purchaseDate = "2024-04-14";
        stockDto.setPurchaseDate(purchaseDate);
        assertEquals(purchaseDate, stockDto.getPurchaseDate());
    }
    @Test
     void testSetAndGetReorderLevel() {
        int reorderLevel = 5;
        stockDto.setReorderLevel(reorderLevel);
        assertEquals(reorderLevel, stockDto.getReorderLevel());
    }

    @Test
     void testSetAndGetLocation() {
        String location = "Storage Room";
        stockDto.setLocation(location);
        assertEquals(location, stockDto.getLocation());
    }
    @Test
    void testExceptionMessage() {
        String message = "Stock not found";
        StockNotFoundException exception = new StockNotFoundException(message);
        assertEquals(message, exception.getMessage());
    }
    @Test
    void testResponseStatusAnnotation() throws NoSuchMethodException {
        ResponseStatus annotation = StockNotFoundException.class.getAnnotation(ResponseStatus.class);
        assertEquals(HttpStatus.NOT_FOUND, annotation.value());
    }
    
    
    
    
    
    
    
    
    
    @Test
    void testGetMedicineByIdNotFound() {
        // Mocking behavior of repository
        when(medicineRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(MedicineNotFoundException.class, () -> {
            medicineService.getMedicineById(1L);
        });
    }
    @Test
     void testUpdateMedicines() {
        // Create a mock instance of MedicineEntity
        MedicineEntity mockMedicine = new MedicineEntity();
        mockMedicine.setId(1L);
        mockMedicine.setName("Test Medicine");
        mockMedicine.setPrice(10.5);
        mockMedicine.setQuantity(20);
        
        // Mocking behavior of repository
        when(medicineRepository.save(mockMedicine)).thenReturn(mockMedicine);

        // Call the update method
        MedicineEntity updatedMedicine = medicineService.update(mockMedicine);

        // Assert the properties of updatedMedicine
        assertEquals("Test Medicine", updatedMedicine.getName());
        assertEquals(10.5, updatedMedicine.getPrice(), 0.001);
        assertEquals(20, updatedMedicine.getQuantity());
    }
    @Test
     void testGetMedicinesByIds() {
        List<Long> medicineIds = new ArrayList<>();
        medicineIds.add(1L);
        medicineIds.add(2L);

        // Stubbing behavior of repository
        when(medicineRepository.findById(1L)).thenReturn(Optional.of(new MedicineEntity()));
        when(medicineRepository.findById(2L)).thenReturn(Optional.of(new MedicineEntity()));

        List<MedicineEntity> medicines = medicineService.getMedicinesByIds(medicineIds);

        // Asserting size of the list
        assertEquals(2, medicines.size(), "List size should be 2");

        // Asserting non-nullness of each element
        for (MedicineEntity medicine : medicines) {
            // Check if each element is not null
            if (medicine == null) {
                fail("Medicine should not be null");
            }
        }
    }
    
    @Test
     void testGetMedicineById() {
        // Create a new MedicineEntity for stubbing behavior of repository
        MedicineEntity mockMedicine = new MedicineEntity();
        mockMedicine.setId(1L);
        mockMedicine.setName("Test Medicine");
        mockMedicine.setPrice(10.5);
        mockMedicine.setQuantity(20);

        // Stubbing behavior of repository to return Optional.of(mockMedicine)
        when(medicineRepository.findById(1L)).thenReturn(Optional.of(mockMedicine));

        MedicineEntity medicine = medicineService.getMedicineById(1L);

        // Asserting properties of the returned medicine
        assertEquals("Test Medicine", medicine.getName());
        assertEquals(10.5, medicine.getPrice(), 0.001);
        assertEquals(20, medicine.getQuantity());
    }
    @Test
    void testMedicineEntityConstructor() {
        // Prepare test data
        long id = 1L;
        String name = "Test Medicine";
        double price = 10.5;
        int quantity = 20;

        // Create an instance of MedicineEntity using the constructor
        MedicineEntity medicine = new MedicineEntity(id, name, price, quantity);

        // Verify that the attributes are set correctly
        assertEquals(id, medicine.getId());
        assertEquals(name, medicine.getName());
        assertEquals(price, medicine.getPrice(), 0.001); // delta for double comparison
        assertEquals(quantity, medicine.getQuantity());
    }
    @Test
    void contextLoads() {
        // Sample assertion test case
        int expected = 10;
        int actual = 5 + 5;

        // Asserting that the sum of 5 + 5 equals 10
        assertEquals(expected, actual);
    }
    

    
    
   

    
    


   
}
