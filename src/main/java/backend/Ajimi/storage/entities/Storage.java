package backend.Ajimi.storage.entities;

import backend.Ajimi.enums.StorageType;
import backend.Ajimi.location.entities.Location;
import backend.Ajimi.product.entities.Product;
import backend.Ajimi.transaction.entities.Transaction;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_storage")
public class Storage {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "capacity")
  private String capacity;

  @Column(name = "type")
  private StorageType type;

  @OneToMany(mappedBy = "storage")
  private List<Location> locations;

  @OneToMany(mappedBy = "storage")
  private List<Transaction> transactions;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "app_product_storage",
      joinColumns = @JoinColumn(name = "storage_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;
}
