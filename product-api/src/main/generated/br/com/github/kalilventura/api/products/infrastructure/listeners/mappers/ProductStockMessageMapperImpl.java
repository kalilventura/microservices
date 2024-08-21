package br.com.github.kalilventura.api.products.infrastructure.listeners.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.listeners.messages.ProductStockMessage;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T18:08:43-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
public class ProductStockMessageMapperImpl implements ProductStockMessageMapper {

    @Override
    public Product mapToEntity(ProductStockMessage message) {
        if ( message == null ) {
            return null;
        }

        String guid = null;
        String name = null;
        Long quantity = null;
        String categoryId = null;
        Float price = null;

        Product product = new Product( guid, name, quantity, categoryId, price );

        return product;
    }
}
