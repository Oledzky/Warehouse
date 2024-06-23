package backend.Magazyn.delivery.entities;

import backend.Magazyn.order.entities.Order;
import backend.Magazyn.transaction.entities.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "app_delivery")
public class Delivery {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "address")
  private String address;

  @Column(name = "status")
  private String status;

  @Column(name = "date")
  private String deliveryDate;

  @ManyToMany(mappedBy = "delivery")
  private List<Order> order;

  @OneToMany(mappedBy = "delivery")
  private List<Transaction> transaction;

}
