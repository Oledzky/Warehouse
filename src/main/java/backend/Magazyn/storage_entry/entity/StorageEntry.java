package backend.Magazyn.storage_entry.entity;

import backend.Magazyn.product.entities.Product;
import backend.Magazyn.storage.entities.Storage;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
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
