package backend.Ajimi.transaction.services;

import backend.Ajimi.transaction.entities.Transaction;
import backend.Ajimi.transaction.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

  private final TransactionRepository transactionRepository;

  @Autowired
  public TransactionService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public Transaction saveTransaction(Transaction transaction) {
    return transactionRepository.save(transaction);
  }

  public List<Transaction> findAllTransactions() {
    return transactionRepository.findAll();
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
