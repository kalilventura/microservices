package br.com.github.kalilventura.api.categories.infrastructure.services.doubles;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.InsertCategoryService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InMemoryInsertCategoryService implements InsertCategoryService {

  @Override
  public Category save(final Category category) {
    return category;
  }
}
