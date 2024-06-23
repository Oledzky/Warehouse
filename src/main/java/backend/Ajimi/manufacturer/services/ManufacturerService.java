package backend.Ajimi.manufacturer.services;

import backend.Ajimi.manufacturer.entities.Manufacturer;
import backend.Ajimi.manufacturer.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManufacturerService {

  private final ManufacturerRepository manufacturerRepository;

  @Autowired
  public ManufacturerService(ManufacturerRepository manufacturerRepository) {
    this.manufacturerRepository = manufacturerRepository;
  }

  public Manufacturer saveManufacturer(Manufacturer manufacturer) {
    return manufacturerRepository.save(manufacturer);
  }

  public List<Manufacturer> findAllManufacturers() {
    return manufacturerRepository.findAll();
  }

  public Optional<Manufacturer> findManufacturerById(UUID id) {
    return manufacturerRepository.findById(id);
  }

  public Manufacturer findManufacturerByName(String name) {
    return manufacturerRepository.findByManufacturerName(name);
  }

  public void deleteManufacturer(UUID id) {
    manufacturerRepository.deleteById(id);
  }
}
