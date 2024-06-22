package backend.Ajimi.storage_entry.entity;

import backend.Ajimi.product.entities.Product;
import backend.Ajimi.storage.entities.Storage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_storage_entry")
public class StorageEntry {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "available_quantity")
  private int availableQuantity;

  @Column(name = "destination")
  private String destination;


  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "storage_id", nullable = false)
  private Storage storage;
}
