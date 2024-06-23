package backend.Magazyn.category.services;

import backend.Magazyn.category.entity.Category;
import backend.Magazyn.category.entity.CategoryDTO;
import backend.Magazyn.category.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category saveCategory(Category category) {
    return categoryRepository.save(category);
  }

  public List<CategoryDTO> findAllCategories() {
    List<CategoryDTO> categories = categoryRepository.findAll().stream()
            .map(category -> modelMapper.map(category, CategoryDTO.class))
            .toList();
    return categories;
  }

  public Category findCategoryById(UUID id) {
    return categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
  }

  public List<Category> findCategoryByName(String name) {
    return categoryRepository.findByName(name);
  }

  public void deleteCategory(UUID id) {
    categoryRepository.deleteById(id);
  }
}
