package backend.Magazyn.transaction.entities;

import backend.Magazyn.delivery.entities.Delivery;
import backend.Magazyn.storage.entities.Storage;
import backend.Magazyn.transaction_entry.entity.TransactionEntry;
import backend.Magazyn.user.entities.User;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "app_transaction")
public class Transaction {
  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "date")
  private String date;

  @ManyToOne
  @JoinColumn(name = "delivery_id")
  private Delivery delivery;

  @OneToMany(mappedBy = "transaction")
  private List<TransactionEntry> transactionEntries;

  @ManyToOne
  @JoinColumn(name = "storage_id")
  private Storage storage;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
