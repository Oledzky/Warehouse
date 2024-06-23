package backend.Magazyn.storage.controllers;

import backend.Magazyn.enums.StorageType;
import backend.Magazyn.storage.entities.Storage;
import backend.Magazyn.storage.entities.StorageDTO;
import backend.Magazyn.storage.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/storages")
@CrossOrigin
public class StorageController {

  private final StorageService storageService;

  @Autowired
  public StorageController(StorageService storageService) {
    this.storageService = storageService;
  }

  @PostMapping
  public ResponseEntity<Storage> createStorage(@RequestBody Storage storage) {
    Storage savedStorage = storageService.saveStorage(storage);
    return ResponseEntity.ok(savedStorage);
  }

  @GetMapping
  public ResponseEntity<List<StorageDTO>> getAllStorages() {
    List<StorageDTO> storages = storageService.findAllStorages();
    return ResponseEntity.ok(storages);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Storage> getStorageById(@PathVariable UUID id) {
    return storageService.findStorageById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/type")
  public ResponseEntity<List<Storage>> getStoragesByType(@RequestParam StorageType type) {
    List<Storage> storages = storageService.findStoragesByType(type);
    return ResponseEntity.ok(storages);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStorage(@PathVariable UUID id) {
    storageService.deleteStorage(id);
    return ResponseEntity.ok().build();
  }
}
