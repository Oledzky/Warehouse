package backend.Magazyn.manufacturer.services;

import backend.Magazyn.manufacturer.entities.Manufacturer;
import backend.Magazyn.manufacturer.entities.ManufacturerDTO;
import backend.Magazyn.manufacturer.repositories.ManufacturerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManufacturerService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final ManufacturerRepository manufacturerRepository;

  @Autowired
  public ManufacturerService(ManufacturerRepository manufacturerRepository) {
    this.manufacturerRepository = manufacturerRepository;
  }

  public Manufacturer saveManufacturer(Manufacturer manufacturer) {
    return manufacturerRepository.save(manufacturer);
  }

  public List<ManufacturerDTO> findAllManufacturers() {
    List<ManufacturerDTO> manufacturers = manufacturerRepository.findAll().stream()
            .map(manufacturer -> modelMapper.map(manufacturer, ManufacturerDTO.class))
            .toList();
    return manufacturers;
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
