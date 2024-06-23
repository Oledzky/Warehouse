package backend.Magazyn.order.controllers;

import backend.Magazyn.order.entities.Order;
import backend.Magazyn.order.entities.OrderDTO;
import backend.Magazyn.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order) {
    OrderDTO savedOrder = orderService.saveOrder(order);
    return ResponseEntity.ok(savedOrder);
  }

  @GetMapping
  public ResponseEntity<List<OrderDTO>> getAllOrders() {
    List<OrderDTO> orders = orderService.findAllOrders();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
    return orderService.findOrderById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
    orderService.deleteOrder(id);
    return ResponseEntity.ok().build();
  }
}
