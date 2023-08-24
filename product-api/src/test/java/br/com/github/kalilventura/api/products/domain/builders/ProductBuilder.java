package br.com.github.kalilventura.api.products.domain.builders;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ProductBuilder {

    private final Faker faker = new Faker();
    private String guid = faker.internet().uuid();
    private String productName = faker.name().name();

    public ProductBuilder withGuid(final String productGuid) {
        guid = productGuid;
        return this;
    }

    public ProductBuilder withName(final String name) {
        productName = name;
        return this;
    }

    public Product buildDefault() {
        return Product
                .builder()
                .guid(guid)
                .name(productName)
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
