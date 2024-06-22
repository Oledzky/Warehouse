package backend.Ajimi.transaction_entry.entity;

import backend.Ajimi.enums.TransactionType;
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
}
