package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByNameService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import br.com.github.kalilventura.api.products.infrastructure.services.mappers.ProductMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaGetProductByNameService implements GetProductByNameService {

    private final ProductsRepository repository;

    public JpaGetProductByNameService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    public Optional<Product> getByName(final String name) {
        final var product = repository.findByName(name);
        return product.map(JpaProduct::toDomain);
    }
}
