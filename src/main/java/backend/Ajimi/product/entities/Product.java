package backend.Ajimi.product.entities;

import backend.Ajimi.category.entity.Category;
import backend.Ajimi.manufacturer.entities.Manufacturer;
import backend.Ajimi.order.entities.Order;
import backend.Ajimi.storage.entities.Storage;
import backend.Ajimi.supplier.entities.Supplier;
import backend.Ajimi.transaction.entities.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
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

  @Column(name = "price")
  private int price;

  @Column(name = "available_quantity")
  private int availableQuantity;

//  @ManyToOne
//  @JoinColumn(name = "manufacturer_id")
//  private Manufacturer manufacturer;
//
  @ManyToOne
  @JoinColumn(name = "transaction_id")
  private Transaction transaction;

//  @ManyToMany(mappedBy = "products")
//  private List<Storage> storages;
//
//  @ManyToMany(mappedBy = "products")
//  private List<Supplier> suppliers;
//
//  @ManyToMany(mappedBy = "products")
//  private List<Order> orders;
//
//  @ManyToOne
//  @JoinColumn(name = "category_id")
//  private Category category;
}
