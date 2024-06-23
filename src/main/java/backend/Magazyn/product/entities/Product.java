package backend.Magazyn.product.entities;

import backend.Magazyn.category.entity.Category;
import backend.Magazyn.enums.StorageType;
import backend.Magazyn.manufacturer.entities.Manufacturer;
import backend.Magazyn.order_entry.entity.OrderEntry;
import backend.Magazyn.storage_entry.entity.StorageEntry;
import backend.Magazyn.supplier.entities.Supplier;
import backend.Magazyn.transaction_entry.entity.TransactionEntry;
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
