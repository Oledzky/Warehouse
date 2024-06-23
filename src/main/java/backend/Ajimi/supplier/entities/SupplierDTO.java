package backend.Ajimi.supplier.entities;

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
public class SupplierDTO {

  UUID id;
  String name;
  String email;
  String phone;
  List<UUID> locationsIds;
  List<UUID> productsIds;
}
