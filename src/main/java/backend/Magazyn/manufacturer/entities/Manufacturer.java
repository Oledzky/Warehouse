package backend.Magazyn.manufacturer.entities;

import backend.Magazyn.location.entities.Location;
import backend.Magazyn.product.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "app_manufacturer")
public class Manufacturer {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "app_manufacturer_location",
      joinColumns = @JoinColumn(name = "manufacturer_id"),
      inverseJoinColumns = @JoinColumn(name = "location_id"))
  private List<Location> location;

  @OneToMany(mappedBy = "manufacturer")
  private List<Product> product;

}
