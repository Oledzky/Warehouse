package backend.Ajimi.transaction.entities;

import backend.Ajimi.delivery.entities.Delivery;
import backend.Ajimi.product.entities.Product;
import backend.Ajimi.storage.entities.Storage;
import backend.Ajimi.user.entities.User;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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
  private List<Product> products;

  @ManyToOne
  @JoinColumn(name = "storage_id")
  private Storage storage;

//  @ManyToOne
//  @JoinColumn(name = "user_id")
//  private User user;
}
