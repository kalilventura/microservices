package br.com.github.kalilventura.api.products.infrastructure.builders;

import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class JpaProductBuilder {

    private final Faker faker = new Faker();

    private String guid = faker.internet().uuid();
    private String name = faker.name().name();

    public JpaProductBuilder withGuid(final String productGuid) {
        guid = productGuid;
        return this;
    }

    public JpaProductBuilder withName(final String productName) {
        name = productName;
        return this;
    }

    public JpaProduct buildDefault() {
        return JpaProduct
                .builder()
                .guid(guid)
                .name(name)
                .quantity(faker.number().randomNumber(10, true))
                .build();
    }

    public List<JpaProduct> buildMany(final int quantity) {
        final var products = new ArrayList<JpaProduct>(1);
        for (int index = 0; index <= quantity; index++) {
            products.add(buildDefault());
        }
        return products;
    }
}
