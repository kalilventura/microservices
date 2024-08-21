package br.com.github.kalilventura.api.products.domain.entities;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record Product(String guid, String name, Long quantity, String categoryId) implements Serializable {}
