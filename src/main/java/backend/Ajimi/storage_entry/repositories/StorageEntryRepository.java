package backend.Ajimi.storage_entry.repositories;

import backend.Ajimi.storage_entry.entity.StorageEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StorageEntryRepository  extends JpaRepository<StorageEntry, UUID> {

  @Query("SELECT se FROM StorageEntry se WHERE se.storage.id = :storageId")
  List<StorageEntry> findAllByStorageId(UUID storageId);

  @Query("SELECT se FROM StorageEntry se WHERE se.product.id = :productId")
  List<StorageEntry> findAllByProductId(UUID productId);

}
