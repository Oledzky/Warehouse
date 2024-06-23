package backend.Magazyn.order_entry.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntryDTO {

  UUID id;
  int quantity;
  int price;
  UUID productId;
  UUID orderId;

}
