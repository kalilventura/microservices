package br.com.github.kalilventura.product.products.infrastructure.services.mappers;

import br.com.github.kalilventura.product.products.domain.entities.Product;
import br.com.github.kalilventura.product.products.infrastructure.repositories.models.JpaProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapToEntity(JpaProduct jpa);
}