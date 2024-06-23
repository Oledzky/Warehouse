package backend.Magazyn.transaction.services;

import backend.Magazyn.transaction.entities.Transaction;
import backend.Magazyn.transaction.entities.TransactionDTO;
import backend.Magazyn.transaction.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final TransactionRepository transactionRepository;

  @Autowired
  public TransactionService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public Transaction saveTransaction(Transaction transaction) {
    return transactionRepository.save(transaction);
  }

  public List<TransactionDTO> findAllTransactions() {
    List<Transaction> transactions = transactionRepository.findAll();
    return transactions.stream()
            .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
            .toList();
  }

  public Optional<Transaction> findTransactionById(UUID id) {
    return transactionRepository.findById(id);
  }

  public void deleteTransaction(UUID id) {
    transactionRepository.deleteById(id);
  }

  public List<Transaction> findTransactionsByTransactionId(UUID transactionId) {
    return transactionRepository.findTransactionBy(transactionId);
  }
}
