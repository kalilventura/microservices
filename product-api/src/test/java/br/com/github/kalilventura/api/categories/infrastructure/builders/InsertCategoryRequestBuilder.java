package br.com.github.kalilventura.api.categories.infrastructure.builders;

import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.InsertCategoryRequest;
import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InsertCategoryRequestBuilder {

    private final Faker faker = new Faker();
    private String description = faker.lorem().characters();

    public InsertCategoryRequest buildDefault() {
        return InsertCategoryRequest
                .builder()
                .description(description)
                .build();
    }
}
