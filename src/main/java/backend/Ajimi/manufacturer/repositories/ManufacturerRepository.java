package backend.Ajimi.manufacturer.repositories;

import backend.Ajimi.manufacturer.entities.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID>
{
  @Query("SELECT m FROM Manufacturer m WHERE m.name = ?1")
  Manufacturer findByManufacturerName(String name);
}
