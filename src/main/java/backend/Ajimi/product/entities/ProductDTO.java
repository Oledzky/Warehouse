package backend.Ajimi.product.entities;

import backend.Ajimi.category.entity.Category;
import backend.Ajimi.enums.StorageType;
import backend.Ajimi.manufacturer.entities.Manufacturer;
import backend.Ajimi.order_entry.entity.OrderEntry;
import backend.Ajimi.storage_entry.entity.StorageEntry;
import backend.Ajimi.supplier.entities.Supplier;
import backend.Ajimi.transaction_entry.entity.TransactionEntry;
import jakarta.persistence.*;
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


