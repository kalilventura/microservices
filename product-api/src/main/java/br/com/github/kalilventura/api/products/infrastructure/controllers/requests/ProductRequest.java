package br.com.github.kalilventura.api.products.infrastructure.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.jetbrains.annotations.NotNull;

@Builder
public record ProductRequest(@JsonProperty @NotNull String name) {}
