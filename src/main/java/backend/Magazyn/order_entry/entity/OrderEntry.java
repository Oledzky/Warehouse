package backend.Magazyn.order_entry.entity;

import backend.Magazyn.order.entities.Order;
import backend.Magazyn.product.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
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
