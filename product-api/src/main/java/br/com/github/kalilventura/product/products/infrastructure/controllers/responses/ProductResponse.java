package br.com.github.kalilventura.product.products.infrastructure.controllers.responses;

import lombok.Builder;

@Builder
public record ProductResponse(String guid, String name, Long quantity) {}
