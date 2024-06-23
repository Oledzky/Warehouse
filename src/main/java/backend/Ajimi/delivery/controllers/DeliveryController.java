package backend.Ajimi.delivery.controllers;

import backend.Ajimi.delivery.entities.Delivery;
import backend.Ajimi.delivery.entities.DeliveryDTO;
import backend.Ajimi.delivery.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

  private final DeliveryService deliveryService;

  @Autowired
  public DeliveryController(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
  }

  @PostMapping
  public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
    Delivery savedDelivery = deliveryService.saveDelivery(delivery);
    return ResponseEntity.ok(savedDelivery);
  }

  @GetMapping
  public ResponseEntity<List<DeliveryDTO>> getAllDeliveries() {
    List<DeliveryDTO> deliveries = deliveryService.findAllDeliveries();
    return ResponseEntity.ok(deliveries);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Delivery> getDeliveryById(@PathVariable UUID id) {
    Delivery delivery = deliveryService.findDeliveryById(id);
    return ResponseEntity.ok(delivery);
  }

  @GetMapping("/date")
  public ResponseEntity<List<Delivery>> getDeliveriesByDate(@RequestParam String date) {
    List<Delivery> deliveries = deliveryService.findDeliveriesByDate(date);
    return ResponseEntity.ok(deliveries);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDelivery(@PathVariable UUID id) {
    deliveryService.deleteDelivery(id);
    return ResponseEntity.ok().build();
  }
}
