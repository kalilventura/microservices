package br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.mappers;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.CategoryResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:02:08-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryResponse mapToResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        String guid = null;
        String description = null;

        guid = category.guid();
        description = category.description();

        CategoryResponse categoryResponse = new CategoryResponse( guid, description );

        return categoryResponse;
    }
}
