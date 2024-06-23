package backend.Magazyn.category.entity;

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
@Table(name = "app_category")
public class Category {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "category")
  private List<Product> products;

}
