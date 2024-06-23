package backend.Ajimi.delivery.services;

import backend.Ajimi.delivery.entities.Delivery;
import backend.Ajimi.delivery.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService {

  private final DeliveryRepository deliveryRepository;

  @Autowired
  public DeliveryService(DeliveryRepository deliveryRepository) {
    this.deliveryRepository = deliveryRepository;
  }

  public Delivery saveDelivery(Delivery delivery) {
    return deliveryRepository.save(delivery);
  }

  public List<Delivery> findAllDeliveries() {
    return deliveryRepository.findAll();
  }

  public Delivery findDeliveryById(UUID id) {
    return deliveryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Delivery not found with id " + id));
  }

  public List<Delivery> findDeliveriesByDate(String deliveryDate) {
    return deliveryRepository.findByDeliveryDate(deliveryDate);
  }

  public void deleteDelivery(UUID id) {
    deliveryRepository.deleteById(id);
  }
}
