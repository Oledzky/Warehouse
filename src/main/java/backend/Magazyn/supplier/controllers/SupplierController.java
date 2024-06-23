package backend.Magazyn.supplier.controllers;

import backend.Magazyn.supplier.entities.Supplier;
import backend.Magazyn.supplier.entities.SupplierDTO;
import backend.Magazyn.supplier.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin
public class SupplierController {

  private final SupplierService supplierService;

  @Autowired
  public SupplierController(SupplierService supplierService) {
    this.supplierService = supplierService;
  }

  @PostMapping
  public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
    Supplier savedSupplier = supplierService.saveSupplier(supplier);
    return ResponseEntity.ok(savedSupplier);
  }

  @GetMapping
  public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
    List<SupplierDTO> suppliers = supplierService.findAllSuppliers();
    return ResponseEntity.ok(suppliers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Supplier> getSupplierById(@PathVariable UUID id) {
    return supplierService.findSupplierById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/search")
  public ResponseEntity<List<Supplier>> getSuppliersByName(@RequestParam String name) {
    List<Supplier> suppliers = supplierService.findSuppliersByName(name);
    return ResponseEntity.ok(suppliers);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSupplier(@PathVariable UUID id) {
    supplierService.deleteSupplier(id);
    return ResponseEntity.ok().build();
  }
}
