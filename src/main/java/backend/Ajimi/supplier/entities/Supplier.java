package backend.Ajimi.supplier.entities;

import backend.Ajimi.location.entities.Location;
import backend.Ajimi.product.entities.Product;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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

//  @ManyToMany(mappedBy = "suppliers")
//  private List<Location> locations;
//
//  @ManyToMany(mappedBy = "suppliers")
//  private List<Product> products;
}
