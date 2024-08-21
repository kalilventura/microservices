package br.com.github.kalilventura.api.products.infrastructure.controllers.requests;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.mappers.ProductRequestMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductRequest(String name, Long quantity, String categoryId) {

    public Product toDomain() {
        return ProductRequestMapper.INSTANCE.mapToEntity(this);
    }
}
