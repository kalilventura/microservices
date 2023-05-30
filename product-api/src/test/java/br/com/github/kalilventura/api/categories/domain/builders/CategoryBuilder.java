package br.com.github.kalilventura.api.categories.domain.builders;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CategoryBuilder {

    private final Faker faker = new Faker();

    private String guid = GuidHelper.getRandomValue();
    private String description = faker.lorem().characters();

    public CategoryBuilder withDescription(final String value) {
        description = value;
        return this;
    }

    public Category buildDefault() {
        return Category
                .builder()
                .guid(guid)
                .description(description)
                .build();
    }

    public List<Category> buildMany(final int quantity) {
        final var categories = new ArrayList<Category>(1);
        for (int index = 0; index <= quantity; index++) {
            categories.add(buildDefault());
        }
        return categories;
    }
}
