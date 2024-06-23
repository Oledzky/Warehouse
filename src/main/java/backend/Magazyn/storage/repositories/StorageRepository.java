package backend.Magazyn.storage.repositories;

import backend.Magazyn.enums.StorageType;
import backend.Magazyn.storage.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StorageRepository extends JpaRepository<Storage, UUID> {

  @Query ("SELECT s FROM Storage s WHERE s.type = ?1")
  List<Storage> findAllByType(StorageType type);

  @Query ("SELECT s FROM Storage s WHERE s.id = ?1")
  List<Storage> findAllById(UUID id);
}
