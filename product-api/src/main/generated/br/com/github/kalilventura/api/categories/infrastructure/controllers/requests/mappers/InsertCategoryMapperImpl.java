package br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.mappers;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.InsertCategoryRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T20:25:52-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
public class InsertCategoryMapperImpl implements InsertCategoryMapper {

    @Override
    public Category mapToEntity(InsertCategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        String description = null;

        description = request.description();

        String guid = null;

        Category category = new Category( guid, description );

        return category;
    }
}
