package backend.Ajimi.storage_entry.entity;

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
}
