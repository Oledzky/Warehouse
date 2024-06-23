package backend.Ajimi.storage.entities;

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
public class StorageDTO {

  UUID id;
  String name;
  String capacity;
  String type;
  List<UUID> locationsIds;
  List<UUID> transactionsIds;
  List<UUID> storageEntriesIds;
}
