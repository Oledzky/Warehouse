package backend.Magazyn.supplier.repositories;

import backend.Magazyn.supplier.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, UUID> {

  @Query("SELECT s FROM Supplier s WHERE s.name = :name")
  List<Supplier> findByName(String name);
}
