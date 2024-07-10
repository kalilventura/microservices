package br.com.github.kalilventura.api.categories.infrastructure.controllers.responses;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.mappers.CategoryMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CategoryResponse(@JsonProperty String guid, @JsonProperty String description) {

    public static CategoryResponse toResponse(final Category category) {
        return CategoryMapper.INSTANCE.mapToResponse(category);
    }
}
