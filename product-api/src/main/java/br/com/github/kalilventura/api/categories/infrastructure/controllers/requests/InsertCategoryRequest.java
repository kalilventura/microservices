package br.com.github.kalilventura.api.categories.infrastructure.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.jetbrains.annotations.NotNull;

@Builder
public record InsertCategoryRequest(@JsonProperty @NotNull String description) {}
