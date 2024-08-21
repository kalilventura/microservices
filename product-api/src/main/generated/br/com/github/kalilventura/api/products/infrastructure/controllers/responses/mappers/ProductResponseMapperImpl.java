package br.com.github.kalilventura.api.products.infrastructure.controllers.responses.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T18:08:43-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
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
        String categoryId = null;
        Float price = null;

        guid = product.guid();
        name = product.name();
        quantity = product.quantity();
        categoryId = product.categoryId();
        price = product.price();

        ProductResponse productResponse = new ProductResponse( guid, name, quantity, categoryId, price );

        return productResponse;
    }
}
