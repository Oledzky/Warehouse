package backend.Ajimi.location.controllers;

import backend.Ajimi.location.entities.Location;
import backend.Ajimi.location.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locations")
public class LocationController {

  private final LocationService locationService;

  @Autowired
  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @PostMapping
  public ResponseEntity<Location> createLocation(@RequestBody Location location) {
    Location savedLocation = locationService.saveLocation(location);
    return ResponseEntity.ok(savedLocation);
  }

  @GetMapping
  public ResponseEntity<List<Location>> getAllLocations() {
    List<Location> locations = locationService.findAllLocations();
    return ResponseEntity.ok(locations);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Location> getLocationById(@PathVariable UUID id) {
    return locationService.findLocationById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/search")
  public ResponseEntity<List<Location>> getLocationsByAddress(@RequestParam String address) {
    List<Location> locations = locationService.findLocationsByAddress(address);
    return ResponseEntity.ok(locations);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLocation(@PathVariable UUID id) {
    locationService.deleteLocation(id);
    return ResponseEntity.ok().build();
  }
}
