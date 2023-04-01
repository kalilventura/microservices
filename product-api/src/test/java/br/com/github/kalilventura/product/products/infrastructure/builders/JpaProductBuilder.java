package br.com.github.kalilventura.product.products.infrastructure.builders;

import br.com.github.kalilventura.product.products.infrastructure.repositories.models.JpaProduct;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class JpaProductBuilder {

    private final Faker faker = new Faker();

    private String guid = faker.internet().uuid();

    public JpaProductBuilder withGuid(final String productGuid) {
        guid = productGuid;
        return this;
    }

    public JpaProduct buildDefault() {
        return JpaProduct
                .builder()
                .guid(guid)
                .name(faker.name().name())
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
