package backend.Magazyn.order_entry.repositories;

import backend.Magazyn.order_entry.entity.OrderEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderEntryRepository extends JpaRepository<OrderEntry, UUID> {

  @Query("SELECT oe FROM OrderEntry oe WHERE oe.order = ?1")
  List<OrderEntry> findByOrderId(UUID orderId);

  @Query("SELECT oe FROM OrderEntry oe WHERE oe.product = ?1")
  List<OrderEntry> findByProductId(UUID productId);
}
