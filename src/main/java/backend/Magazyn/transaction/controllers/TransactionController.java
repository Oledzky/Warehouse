package backend.Magazyn.transaction.controllers;

import backend.Magazyn.transaction.entities.Transaction;
import backend.Magazyn.transaction.entities.TransactionDTO;
import backend.Magazyn.transaction.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionController {

  private final TransactionService transactionService;

  @Autowired
  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping
  public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
    Transaction savedTransaction = transactionService.saveTransaction(transaction);
    return ResponseEntity.ok(savedTransaction);
  }

  @GetMapping
  public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
    List<TransactionDTO> transactions = transactionService.findAllTransactions();
    return ResponseEntity.ok(transactions);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
    return transactionService.findTransactionById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTransaction(@PathVariable UUID id) {
    transactionService.deleteTransaction(id);
    return ResponseEntity.ok().build();
  }
}
