package br.com.github.kalilventura.api.products.infrastructure.builders;

import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.ProductRequest;
import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductRequestBuilder {

    public ProductRequest buildDefault() {
        final var faker = new Faker();
        return ProductRequest.builder()
                .name(faker.name().name())
                .build();
    }
}
