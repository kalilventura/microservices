package br.com.github.kalilventura.api.categories.domain.services;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import java.util.List;
import java.util.Optional;

public interface FindCategoryService {

  Optional<Category> findById(Long id);

  Optional<Category> findByDescription(String description);

  List<Category> findAll();
}
