package backend.Ajimi.delivery.repositories;

import backend.Ajimi.delivery.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {

  @Query("SELECT d FROM Delivery d WHERE d.deliveryDate = ?1")
  List<Delivery> findByDeliveryDate(String deliveryDate);
}
