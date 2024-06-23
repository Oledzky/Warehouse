package backend.Ajimi.storage.services;

import backend.Ajimi.enums.StorageType;
import backend.Ajimi.storage.entities.Storage;
import backend.Ajimi.storage.entities.StorageDTO;
import backend.Ajimi.storage.repositories.StorageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StorageService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final StorageRepository storageRepository;

  @Autowired
  public StorageService(StorageRepository storageRepository) {
    this.storageRepository = storageRepository;
  }

  public Storage saveStorage(Storage storage) {
    return storageRepository.save(storage);
  }

  public List<StorageDTO> findAllStorages() {
    return storageRepository.findAll().stream()
            .map(storage -> modelMapper.map(storage, StorageDTO.class))
            .toList();
  }

  public Optional<Storage> findStorageById(UUID id) {
    return storageRepository.findById(id);
  }

  public List<Storage> findStoragesByType(StorageType type) {
    return storageRepository.findAllByType(type);
  }

  public void deleteStorage(UUID id) {
    storageRepository.deleteById(id);
  }
}
