package br.com.github.kalilventura.api.categories.infrastructure.services;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class JpaFindCategoryService implements FindCategoryService {

  private final CategoriesRepository repository;

  public JpaFindCategoryService(final CategoriesRepository categoriesRepository) {
    repository = categoriesRepository;
  }

  @Override
  public Optional<Category> findById(final Long id) {
    return repository.findById(id).map(JpaCategory::toDomain);
  }

  @Override
  public Optional<Category> findByDescription(final String description) {
    final var category = repository.findByDescription(description);
    return category.map(JpaCategory::toDomain);
  }

  @Override
  public List<Category> findAll() {
    return repository.findAll().stream().map(JpaCategory::toDomain).toList();
  }
}
