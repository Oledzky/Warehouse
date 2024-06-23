package backend.Ajimi.supplier.services;

import backend.Ajimi.supplier.entities.Supplier;
import backend.Ajimi.supplier.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierService {

  private final SupplierRepository supplierRepository;

  @Autowired
  public SupplierService(SupplierRepository supplierRepository) {
    this.supplierRepository = supplierRepository;
  }

  public Supplier saveSupplier(Supplier supplier) {
    return supplierRepository.save(supplier);
  }

  public List<Supplier> findAllSuppliers() {
    return supplierRepository.findAll();
  }

  public Optional<Supplier> findSupplierById(UUID id) {
    return supplierRepository.findById(id);
  }

  public List<Supplier> findSuppliersByName(String name) {
    return supplierRepository.findByName(name);
  }

  public void deleteSupplier(UUID id) {
    supplierRepository.deleteById(id);
  }
}
