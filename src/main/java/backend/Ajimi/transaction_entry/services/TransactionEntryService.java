package backend.Ajimi.transaction_entry.services;

import backend.Ajimi.transaction_entry.entity.TransactionEntry;
import backend.Ajimi.transaction_entry.repositories.TransactionEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionEntryService {

  private final TransactionEntryRepository transactionEntryRepository;

  @Autowired
  public TransactionEntryService(TransactionEntryRepository transactionEntryRepository) {
    this.transactionEntryRepository = transactionEntryRepository;
  }

  public TransactionEntry saveTransactionEntry(TransactionEntry transactionEntry) {
    return transactionEntryRepository.save(transactionEntry);
  }

  public List<TransactionEntry> findAllTransactionEntries() {
    return transactionEntryRepository.findAll();
  }

  public Optional<TransactionEntry> findTransactionEntryById(UUID id) {
    return transactionEntryRepository.findById(id);
  }

  public List<TransactionEntry> findTransactionEntriesByTransactionId(UUID transactionId) {
    return transactionEntryRepository.findByTransactionId(transactionId);
  }

  public List<TransactionEntry> findTransactionEntriesByProductId(UUID productId) {
    return transactionEntryRepository.findByProductId(productId);
  }

  public void deleteTransactionEntry(UUID id) {
    transactionEntryRepository.deleteById(id);
  }
}
