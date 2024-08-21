package br.com.github.kalilventura.api.products.infrastructure.services.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T20:25:53-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product mapToEntity(JpaProduct jpa) {
        if ( jpa == null ) {
            return null;
        }

        String guid = null;
        String name = null;
        Long quantity = null;
        String categoryId = null;

        Product product = new Product( guid, name, quantity, categoryId );

        return product;
    }

    @Override
    public JpaProduct mapToJpa(Product entity) {
        if ( entity == null ) {
            return null;
        }

        JpaProduct jpaProduct = new JpaProduct();

        return jpaProduct;
    }
}
