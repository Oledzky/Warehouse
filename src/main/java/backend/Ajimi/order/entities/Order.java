package backend.Ajimi.order.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
  private String status;

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

}
