package backend.Magazyn.product.services;

import backend.Magazyn.product.entities.Product;
import backend.Magazyn.product.entities.ProductDTO;
import backend.Magazyn.product.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public List<ProductDTO> findAllProducts() {
    List<ProductDTO> products = productRepository.findAll().stream()
            .map(product -> modelMapper.map(product, ProductDTO.class))
            .toList();
    return products;
  }

  public Optional<Product> findProductById(UUID id) {
    return productRepository.findById(id);
  }

  public void deleteProduct(UUID id) {
    productRepository.deleteById(id);
  }

  public List<Product> findProductsByProductId(UUID productId) {
    return productRepository.findByProductId(productId);
  }

  public List<ProductDTO> findProductsByCategory(UUID id) {
    List<ProductDTO> products = productRepository.findByCategoryId(id).stream()
            .map(product -> modelMapper.map(product, ProductDTO.class))
            .toList();
    return products;
  }
}
