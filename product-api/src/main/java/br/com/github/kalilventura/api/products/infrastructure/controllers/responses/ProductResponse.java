package br.com.github.kalilventura.api.products.infrastructure.controllers.responses;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.mappers.ProductResponseMapper;

public record ProductResponse(String guid, String name, Long quantity) {

    public static ProductResponse toResponse(final Product product) {
        return ProductResponseMapper.INSTANCE.mapToResponse(product);
    }
}
