package backend.Ajimi.order_entry.entity;

import backend.Ajimi.order.entities.Order;
import backend.Ajimi.product.entities.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_order_entry")
public class OrderEntry {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "price")
  private int price;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;
}
