package backend.Ajimi.location.services;

import backend.Ajimi.location.entities.Location;
import backend.Ajimi.location.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService {

  private final LocationRepository locationRepository;

  @Autowired
  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public Location saveLocation(Location location) {
    return locationRepository.save(location);
  }

  public List<Location> findAllLocations() {
    return locationRepository.findAll();
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
