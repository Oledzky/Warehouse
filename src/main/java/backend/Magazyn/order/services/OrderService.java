package backend.Magazyn.order.services;

import backend.Magazyn.order.entities.Order;
import backend.Magazyn.order.entities.OrderDTO;
import backend.Magazyn.order.repositories.OrderRepository;
import backend.Magazyn.product.entities.Product;
import backend.Magazyn.product.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }


  public List<OrderDTO> findAllOrders() {
    List<OrderDTO> orders =
        orderRepository.findAll().stream()
            .map(order -> modelMapper.map(order, OrderDTO.class))
            .toList();
    return orders;
  }

  public OrderDTO saveOrder(Order order) {
System.out.println("Order: " + order);
    Order newOrder =
        Order.builder()
            .orderEntries(
                order.getOrderEntries().stream()
                    .map(
                        orderEntry -> {
                          Product product =
                              productRepository
                                  .findById(orderEntry.getProduct().getId())
                                  .orElseThrow(
                                      () ->
                                          new RuntimeException(
                                              "Product not found for ID: "
                                                  + orderEntry.getProduct().getId()));
                          orderEntry.setProduct(product);
                          return orderEntry;
                        })
                    .collect(Collectors.toList()))
            .build();


   orderRepository.saveAndFlush(newOrder);

   return modelMapper.map(newOrder, OrderDTO.class);
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
