package com.medicalStore.tests;



import static org.junit.jupiter.api.Assertions.assertEquals; // Import for Assert class
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.medicalStore.controller.CartServiceController;
import com.medicalStore.dao.ClientDao;
import com.medicalStore.dao.MedicineDao;
import com.medicalStore.dto.ClientDto;
import com.medicalStore.dto.MedicineDto;
import com.medicalStore.entity.CartServiceEntity;
import com.medicalStore.exception.ResourceNotFoundException;
import com.medicalStore.service.CartService;
 class CartTests {

    @InjectMocks
    private CartServiceController cartServiceController;

    @Mock
    private CartService cartService;

    @Mock
    private ClientDao clientDao;

    @Mock
    private MedicineDao medicineDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCart() {
        CartServiceEntity cartEntity = new CartServiceEntity(1L, 1L, 1L);
        when(cartService.saveCart(cartEntity)).thenReturn(cartEntity);

        ResponseEntity<CartServiceEntity> response = cartServiceController.addAdmin(cartEntity);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertEquals(cartEntity, response.getBody());
    }

    @Test
    public void testGetCart() {
        CartServiceEntity cartEntity = new CartServiceEntity(1L, 1L, 1L);
        when(cartService.getCart(1L)).thenReturn(cartEntity);

        CartServiceEntity retrievedCart = cartServiceController.getCart(1L);

        assertEquals(cartEntity, retrievedCart);
    }

    @Test
    public void testGetClientById() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(1L);
        when(clientDao.getClientById(1L)).thenReturn(ResponseEntity.ok(clientDto));

        ResponseEntity<ClientDto> response = cartServiceController.getClientById(1L);

        assertEquals(clientDto, response.getBody());
    }

    @Test
    public void testGetClientById_NotFound() {
        when(clientDao.getClientById(1L)).thenReturn(null);

        try {
            cartServiceController.getClientById(1L);
        } catch (ResourceNotFoundException ex) {
            assertEquals("Client Not Found", ex.getMessage());
        }
    }

    @Test
    public void testGetMedicineById() {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setId(1L);
        when(medicineDao.getMedicineById(1L)).thenReturn(ResponseEntity.ok(medicineDto));

        ResponseEntity<MedicineDto> response = cartServiceController.getMedicineById(1L);

        assertEquals(medicineDto, response.getBody());
    }

    @Test
    public void testGetMedicineById_NotFound() {
        when(medicineDao.getMedicineById(1L)).thenReturn(null);

        try {
            cartServiceController.getMedicineById(1L);
        } catch (ResourceNotFoundException ex) {
            assertEquals("medicine Not Found", ex.getMessage());
        }
    }
    @Test
    public void testConstructorAndGetters() {
        // Create a CartServiceEntity object using the constructor
        CartServiceEntity cartEntity = new CartServiceEntity(1L, 2L, 3L);

        // Test that the constructor sets the fields correctly
        assertEquals(1L, cartEntity.getId());
        assertEquals(2L, cartEntity.getMedicineId());
        assertEquals(3L, cartEntity.getClientId());
    }

    @Test
    public void testSetters() {
        // Create a CartServiceEntity object
        CartServiceEntity cartEntity = new CartServiceEntity();

        // Set values using setters
        cartEntity.setId(1L);
        cartEntity.setMedicineId(2L);
        cartEntity.setClientId(3L);

        // Test that the setters update the fields correctly
        assertEquals(1L, cartEntity.getId());
        assertEquals(2L, cartEntity.getMedicineId());
        assertEquals(3L, cartEntity.getClientId());
    }

    @Test
    public void testToString() {
        // Create a CartServiceEntity object
        CartServiceEntity cartEntity = new CartServiceEntity(1L, 2L, 3L);

        // Test that the toString method returns the expected string representation
        assertEquals("CartServiceEntity [id=1, medicineId=2, clientId=3]", cartEntity.toString());
    }
    @Test
    public void testGettersAndSetters() {
        // Create a MedicineDto object
        MedicineDto medicineDto = new MedicineDto();

        // Set values using setters
        medicineDto.setId(1L);
        medicineDto.setName("Paracetamol");
        medicineDto.setDosage("500mg");
        medicineDto.setPrice(10.50);
        medicineDto.setExpirationDate(LocalDate.of(2024, 12, 31));
        medicineDto.setManufacturer("Manufacturer");
        medicineDto.setBatchNumber("12345");
        medicineDto.setManufacturingDate(LocalDate.of(2024, 1, 1));
        medicineDto.setDescription("Description");
        medicineDto.setStockId(1001L);

        // Test that getters return the correct values
        assertEquals(1L, medicineDto.getId());
        assertEquals("Paracetamol", medicineDto.getName());
        assertEquals("500mg", medicineDto.getDosage());
        assertEquals(10.50, medicineDto.getPrice());
        assertEquals(LocalDate.of(2024, 12, 31), medicineDto.getExpirationDate());
        assertEquals("Manufacturer", medicineDto.getManufacturer());
        assertEquals("12345", medicineDto.getBatchNumber());
        assertEquals(LocalDate.of(2024, 1, 1), medicineDto.getManufacturingDate());
        assertEquals("Description", medicineDto.getDescription());
        assertEquals(1001L, medicineDto.getStockId());
    }

    @Test
    public void testToString1() {
        // Create a MedicineDto object
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setId(1L);
        medicineDto.setName("Paracetamol");
        medicineDto.setDosage("500mg");
        medicineDto.setPrice(10.50);
        medicineDto.setExpirationDate(LocalDate.of(2024, 12, 31));
        medicineDto.setManufacturer("Manufacturer");
        medicineDto.setBatchNumber("12345");
        medicineDto.setManufacturingDate(LocalDate.of(2024, 1, 1));
        medicineDto.setDescription("Description");
        medicineDto.setStockId(1001L);

        // Test that the toString method returns the expected string representation
        assertEquals("MedicineDto [id=1, name=Paracetamol, dosage=500mg, price=10.5, expirationDate=2024-12-31, manufacturer=Manufacturer, batchNumber=12345, manufacturingDate=2024-01-01, description=Description, stockId=1001]", medicineDto.toString());
    }
    @Test
    public void testGettersAndSetters1() {
        // Create a ClientDto object
        ClientDto clientDto = new ClientDto();

        // Set values using setters
        clientDto.setId(1L);
        clientDto.setFirstName("John");
        clientDto.setLastName("Doe");
        clientDto.setContactNumber("1234567890");
        clientDto.setAddress("123 Main St, City");
        clientDto.setEmail("john.doe@example.com");
        clientDto.setDateOfBirth("1990-01-01");
        clientDto.setUsername("johndoe");
        clientDto.setPassword("password123");

        // Test that getters return the correct values
        assertEquals(1L, clientDto.getId());
        assertEquals("John", clientDto.getFirstName());
        assertEquals("Doe", clientDto.getLastName());
        assertEquals("1234567890", clientDto.getContactNumber());
        assertEquals("123 Main St, City", clientDto.getAddress());
        assertEquals("john.doe@example.com", clientDto.getEmail());
        assertEquals("1990-01-01", clientDto.getDateOfBirth());
        assertEquals("johndoe", clientDto.getUsername());
        assertEquals("password123", clientDto.getPassword());
    }
}
