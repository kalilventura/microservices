package br.com.github.kalilventura.api.categories.infrastructure.controllers.mappers;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.CategoryResponse;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.mappers.CategoryMapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T23:10:35-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Amazon.com Inc.)"
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

    @Override
    public List<CategoryResponse> mapToResponse(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryResponse> list = new ArrayList<CategoryResponse>( categories.size() );
        for ( Category category : categories ) {
            list.add( mapToResponse( category ) );
        }

        return list;
    }
}
