package backend.Magazyn.storage.entities;

import backend.Magazyn.enums.StorageType;
import backend.Magazyn.location.entities.Location;
import backend.Magazyn.storage_entry.entity.StorageEntry;
import backend.Magazyn.transaction.entities.Transaction;
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

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;

  @OneToMany(mappedBy = "storage")
  private List<Transaction> transactions;

@OneToMany(mappedBy = "storage")
  private List<StorageEntry> storageEntries;
}
