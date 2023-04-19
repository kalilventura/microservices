package br.com.github.kalilventura.api.products.infrastructure.listeners.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.listeners.messages.ProductStockMessage;
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
