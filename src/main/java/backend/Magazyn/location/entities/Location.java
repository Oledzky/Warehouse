package backend.Magazyn.location.entities;

import backend.Magazyn.manufacturer.entities.Manufacturer;
import backend.Magazyn.storage.entities.Storage;
import backend.Magazyn.supplier.entities.Supplier;
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
@Table(name = "app_location")
public class Location {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "address")
  private String address;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "app_supplier_location",
      joinColumns = @JoinColumn(name = "location_id"),
      inverseJoinColumns = @JoinColumn(name = "supplier_id"))
  private List<Supplier> supplier;

  @ManyToMany(mappedBy = "location")
  private List<Manufacturer> manufacturer;

  @OneToMany(mappedBy = "location")
  private List<Storage> storage;

}
