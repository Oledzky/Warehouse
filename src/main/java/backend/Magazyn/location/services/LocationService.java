package backend.Magazyn.location.services;

import backend.Magazyn.location.entities.Location;
import backend.Magazyn.location.entities.LocationDTO;
import backend.Magazyn.location.repositories.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final LocationRepository locationRepository;

  @Autowired
  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public Location saveLocation(Location location) {
    return locationRepository.save(location);
  }

  public List<LocationDTO> findAllLocations() {
    List<LocationDTO> locations = locationRepository.findAll().stream()
            .map(location -> modelMapper.map(location, LocationDTO.class))
            .toList();
    return locations;
  }

  public Optional<Location> findLocationById(UUID id) {
    return locationRepository.findById(id);
  }

  public List<Location> findLocationsByAddress(String address) {
    return locationRepository.findByLocationAddress(address);
  }

  public void deleteLocation(UUID id) {
    locationRepository.deleteById(id);
  }
}
