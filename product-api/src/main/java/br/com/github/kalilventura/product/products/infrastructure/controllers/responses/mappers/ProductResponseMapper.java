package br.com.github.kalilventura.product.products.infrastructure.controllers.responses.mappers;

import br.com.github.kalilventura.product.products.domain.entities.Product;
import br.com.github.kalilventura.product.products.infrastructure.controllers.responses.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductResponseMapper {

    ProductResponseMapper INSTANCE = Mappers.getMapper(ProductResponseMapper.class);

    ProductResponse mapToResponse(Product product);
}
