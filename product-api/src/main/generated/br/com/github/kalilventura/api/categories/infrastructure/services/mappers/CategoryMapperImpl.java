package br.com.github.kalilventura.api.categories.infrastructure.services.mappers;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T20:25:53-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category mapToEntity(JpaCategory jpa) {
        if ( jpa == null ) {
            return null;
        }

        String guid = null;
        String description = null;

        Category category = new Category( guid, description );

        return category;
    }

    @Override
    public JpaCategory mapToJpa(Category entity) {
        if ( entity == null ) {
            return null;
        }

        JpaCategory jpaCategory = new JpaCategory();

        return jpaCategory;
    }
}
