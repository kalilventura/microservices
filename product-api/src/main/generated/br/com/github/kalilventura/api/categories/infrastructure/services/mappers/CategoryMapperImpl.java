package br.com.github.kalilventura.api.categories.infrastructure.services.mappers;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T23:10:35-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Amazon.com Inc.)"
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
