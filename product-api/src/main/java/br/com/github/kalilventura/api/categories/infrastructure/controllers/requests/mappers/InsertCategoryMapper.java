package br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.mappers;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.InsertCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InsertCategoryMapper {

    InsertCategoryMapper INSTANCE = Mappers.getMapper(InsertCategoryMapper.class);

    Category mapToEntity(InsertCategoryRequest request);
}
