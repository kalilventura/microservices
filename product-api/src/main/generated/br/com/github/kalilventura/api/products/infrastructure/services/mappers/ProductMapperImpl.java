package br.com.github.kalilventura.api.products.infrastructure.services.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:02:08-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
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

        Product product = new Product( guid, name, quantity );

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
