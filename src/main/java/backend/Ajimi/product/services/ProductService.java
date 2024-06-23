package backend.Ajimi.product.services;

import backend.Ajimi.product.entities.Product;
import backend.Ajimi.product.entities.ProductDTO;
import backend.Ajimi.product.repositories.ProductRepository;
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
}
