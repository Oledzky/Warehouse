package backend.Ajimi.category.controllers;

import backend.Ajimi.category.entity.Category;
import backend.Ajimi.category.entity.CategoryDTO;
import backend.Ajimi.category.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping
  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    Category savedCategory = categoryService.saveCategory(category);
    return ResponseEntity.ok(savedCategory);
  }

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> getAllCategories() {
    List<CategoryDTO> categories = categoryService.findAllCategories();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable UUID id) {
    Category category = categoryService.findCategoryById(id);
    return ResponseEntity.ok(category);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Category>> getCategoryByName(@RequestParam String name) {
    List<Category> categories = categoryService.findCategoryByName(name);
    return ResponseEntity.ok(categories);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.ok().build();
  }
}
