package backend.Magazyn.transaction_entry.entity;

import backend.Magazyn.enums.TransactionType;
import backend.Magazyn.product.entities.Product;
import backend.Magazyn.transaction.entities.Transaction;
import jakarta.persistence.*;
import java.util.UUID;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
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
