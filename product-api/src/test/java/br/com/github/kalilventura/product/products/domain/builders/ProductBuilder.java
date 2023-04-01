package br.com.github.kalilventura.product.products.domain.builders;

import br.com.github.kalilventura.product.products.domain.entities.Product;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {

    private final Faker faker = new Faker();

    private String guid = faker.internet().uuid();

    public ProductBuilder withGuid(final String productGuid) {
        guid = productGuid;
        return this;
    }

    public Product buildDefault() {
        return Product
                .builder()
                .guid(guid)
                .name(faker.name().name())
                .quantity(faker.number().randomNumber(10, true))
                .build();
    }

    public List<Product> buildMany(final int quantity) {
        final var products = new ArrayList<Product>(1);
        for (int index = 0; index <= quantity; index++) {
            products.add(buildDefault());
        }
        return products;
    }
}
