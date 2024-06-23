package backend.Magazyn;

import backend.Magazyn.category.entity.Category;
import backend.Magazyn.category.repositories.CategoryRepository;
import backend.Magazyn.delivery.repositories.DeliveryRepository;
import backend.Magazyn.enums.StorageType;
import backend.Magazyn.location.entities.Location;
import backend.Magazyn.location.repositories.LocationRepository;
import backend.Magazyn.manufacturer.entities.Manufacturer;
import backend.Magazyn.manufacturer.repositories.ManufacturerRepository;
import backend.Magazyn.order.repositories.OrderRepository;
import backend.Magazyn.order_entry.repositories.OrderEntryRepository;
import backend.Magazyn.product.entities.Product;
import backend.Magazyn.product.repositories.ProductRepository;
import backend.Magazyn.storage.repositories.StorageRepository;
import backend.Magazyn.storage_entry.repositories.StorageEntryRepository;
import backend.Magazyn.supplier.repositories.SupplierRepository;
import backend.Magazyn.transaction.repositories.TransactionRepository;
import backend.Magazyn.transaction_entry.repositories.TransactionEntryRepository;
import backend.Magazyn.user.entities.User;
import backend.Magazyn.user.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("seed")
public class DataSeed implements CommandLineRunner {

  private final CategoryRepository categoryRepository;
  private final DeliveryRepository deliveryRepository;
  private final LocationRepository locationRepository;
  private final ManufacturerRepository manufacturerRepository;
  private final OrderRepository orderRepository;
  private final OrderEntryRepository orderEntryRepository;
  private final ProductRepository productRepository;
  private final StorageRepository storageRepository;
  private final StorageEntryRepository storageEntryRepository;
  private final SupplierRepository supplierRepository;
  private final TransactionRepository transactionRepository;
  private final TransactionEntryRepository transactionEntryRepository;
  private final UserRepository userRepository;

  public DataSeed(
      CategoryRepository categoryRepository,
      DeliveryRepository deliveryRepository,
      LocationRepository locationRepository,
      ManufacturerRepository manufacturerRepository,
      OrderRepository orderRepository,
      OrderEntryRepository orderEntryRepository,
      StorageRepository storageRepository,
      StorageEntryRepository storageEntryRepository,
      SupplierRepository supplierRepository,
      TransactionEntryRepository transactionEntryRepository,
      UserRepository userRepository,
      ProductRepository productRepository,
      TransactionRepository transactionRepository) {
    this.categoryRepository = categoryRepository;
    this.deliveryRepository = deliveryRepository;
    this.locationRepository = locationRepository;
    this.manufacturerRepository = manufacturerRepository;
    this.orderRepository = orderRepository;
    this.orderEntryRepository = orderEntryRepository;
    this.storageRepository = storageRepository;
    this.storageEntryRepository = storageEntryRepository;
    this.supplierRepository = supplierRepository;
    this.transactionEntryRepository = transactionEntryRepository;
    this.userRepository = userRepository;
    this.productRepository = productRepository;
    this.transactionRepository = transactionRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Seeding data...");

    // Category Seed
    Category meatCategory = Category.builder()
            .name("Meats")
            .description("All kinds of meat products, including beef, chicken, and pork.")
            .build();

    Category dairyCategory = Category.builder()
            .name("Dairy")
            .description("Dairy products like milk, cheese, and butter.")
            .build();

    Category vegetableCategory = Category.builder()
            .name("Vegetables")
            .description("Fresh vegetables ranging from leafy greens to root vegetables.")
            .build();

    Category oilCategory = Category.builder()
            .name("Oils")
            .description("Various cooking oils such as olive oil, sunflower oil, and vegetable oil.")
            .build();

    Category accessoriesCategory = Category.builder()
            .name("Accessories")
            .description("Non-food items such as napkins, tablecloths, and utensils.")
            .build();
    categoryRepository.saveAllAndFlush(List.of(meatCategory, dairyCategory, vegetableCategory, oilCategory, accessoriesCategory));


        //User Seed
        User user1 = User.builder()
                .PESEL("00252815608")
                .name("Kuba")
                .surname("Kowalski")
                .username("kubak")
                .password("password")
                .build();
        userRepository.saveAndFlush(user1);


    //Product Seed
    Product product1 = Product.builder()
        .name("Chicken Whole")
        .description("Whole chicken, ideal for roasting.")
        .measurementUnit("pcs")
        .storageType(StorageType.COLD)
        .price(120)
        .category(meatCategory)
        .build();
    Product product2 = Product.builder()
        .name("Beef Neck")
        .description("Richly flavored beef neck, perfect for slow cooking.")
        .measurementUnit("kg")
        .storageType(StorageType.COLD)
        .price(200)
        .category(meatCategory)
        .build();
    Product product3 = Product.builder()
        .name("Butter")
        .description("Creamy unsalted butter.")
        .measurementUnit("kg")
        .storageType(StorageType.COLD)
        .price(50)
        .category(dairyCategory)
        .build();
    Product product4 = Product.builder()
        .name("Olive Oil")
        .description("Extra virgin olive oil, cold-pressed.")
        .measurementUnit("liter")
        .storageType(StorageType.DRY)
        .price(150)
        .category(oilCategory)
        .build();
    Product product5 = Product.builder()
        .name("Sunflower Oil")
        .description("Refined sunflower oil.")
        .measurementUnit("liter")
        .storageType(StorageType.DRY)
        .price(100)
        .category(oilCategory)
        .build();
    Product product6 = Product.builder()
        .name("Tomatoes")
        .description("Fresh, ripe tomatoes.")
        .measurementUnit("kg")
        .storageType(StorageType.COLD)
        .price(30)
        .category(vegetableCategory)
        .build();
    Product product7 = Product.builder()
        .name("Lettuce")
        .description("Crisp green lettuce.")
        .measurementUnit("pcs")
        .storageType(StorageType.COLD)
        .price(20)
        .category(vegetableCategory)
        .build();
    Product product8 = Product.builder()
        .name("Potatoes")
        .description("Versatile and nutritious potatoes.")
        .measurementUnit("kg")
        .storageType(StorageType.DRY)
        .price(25)
        .category(vegetableCategory)
        .build();
    Product product9 = Product.builder()
        .name("Napkins")
        .description("Disposable paper napkins.")
        .measurementUnit("pcs")
        .storageType(StorageType.DRY)
        .price(5)
        .category(accessoriesCategory)
        .build();
    Product product10 = Product.builder()
        .name("Tablecloth")
        .description("Elegant white tablecloth.")
        .measurementUnit("pcs")
        .storageType(StorageType.DRY)
        .price(250)
        .category(accessoriesCategory)
        .build();
    Product product11 = Product.builder()
        .name("Cheese")
        .description("Aged cheddar cheese.")
        .measurementUnit("kg")
        .storageType(StorageType.COLD)
        .price(80)
        .category(dairyCategory)
        .build();
    Product product12 = Product.builder()
        .name("Milk")
        .description("Whole milk, rich in flavor.")
        .measurementUnit("liter")
        .storageType(StorageType.COLD)
        .price(10)
        .category(dairyCategory)
        .build();
    Product product13 = Product.builder()
        .name("Eggs")
        .description("Free-range organic eggs.")
        .measurementUnit("dozen")
        .storageType(StorageType.COLD)
        .price(20)
        .category(dairyCategory)
        .build();
    Product product14 = Product.builder()
        .name("Bread")
        .description("Freshly baked bread.")
        .measurementUnit("loaf")
        .storageType(StorageType.DRY)
        .price(15)
        .category(accessoriesCategory)
        .build();
    Product product15 = Product.builder()
        .name("Pasta")
        .description("Italian spaghetti.")
        .measurementUnit("kg")
        .storageType(StorageType.DRY)
        .price(40)
        .category(accessoriesCategory)
        .build();
    productRepository.saveAllAndFlush(List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10, product11,
            product12, product13, product14, product15));


    //Location Seed
    Location location1 = Location.builder()
            .address("ul. Karmelicka 5, 31-133 Kraków")
            .build();
    Location location2 = Location.builder()
            .address("ul. Wielicka 3, 18-100 Łapy")
            .build();
    Location location3 = Location.builder()
            .address("ul. Słowackiego 1, 33-100 Tarnów")
            .build();
    locationRepository.saveAllAndFlush(List.of(location1, location2, location3));

    //TODO: Storage Seed
    //TODO: Order Seed

    //Manufacturers
    Manufacturer meatManufacturer = Manufacturer.builder()
            .name("Premium Meats Co.")
            .email("contact@premiummeatsco.com")
            .phone("123-456-7890")
            .build();

    Manufacturer dairyManufacturer = Manufacturer.builder()
            .name("Dairy Delights Ltd.")
            .email("info@dairydelights.com")
            .phone("234-567-8901")
            .build();

    Manufacturer vegetableManufacturer = Manufacturer.builder()
            .name("Green Farm Produce")
            .email("support@greenfarm.com")
            .phone("345-678-9012")
            .build();

    Manufacturer oilManufacturer = Manufacturer.builder()
            .name("Golden Drops Oils")
            .email("sales@goldendrops.com")
            .phone("456-789-0123")
            .build();

    Manufacturer accessoriesManufacturer = Manufacturer.builder()
            .name("Dining Essentials Supplies")
            .email("orders@diningessentials.com")
            .phone("567-890-1234")
            .build();
    manufacturerRepository.saveAllAndFlush(List.of(meatManufacturer, dairyManufacturer,
            vegetableManufacturer, oilManufacturer, accessoriesManufacturer));

    // Associate products with manufacturers
    product1.setManufacturer(meatManufacturer);
    product2.setManufacturer(meatManufacturer);
    product3.setManufacturer(dairyManufacturer);
    product4.setManufacturer(oilManufacturer);
    product5.setManufacturer(oilManufacturer);
    product6.setManufacturer(vegetableManufacturer);
    product7.setManufacturer(vegetableManufacturer);
    product8.setManufacturer(vegetableManufacturer);
    product9.setManufacturer(accessoriesManufacturer);
    product10.setManufacturer(accessoriesManufacturer);
    product11.setManufacturer(dairyManufacturer);
    product12.setManufacturer(dairyManufacturer);
    product13.setManufacturer(dairyManufacturer);
    product14.setManufacturer(accessoriesManufacturer);
    product15.setManufacturer(accessoriesManufacturer);
    productRepository.saveAllAndFlush(List.of(product1, product2, product3, product4, product5, product6,
            product7, product8, product9, product10, product11, product12, product13, product14, product15));


    // Fetch some locations or create them directly in the seed if they are necessary for setting the delivery
    List<Location> locations = locationRepository.findAll();  // Assume locations are already seeded






  }


  }

