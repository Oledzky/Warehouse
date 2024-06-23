package backend.Ajimi.storage_entry.services;

import backend.Ajimi.storage_entry.entity.StorageEntry;
import backend.Ajimi.storage_entry.entity.StorageEntryDTO;
import backend.Ajimi.storage_entry.repositories.StorageEntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StorageEntryService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final StorageEntryRepository storageEntryRepository;

  @Autowired
  public StorageEntryService(StorageEntryRepository storageEntryRepository) {
    this.storageEntryRepository = storageEntryRepository;
  }

  public StorageEntry saveStorageEntry(StorageEntry storageEntry) {
    return storageEntryRepository.save(storageEntry);
  }

  public List<StorageEntryDTO> findAllStorageEntries() {
    return storageEntryRepository.findAll().stream()
        .map(storageEntry -> modelMapper.map(storageEntry, StorageEntryDTO.class))
        .toList();
  }

  public StorageEntry findStorageEntryById(UUID id) {
    return storageEntryRepository.findById(id).orElse(null);
  }

  public List<StorageEntry> findStorageEntriesByStorageId(UUID storageId) {
    return storageEntryRepository.findAllByStorageId(storageId);
  }

  public List<StorageEntry> findStorageEntriesByProductId(UUID productId) {
    return storageEntryRepository.findAllByProductId(productId);
  }

  public void deleteStorageEntry(UUID id) {
    storageEntryRepository.deleteById(id);
  }
}
