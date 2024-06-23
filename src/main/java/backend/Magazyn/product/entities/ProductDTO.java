package backend.Magazyn.product.entities;

import backend.Magazyn.enums.StorageType;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

  UUID id;
  String name;
  String description;
  String measurementUnit;
  StorageType storageType;
  int price;
  UUID manufacturerId;
  List<UUID> transactionEntries;
  List<UUID> storageEntries;
  List<UUID> suppliers;
  List<UUID> orderEntries;
  UUID categoryId;
}


