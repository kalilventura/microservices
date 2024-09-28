package br.com.github.kalilventura.api.categories.infrastructure.builders;

import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.InsertCategoryRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InsertCategoryRequestBuilder {

  private String description = "";

  public InsertCategoryRequest buildDefault() {
    return InsertCategoryRequest.builder().description(description).build();
  }
}
