package br.com.github.kalilventura.api.products.infrastructure.controllers.responses.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:02:08-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
)
public class ProductResponseMapperImpl implements ProductResponseMapper {

    @Override
    public ProductResponse mapToResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        String guid = null;
        String name = null;
        Long quantity = null;

        guid = product.guid();
        name = product.name();
        quantity = product.quantity();

        ProductResponse productResponse = new ProductResponse( guid, name, quantity );

        return productResponse;
    }
}
