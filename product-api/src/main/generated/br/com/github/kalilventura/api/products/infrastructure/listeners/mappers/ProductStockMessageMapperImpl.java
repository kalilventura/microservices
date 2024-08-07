package br.com.github.kalilventura.api.products.infrastructure.listeners.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.listeners.messages.ProductStockMessage;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T23:10:35-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Amazon.com Inc.)"
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

        Product product = new Product( guid, name, quantity );

        return product;
    }
}
