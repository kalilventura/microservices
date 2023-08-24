package br.com.github.kalilventura.api.categories.infrastructure.repositories.builders;

import br.com.github.kalilventura.api.categories.domain.builders.CategoryBuilder;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class JpaCategoryBuilder {
    private final Faker faker = new Faker();

    private String guid = GuidHelper.getRandomValue();
    private String description = faker.lorem().characters();

    public JpaCategoryBuilder withGuid(final String value) {
        guid = value;
        return this;
    }

    public JpaCategoryBuilder withDescription(final String value) {
        description = value;
        return this;
    }

    public JpaCategory buildDefault() {
        return JpaCategory
                .builder()
                .guid(guid)
                .description(description)
                .build();
    }

    public List<JpaCategory> buildMany(final int quantity) {
        final var categories = new ArrayList<JpaCategory>(1);
        for (int index = 0; index <= quantity; index++) {
            categories.add(buildDefault());
        }
        return categories;
    }
}
