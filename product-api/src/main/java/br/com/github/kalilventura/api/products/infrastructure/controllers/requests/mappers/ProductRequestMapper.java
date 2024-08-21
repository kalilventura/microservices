package br.com.github.kalilventura.api.products.infrastructure.controllers.requests.mappers;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRequestMapper {

    ProductRequestMapper INSTANCE = Mappers.getMapper(ProductRequestMapper.class);

    Product mapToEntity(ProductRequest request);
}
