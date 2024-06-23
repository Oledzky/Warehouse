package backend.Ajimi.order.services;

import backend.Ajimi.order.entities.Order;
import backend.Ajimi.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order saveOrder(Order order) {
    return orderRepository.save(order);
  }

  public List<Order> findAllOrders() {
    return orderRepository.findAll();
  }

  public Optional<Order> findOrderById(UUID id) {
    return orderRepository.findById(id);
  }

  public void deleteOrder(UUID id) {
    orderRepository.deleteById(id);
  }

  public List<Order> findOrdersByOrderId(UUID orderId) {
    return orderRepository.findByOrderId(orderId);
  }
}
