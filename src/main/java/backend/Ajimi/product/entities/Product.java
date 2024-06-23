package backend.Ajimi.product.entities;

import backend.Ajimi.category.entity.Category;
import backend.Ajimi.enums.StorageType;
import backend.Ajimi.manufacturer.entities.Manufacturer;
import backend.Ajimi.order_entry.entity.OrderEntry;
import backend.Ajimi.storage_entry.entity.StorageEntry;
import backend.Ajimi.supplier.entities.Supplier;
import backend.Ajimi.transaction_entry.entity.TransactionEntry;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "app_product")
public class Product {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "measurement_unit")
  private String measurementUnit;

  @Column(name = "storage_type")
  private StorageType storageType;

  @Column(name = "price")
  private int price;

  @ManyToOne
  @JoinColumn(name = "manufacturer_id")
  private Manufacturer manufacturer;

  @OneToMany(mappedBy = "product")
  private List<TransactionEntry> transactionEntries;

  @OneToMany(mappedBy = "product")
  private List<StorageEntry> storageEntries;

  @ManyToMany(mappedBy = "products")
  private List<Supplier> suppliers;

  @OneToMany(mappedBy = "product")
  private List<OrderEntry> orderEntries;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;


}
