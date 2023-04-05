package br.com.github.kalilventura.product.products.infrastructure.controllers.requests;

import lombok.Builder;
import org.jetbrains.annotations.NotNull;

@Builder
public record ProductRequest(@NotNull String name) {}
