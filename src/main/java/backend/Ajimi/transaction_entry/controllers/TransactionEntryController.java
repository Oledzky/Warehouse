package backend.Ajimi.transaction_entry.controllers;

import backend.Ajimi.transaction_entry.entity.TransactionEntry;
import backend.Ajimi.transaction_entry.services.TransactionEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction-entries")
public class TransactionEntryController {

  private final TransactionEntryService transactionEntryService;

  @Autowired
  public TransactionEntryController(TransactionEntryService transactionEntryService) {
    this.transactionEntryService = transactionEntryService;
  }

  @PostMapping
  public ResponseEntity<TransactionEntry> createTransactionEntry(@RequestBody TransactionEntry transactionEntry) {
    TransactionEntry savedTransactionEntry = transactionEntryService.saveTransactionEntry(transactionEntry);
    return ResponseEntity.ok(savedTransactionEntry);
  }

  @GetMapping
  public ResponseEntity<List<TransactionEntry>> getAllTransactionEntries() {
    List<TransactionEntry> transactionEntries = transactionEntryService.findAllTransactionEntries();
    return ResponseEntity.ok(transactionEntries);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TransactionEntry> getTransactionEntryById(@PathVariable UUID id) {
    return transactionEntryService.findTransactionEntryById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/by-transaction/{transactionId}")
  public ResponseEntity<List<TransactionEntry>> getTransactionEntriesByTransactionId(@PathVariable UUID transactionId) {
    List<TransactionEntry> transactionEntries = transactionEntryService.findTransactionEntriesByTransactionId(transactionId);
    return ResponseEntity.ok(transactionEntries);
  }

  @GetMapping("/by-product/{productId}")
  public ResponseEntity<List<TransactionEntry>> getTransactionEntriesByProductId(@PathVariable UUID productId) {
    List<TransactionEntry> transactionEntries = transactionEntryService.findTransactionEntriesByProductId(productId);
    return ResponseEntity.ok(transactionEntries);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTransactionEntry(@PathVariable UUID id) {
    transactionEntryService.deleteTransactionEntry(id);
    return ResponseEntity.ok().build();
  }
}
