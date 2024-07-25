package com.medicalstore.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalstore.dao.StockDao;
import com.medicalstore.entity.MedicineEntity;
import com.medicalstore.exception.MedicineNotFoundException;
import com.medicalstore.repository.MedicineRepository;

@Service
public class MedicineService {
	private final MedicineRepository medicineRepository;
    private final StockDao stockDao;

    // Constructor injection for dependency
    public MedicineService(MedicineRepository medicineRepository, StockDao stockDao) {
        this.medicineRepository = medicineRepository;
        this.stockDao = stockDao;
    }
    public List<MedicineEntity> getAllMedicines() {
        return medicineRepository.findAll();
    }


    public MedicineEntity getMedicineById(Long id) {
        // Retrieve medicine by ID from repository
        Optional<MedicineEntity> optionalMedicine = medicineRepository.findById(id);
        if (optionalMedicine.isEmpty()) {
            throw new MedicineNotFoundException("Medicine not found");
        }
        return optionalMedicine.get();
    }
    

    
    public MedicineEntity saveMedicine(MedicineEntity medicine) {

        return medicineRepository.save(medicine);
    }

	public List<MedicineEntity> getMedicinesByIds(List<Long> medicineIds) {
        List<MedicineEntity> medicines = new ArrayList<>();
        for (Long id : medicineIds) {
            MedicineEntity medicine = getMedicineById(id);
            if (medicine != null) {
                medicines.add(medicine);
            }
        }
        return medicines;
    }
	public MedicineEntity updateMedicineQuantity(Long id, int quantity) {
        // Fetch the medicine details by ID
        MedicineEntity medicine = medicineRepository.findById(id).get();
        
        // Check if the medicine exists
        if (medicine==null) {
            throw new MedicineNotFoundException("Medicine with ID " + id + " not found");
        }

        // Update the quantity
        int updatedQuantity = medicine.getQuantity() - quantity;
        medicine.setQuantity(updatedQuantity);

        // Save the updated medicine entity
        return medicineRepository.save(medicine);
    }
	
	public MedicineEntity update(MedicineEntity medicine) {
		return medicineRepository.save(medicine);
	}
	public MedicineEntity updateMedicine(Long id, MedicineEntity updatedMedicine) {
        MedicineEntity existingMedicine =  medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException("Medicine not found"));
 
        existingMedicine.setName(updatedMedicine.getName());
       
        existingMedicine.setPrice(updatedMedicine.getPrice());
        existingMedicine.setExpirationDate(updatedMedicine.getExpirationDate());

                existingMedicine.setManufacturingDate(updatedMedicine.getManufacturingDate());
        existingMedicine.setDescription(updatedMedicine.getDescription());
        existingMedicine.setQuantity(updatedMedicine.getQuantity());
 
        return medicineRepository.save(existingMedicine);
    }
	

	 
}

