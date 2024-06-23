package backend.Magazyn.location.repositories;

import backend.Magazyn.location.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {

  @Query("SELECT l FROM Location l WHERE l.address = ?1")
  List<Location> findByLocationAddress(String address);
}
