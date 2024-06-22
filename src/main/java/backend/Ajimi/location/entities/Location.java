package backend.Ajimi.location.entities;

import backend.Ajimi.manufacturer.entities.Manufacturer;
import backend.Ajimi.storage.entities.Storage;
import backend.Ajimi.supplier.entities.Supplier;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_location")
public class Location {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "address")
  private String address;

//  @ManyToMany(mappedBy = "location")
//  private List<Supplier> supplier;
//
//  @ManyToMany(mappedBy = "location")
//  private List<Manufacturer> manufacturer;

//  @ManyToOne
//  @JoinColumn(name = "storage_id")
//  private Storage storage;

}
