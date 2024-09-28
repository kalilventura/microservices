package br.com.github.kalilventura.api.categories.infrastructure.controllers.responses;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import lombok.Builder;

@Builder
public record CategoryResponse(String guid, String description) {

  public static CategoryResponse toResponse(final Category category) {
    return new CategoryResponse(category.guid(), category.description());
  }
}
