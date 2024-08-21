package br.com.github.kalilventura.api.products.infrastructure.controllers.requests.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.ProductRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T18:08:43-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
public class ProductRequestMapperImpl implements ProductRequestMapper {

    @Override
    public Product mapToEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        Long quantity = null;
        String categoryId = null;
        Float price = null;

        name = request.name();
        quantity = request.quantity();
        categoryId = request.categoryId();
        price = request.price();

        String guid = null;

        Product product = new Product( guid, name, quantity, categoryId, price );

        return product;
    }
}
