package backend.Magazyn.order.entities;

import backend.Magazyn.enums.Status;
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
public class OrderDTO {

  UUID id;
  Status status;
  double total;
  UUID deliveryId;
  UUID manufacturerId;
  String createdAt;
  String updatedAt;
  List<UUID> orderEntriesIds;
  List<UUID> deliveryIds;
}
