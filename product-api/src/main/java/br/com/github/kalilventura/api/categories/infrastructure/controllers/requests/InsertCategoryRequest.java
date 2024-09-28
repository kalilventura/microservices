package br.com.github.kalilventura.api.categories.infrastructure.controllers.requests;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import lombok.Builder;

@Builder
public record InsertCategoryRequest(String description) {

  public Category toDomain() {
    return new Category(null, description);
  }
}
