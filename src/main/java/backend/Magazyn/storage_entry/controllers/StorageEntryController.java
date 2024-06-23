package backend.Magazyn.storage_entry.controllers;

import backend.Magazyn.storage_entry.entity.StorageEntry;
import backend.Magazyn.storage_entry.entity.StorageEntryDTO;
import backend.Magazyn.storage_entry.services.StorageEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/storage-entries")
@CrossOrigin
public class StorageEntryController {

  private final StorageEntryService storageEntryService;

  @Autowired
  public StorageEntryController(StorageEntryService storageEntryService) {
    this.storageEntryService = storageEntryService;
  }

  @PostMapping
  public ResponseEntity<StorageEntry> createStorageEntry(@RequestBody StorageEntry storageEntry) {
    StorageEntry savedStorageEntry = storageEntryService.saveStorageEntry(storageEntry);
    return ResponseEntity.ok(savedStorageEntry);
  }

  @GetMapping
  public ResponseEntity<List<StorageEntryDTO>> getAllStorageEntries() {
    List<StorageEntryDTO> storageEntries = storageEntryService.findAllStorageEntries();
    return ResponseEntity.ok(storageEntries);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StorageEntry> getStorageEntryById(@PathVariable UUID id) {
    StorageEntry storageEntry = storageEntryService.findStorageEntryById(id);
    if (storageEntry != null) {
      return ResponseEntity.ok(storageEntry);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/by-storage/{storageId}")
  public ResponseEntity<List<StorageEntry>> getStorageEntriesByStorageId(@PathVariable UUID storageId) {
    List<StorageEntry> storageEntries = storageEntryService.findStorageEntriesByStorageId(storageId);
    return ResponseEntity.ok(storageEntries);
  }

  @GetMapping("/by-product/{productId}")
  public ResponseEntity<List<StorageEntry>> getStorageEntriesByProductId(@PathVariable UUID productId) {
    List<StorageEntry> storageEntries = storageEntryService.findStorageEntriesByProductId(productId);
    return ResponseEntity.ok(storageEntries);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStorageEntry(@PathVariable UUID id) {
    storageEntryService.deleteStorageEntry(id);
    return ResponseEntity.ok().build();
  }
}
