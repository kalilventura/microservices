package br.com.github.kalilventura.api.categories.infrastructure.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CategoryResponse(@JsonProperty String guid, @JsonProperty String description) {}
