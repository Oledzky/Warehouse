package backend.Magazyn.supplier.services;

import backend.Magazyn.supplier.entities.Supplier;
import backend.Magazyn.supplier.entities.SupplierDTO;
import backend.Magazyn.supplier.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final SupplierRepository supplierRepository;

  @Autowired
  public SupplierService(SupplierRepository supplierRepository) {
    this.supplierRepository = supplierRepository;
  }

  public Supplier saveSupplier(Supplier supplier) {
    return supplierRepository.save(supplier);
  }

  public List<SupplierDTO> findAllSuppliers() {
    return supplierRepository.findAll().stream()
            .map(supplier -> modelMapper.map(supplier, SupplierDTO.class))
            .toList();
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
