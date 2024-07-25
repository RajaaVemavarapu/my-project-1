package com.medicalstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicalstore.dao.ClientDao;
import com.medicalstore.dao.MedicineDao;
import com.medicalstore.dto.ClientDto;
import com.medicalstore.dto.MedicinDto;
import com.medicalstore.entity.Sales;
import com.medicalstore.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private SalesService salesService;
    @Autowired
    private MedicineDao medicineDao;

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> sales = salesService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @PostMapping("/purchaseMedicine")
    public ResponseEntity<Sales> purchaseMedicine(@RequestParam("clientId") Long clientId,
                                                   @RequestParam("medicineIds") Long medicineIds,
                                                   @RequestParam("quantitiesSold") Integer quantitiesSold) {
        Sales newSales = salesService.purchaseMedicine(clientId, medicineIds, quantitiesSold);
        return new ResponseEntity<>(newSales, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        salesService.deleteSaleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("client/{id}")
    public ClientDto get(@PathVariable("id") Long id)
    {
    	return clientDao.getClientById(id).getBody();
    }
    @GetMapping("/medicine/{id}")
    public MedicinDto getMedicineById(@PathVariable Long id) {
      return   medicineDao.getMedicineById(id).getBody();
        
    }
    @GetMapping("/client/{clientId}/sales")
    public ResponseEntity<List<Sales>> getSalesByClientId(@PathVariable Long clientId) {
        List<Sales> sales = salesService.getSalesByClientId(clientId);
        if (sales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
  //  @PatchMapping("/medicines/quantityUpdate/{id}/{quantity}")
  //  public ResponseEntity<MedicinDto> updateQuantity(@PathVariable("id") long id,@PathVariable("quantity") int quantity){
  //  	return medicineDao.updateMedicineQuantity(id, quantity);
 //   }
}
