package backend.Ajimi.product.repositories;

import backend.Ajimi.product.entities.Product;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

  @Query("SELECT p FROM Product p WHERE p.id = ?1")
  List<Product> findByProductId(UUID productId);
}
