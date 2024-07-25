package com.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalstore.dao.StockDao;
import com.medicalstore.entity.MedicineEntity;
import com.medicalstore.service.MedicineService;

@RestController
@RequestMapping("/medicines")
//@CrossOrigin(origins = "*")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;
    @Autowired
    private StockDao stockDao;
    
    //getMapping
    @GetMapping("all")
    public ResponseEntity<List<MedicineEntity>> getAllMedicines() {
        List<MedicineEntity> medicines = medicineService.getAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MedicineEntity> getMedicineById(@PathVariable Long id) {
        MedicineEntity medicine = medicineService.getMedicineById(id);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MedicineEntity> addMedicine(@RequestBody MedicineEntity medicine) {
        MedicineEntity newMedicine = medicineService.saveMedicine(medicine);
        return new ResponseEntity<>(newMedicine, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MedicineEntity> updateMedicine(@PathVariable Long id, @RequestBody MedicineEntity updatedMedicine) {
        MedicineEntity updatedMedicineEntity = medicineService.updateMedicine(id, updatedMedicine);
        return new ResponseEntity<>(updatedMedicineEntity, HttpStatus.OK);
    }

   

    @PutMapping("/quantityUpdate/{id}/{quantity}")
    public ResponseEntity<MedicineEntity> updateMedicineQuantity(@PathVariable("id") long id, @PathVariable("quantity") int quantity) {
        MedicineEntity updatedMedicine = medicineService.updateMedicineQuantity(id, quantity);
        return ResponseEntity.ok(updatedMedicine);
    }
    @PutMapping("/update")
    public MedicineEntity update(@RequestBody MedicineEntity medicine)
    {
    	return medicineService.update(medicine);
    }

    @GetMapping("/getName/{id}")
    public ResponseEntity<String> getMedicineNameById(@PathVariable Long id) {
        MedicineEntity medicine = medicineService.getMedicineById(id);
        return new ResponseEntity<>(medicine.getName(), HttpStatus.OK);
    }


}
