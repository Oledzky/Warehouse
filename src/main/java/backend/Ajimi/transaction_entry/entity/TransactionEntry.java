package backend.Ajimi.transaction_entry.entity;

import backend.Ajimi.enums.TransactionType;
import backend.Ajimi.product.entities.Product;
import backend.Ajimi.transaction.entities.Transaction;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_transaction_entry")
public class TransactionEntry {

  @Column(name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "transaction_type")
  private TransactionType type;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "transaction_id", nullable = false)
  private Transaction transaction;
}
