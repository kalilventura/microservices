package br.com.github.kalilventura.api.categories.infrastructure.controllers.requests;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.mappers.InsertCategoryMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record InsertCategoryRequest(@JsonProperty String description) {

    public Category toDomain() {
        return InsertCategoryMapper.INSTANCE.mapToEntity(this);
    }
}
