package backend.Magazyn.order.entities;

import backend.Magazyn.delivery.entities.Delivery;
import backend.Magazyn.enums.Status;
import backend.Magazyn.order_entry.entity.OrderEntry;
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

  @OneToMany(mappedBy = "order")
  private List<OrderEntry> orderEntries;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "app_order_entry",
      joinColumns = @JoinColumn(name = "delivery_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Delivery> delivery;
}
