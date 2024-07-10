package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByGuidService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import br.com.github.kalilventura.api.products.infrastructure.services.mappers.ProductMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaGetProductByGuidService implements GetProductByGuidService {

    private final ProductsRepository repository;

    public JpaGetProductByGuidService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    public Optional<Product> getByGuid(final String guid) {
        final var product = repository.findByGuid(guid);
        return product.map(JpaProduct::toDomain);
    }
}
