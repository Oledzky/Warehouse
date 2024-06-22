package backend.Ajimi.manufacturer.entities;

import backend.Ajimi.location.entities.Location;
import backend.Ajimi.product.entities.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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

//  @ManyToMany(mappedBy = "manufacturer")
//  private List<Location> location;
//
//  @OneToMany(mappedBy = "manufacturer")
//  private List<Product> product;

}
