package backend.Magazyn.order.repositories;

import backend.Magazyn.order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

  @Query("SELECT o FROM Order o WHERE o.id = ?1")
  List<Order> findByOrderId(UUID id);
}
