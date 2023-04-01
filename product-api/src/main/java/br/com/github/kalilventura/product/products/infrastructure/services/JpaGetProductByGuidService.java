package br.com.github.kalilventura.product.products.infrastructure.services;

import br.com.github.kalilventura.product.products.domain.entities.Product;
import br.com.github.kalilventura.product.products.domain.services.GetProductByGuidService;
import br.com.github.kalilventura.product.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.product.products.infrastructure.services.mappers.ProductMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaGetProductByGuidService implements GetProductByGuidService {

    @Getter(AccessLevel.PRIVATE)
    private final ProductsRepository repository;

    public JpaGetProductByGuidService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    public Optional<Product> getByGuid(final String guid) {
        final var jpa = getRepository().findByGuid(guid);
        return jpa.map(ProductMapper.INSTANCE::mapToEntity);
    }
}
