package backend.Magazyn.product.controllers;

import backend.Magazyn.product.entities.Product;
import backend.Magazyn.product.entities.ProductDTO;
import backend.Magazyn.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product savedProduct = productService.saveProduct(product);
    return ResponseEntity.ok(savedProduct);
  }

  @GetMapping
  public List<ProductDTO> getAllProducts() {
    List<ProductDTO> products = productService.findAllProducts();
    return products;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
    return productService.findProductById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/category/{id}")
  public List<ProductDTO> getProductsByCategory(@PathVariable UUID id) {
    List<ProductDTO> products = productService.findProductsByCategory(id);
    return products;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok().build();
  }
}
