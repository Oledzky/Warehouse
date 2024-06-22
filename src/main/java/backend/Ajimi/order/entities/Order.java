package backend.Ajimi.order.entities;

import backend.Ajimi.delivery.entities.Delivery;
import backend.Ajimi.enums.Status;
import backend.Ajimi.product.entities.Product;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_order")
public class Order {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "status")
  private Status status;

  @Column(name = "total")
  private double total;

  @Column(name = "delivery_id")
  private UUID deliveryId;

  @Column(name = "manufacturer_id")
  private UUID manufacturerId;

  @Column(name = "created_at")
  private String createdAt;

  @Column(name = "updated_at")
  private String updatedAt;

  @Column(name = "deleted_at")
  private String deletedAt;

//  @ManyToMany(mappedBy = "order")
//  private List<Product> product;
//
//  @ManyToMany(mappedBy = "order")
//  private List<Delivery> delivery;
}
