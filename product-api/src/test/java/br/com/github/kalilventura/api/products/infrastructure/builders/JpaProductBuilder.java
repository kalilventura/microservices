package br.com.github.kalilventura.api.products.infrastructure.builders;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpaProductBuilder {

    private final Faker faker = new Faker();

    private JpaCategory category;
    private String guid = faker.internet().uuid();
    private String name = faker.name().name();

    public JpaProductBuilder withCategory(final JpaCategory jpaCategory) {
        category = jpaCategory;
        return this;
    }

    public JpaProductBuilder withGuid(final String productGuid) {
        guid = productGuid;
        return this;
    }

    public JpaProductBuilder withName(final String productName) {
        name = productName;
        return this;
    }

    public JpaProduct buildDefault() {
        final var builder = JpaProduct
                .builder()
                .guid(guid)
                .name(name)
                .quantity(faker.number().randomNumber(10, true));

        if (Objects.nonNull(category)) {
            builder.category(category);
        }

        return builder.build();
    }

    public List<JpaProduct> buildMany(final int quantity) {
        final var products = new ArrayList<JpaProduct>(1);
        for (int index = 0; index <= quantity; index++) {
            products.add(buildDefault());
        }
        return products;
    }
}
