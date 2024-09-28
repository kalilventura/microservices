package br.com.github.kalilventura.api.categories.infrastructure.repositories.builders;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JpaCategoryBuilder {

  private String guid = GuidHelper.getRandomValue();
  private String description = "";

  public JpaCategoryBuilder withGuid(final String value) {
    guid = value;
    return this;
  }

  public JpaCategoryBuilder withDescription(final String value) {
    description = value;
    return this;
  }

  public JpaCategory buildDefault() {
    return JpaCategory.builder().guid(guid).description(description).build();
  }

  public List<JpaCategory> buildMany(final int quantity) {
    final var categories = new ArrayList<JpaCategory>(1);
    for (int index = 0; index <= quantity; index++) {
      categories.add(buildDefault());
    }
    return categories;
  }
}
