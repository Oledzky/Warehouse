package backend.Ajimi.delivery.entities;

import backend.Ajimi.order.entities.Order;
import backend.Ajimi.transaction.entities.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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
