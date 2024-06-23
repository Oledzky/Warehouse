package backend.Ajimi.order_entry.services;

import backend.Ajimi.order_entry.entity.OrderEntry;
import backend.Ajimi.order_entry.repositories.OrderEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderEntryService {

  private final OrderEntryRepository orderEntryRepository;

  @Autowired
  public OrderEntryService(OrderEntryRepository orderEntryRepository) {
    this.orderEntryRepository = orderEntryRepository;
  }

  public OrderEntry saveOrderEntry(OrderEntry orderEntry) {
    return orderEntryRepository.save(orderEntry);
  }

  public List<OrderEntry> findAllOrderEntries() {
    return orderEntryRepository.findAll();
  }

  public OrderEntry findOrderEntryById(UUID id) {
    return orderEntryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order entry not found with id: " + id));
  }

  public List<OrderEntry> findOrderEntriesByOrderId(UUID orderId) {
    return orderEntryRepository.findByOrderId(orderId);
  }

  public List<OrderEntry> findOrderEntriesByProductId(UUID productId) {
    return orderEntryRepository.findByProductId(productId);
  }

  public void deleteOrderEntry(UUID id) {
    orderEntryRepository.deleteById(id);
  }
}
