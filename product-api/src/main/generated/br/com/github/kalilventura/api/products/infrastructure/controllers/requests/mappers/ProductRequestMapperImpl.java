package br.com.github.kalilventura.api.products.infrastructure.controllers.requests.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.ProductRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:02:08-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
)
public class ProductRequestMapperImpl implements ProductRequestMapper {

    @Override
    public Product mapToEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;

        name = request.name();

        String guid = null;
        Long quantity = null;

        Product product = new Product( guid, name, quantity );

        return product;
    }
}
