package br.com.github.kalilventura.api.products.infrastructure.controllers.requests;

import br.com.github.kalilventura.api.products.domain.entities.Product;

public record ProductRequest(String name, Long quantity, String categoryId, Float price) {

    public Product toDomain() {
        return new Product(null, name, quantity, categoryId, price);
    }
}
