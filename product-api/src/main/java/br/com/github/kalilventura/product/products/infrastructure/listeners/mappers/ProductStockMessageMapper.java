package br.com.github.kalilventura.product.products.infrastructure.listeners.mappers;

import br.com.github.kalilventura.product.products.domain.entities.Product;
import br.com.github.kalilventura.product.products.infrastructure.listeners.messages.ProductStockMessage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductStockMessageMapper {

    ProductStockMessageMapper INSTANCE = Mappers.getMapper(ProductStockMessageMapper.class);

    Product mapToEntity(ProductStockMessage message);
}
