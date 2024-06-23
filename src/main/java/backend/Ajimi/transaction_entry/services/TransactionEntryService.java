package backend.Ajimi.transaction_entry.services;

import backend.Ajimi.transaction_entry.entity.TransactionEntry;
import backend.Ajimi.transaction_entry.entity.TransactionEntryDTO;
import backend.Ajimi.transaction_entry.repositories.TransactionEntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionEntryService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final TransactionEntryRepository transactionEntryRepository;

  @Autowired
  public TransactionEntryService(TransactionEntryRepository transactionEntryRepository) {
    this.transactionEntryRepository = transactionEntryRepository;
  }

  public TransactionEntry saveTransactionEntry(TransactionEntry transactionEntry) {
    return transactionEntryRepository.save(transactionEntry);
  }

  public List<TransactionEntryDTO> findAllTransactionEntries() {
    List<TransactionEntry> transactionEntries = transactionEntryRepository.findAll();
    return transactionEntries.stream()
            .map(transactionEntry -> modelMapper.map(transactionEntry, TransactionEntryDTO.class))
            .toList();
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
