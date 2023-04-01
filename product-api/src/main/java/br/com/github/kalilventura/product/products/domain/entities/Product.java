package br.com.github.kalilventura.product.products.domain.entities;

import lombok.Builder;

@Builder
public record Product(String guid, String name, Long quantity) {}
