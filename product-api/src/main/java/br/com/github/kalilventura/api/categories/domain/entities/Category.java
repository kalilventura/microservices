package br.com.github.kalilventura.api.categories.domain.entities;

import lombok.Builder;

@Builder
public record Category (String guid, String description) {}
