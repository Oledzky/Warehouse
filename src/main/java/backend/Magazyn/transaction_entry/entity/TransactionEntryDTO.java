package backend.Magazyn.transaction_entry.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionEntryDTO {
  UUID id;
  int quantity;
  int price;
  UUID productId;
  UUID transactionId;
}
