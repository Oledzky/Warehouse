package backend.Ajimi.transaction_entry.repositories;

import backend.Ajimi.transaction_entry.entity.TransactionEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionEntryRepository extends JpaRepository<TransactionEntry, UUID> {
  @Query ("SELECT te FROM TransactionEntry te WHERE te.id = :transactionId")
  List<TransactionEntry> findByTransactionId(UUID transactionId);

  @Query ("SELECT te FROM TransactionEntry te WHERE te.product.id = :productId")
  List<TransactionEntry> findByProductId(UUID productId);
}
