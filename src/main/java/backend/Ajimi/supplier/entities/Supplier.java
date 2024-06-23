package backend.Ajimi.supplier.entities;

import backend.Ajimi.location.entities.Location;
import backend.Ajimi.product.entities.Product;
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
@Table(name = "app_supplier")
public class Supplier {

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
      name = "app_supplier_location",
      joinColumns = @JoinColumn(name = "supplier_id"),
      inverseJoinColumns = @JoinColumn(name = "location_id"))
  private List<Location> locations;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "app_supplier_product",
      joinColumns = @JoinColumn(name = "supplier_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;
}
