package br.com.github.kalilventura.api.products.domain.entities;

import lombok.Builder;

@Builder
public record Product(String guid, String name, Long quantity) {}
