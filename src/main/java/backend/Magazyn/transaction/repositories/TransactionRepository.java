package backend.Magazyn.transaction.repositories;

import backend.Magazyn.transaction.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

  @Query("SELECT t FROM Transaction t WHERE t.id = ?1")
  List<Transaction> findTransactionBy(UUID id);
}
