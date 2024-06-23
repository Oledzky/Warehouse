package backend.Magazyn.storage_entry.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StorageEntryDTO {

  UUID id;
  int availableQuantity;
  String destination;
  UUID productId;
  UUID storageId;
}
