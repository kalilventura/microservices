package br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.mappers;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.InsertCategoryRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:02:08-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
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
