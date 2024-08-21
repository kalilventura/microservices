package br.com.github.kalilventura.api.products.infrastructure.controllers.responses;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
    @JsonProperty String guid,
    @JsonProperty String name,
    @JsonProperty Long quantity,
    @JsonProperty String categoryId,
    @JsonProperty Float price) {

    public static ProductResponse toResponse(final Product product) {
        return new ProductResponse(
            product.guid(),
            product.name(),
            product.quantity(),
            product.categoryId(),
            product.price());
    }
}
