package backend.Ajimi.order_entry.controllers;

import backend.Ajimi.order_entry.entity.OrderEntry;
import backend.Ajimi.order_entry.services.OrderEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order-entries")
public class OrderEntryController {

  private final OrderEntryService orderEntryService;

  @Autowired
  public OrderEntryController(OrderEntryService orderEntryService) {
    this.orderEntryService = orderEntryService;
  }

  @PostMapping
  public ResponseEntity<OrderEntry> createOrderEntry(@RequestBody OrderEntry orderEntry) {
    OrderEntry savedOrderEntry = orderEntryService.saveOrderEntry(orderEntry);
    return ResponseEntity.ok(savedOrderEntry);
  }

  @GetMapping
  public ResponseEntity<List<OrderEntry>> getAllOrderEntries() {
    List<OrderEntry> orderEntries = orderEntryService.findAllOrderEntries();
    return ResponseEntity.ok(orderEntries);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderEntry> getOrderEntryById(@PathVariable UUID id) {
    OrderEntry orderEntry = orderEntryService.findOrderEntryById(id);
    return ResponseEntity.ok(orderEntry);
  }

  @GetMapping("/by-order/{orderId}")
  public ResponseEntity<List<OrderEntry>> getOrderEntriesByOrderId(@PathVariable UUID orderId) {
    List<OrderEntry> orderEntries = orderEntryService.findOrderEntriesByOrderId(orderId);
    return ResponseEntity.ok(orderEntries);
  }

  @GetMapping("/by-product/{productId}")
  public ResponseEntity<List<OrderEntry>> getOrderEntriesByProductId(@PathVariable UUID productId) {
    List<OrderEntry> orderEntries = orderEntryService.findOrderEntriesByProductId(productId);
    return ResponseEntity.ok(orderEntries);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrderEntry(@PathVariable UUID id) {
    orderEntryService.deleteOrderEntry(id);
    return ResponseEntity.ok().build();
  }
}
