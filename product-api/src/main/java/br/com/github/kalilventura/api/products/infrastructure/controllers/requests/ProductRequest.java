package br.com.github.kalilventura.api.products.infrastructure.controllers.requests;

import lombok.Builder;
import org.jetbrains.annotations.NotNull;

@Builder
public record ProductRequest(@NotNull String name) {}
