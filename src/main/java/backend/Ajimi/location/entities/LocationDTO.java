package backend.Ajimi.location.entities;

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
public class LocationDTO {

  UUID id;
  String address;
  List<UUID> suppliersIds;
  List<UUID> manufacturerIds;
  UUID storageId;

}
