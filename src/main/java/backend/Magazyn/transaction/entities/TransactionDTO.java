package backend.Magazyn.transaction.entities;

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
public class TransactionDTO {

  UUID id;
  String date;
  UUID deliveryId;
  UUID storageId;
  UUID userId;
  List<UUID> transactionEntryIds;
}
