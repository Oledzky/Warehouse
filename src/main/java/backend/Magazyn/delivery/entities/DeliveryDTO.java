package backend.Magazyn.delivery.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryDTO {

  UUID id;
  String address;
  String status;
  String deliveryDate;
  List<UUID> orderId;
  List<UUID> transactionId;
}
