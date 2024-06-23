package backend.Ajimi.manufacturer.controllers;

import backend.Ajimi.manufacturer.entities.Manufacturer;
import backend.Ajimi.manufacturer.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

  private final ManufacturerService manufacturerService;

  @Autowired
  public ManufacturerController(ManufacturerService manufacturerService) {
    this.manufacturerService = manufacturerService;
  }

  @PostMapping
  public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
    Manufacturer savedManufacturer = manufacturerService.saveManufacturer(manufacturer);
    return ResponseEntity.ok(savedManufacturer);
  }

  @GetMapping
  public ResponseEntity<List<Manufacturer>> getAllManufacturers() {
    List<Manufacturer> manufacturers = manufacturerService.findAllManufacturers();
    return ResponseEntity.ok(manufacturers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable UUID id) {
    return manufacturerService.findManufacturerById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/search")
  public ResponseEntity<Manufacturer> getManufacturerByName(@RequestParam String name) {
    Manufacturer manufacturer = manufacturerService.findManufacturerByName(name);
    return ResponseEntity.ok(manufacturer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteManufacturer(@PathVariable UUID id) {
    manufacturerService.deleteManufacturer(id);
    return ResponseEntity.ok().build();
  }
}
