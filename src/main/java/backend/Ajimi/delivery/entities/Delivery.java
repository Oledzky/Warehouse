package backend.Ajimi.delivery.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

  @Column(name = "estimated_date")
  private String estimatedDate;

  @Column(name = "actual_date")
  private String actualDate;


}
