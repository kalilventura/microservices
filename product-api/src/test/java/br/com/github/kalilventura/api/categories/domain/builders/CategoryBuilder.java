package br.com.github.kalilventura.api.categories.domain.builders;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoryBuilder {

  private String guid = GuidHelper.getRandomValue();
  private String description = "";

  public CategoryBuilder withDescription(final String value) {
    description = value;
    return this;
  }

  public Category buildDefault() {
    return Category.builder().guid(guid).description(description).build();
  }

  public List<Category> buildMany(final int quantity) {
    final var categories = new ArrayList<Category>(1);
    for (int index = 0; index <= quantity; index++) {
      categories.add(buildDefault());
    }
    return categories;
  }
}
