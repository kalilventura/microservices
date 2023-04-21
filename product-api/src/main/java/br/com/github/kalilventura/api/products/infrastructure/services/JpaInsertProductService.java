package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.InsertProductService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.services.mappers.ProductMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class JpaInsertProductService implements InsertProductService {

    @Getter(AccessLevel.PRIVATE)
    private final ProductsRepository repository;

    public JpaInsertProductService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    public Product save(final Product product) {
        final var jpa = ProductMapper.INSTANCE.mapToJpa(product);
        final var newEntity = getRepository().save(jpa);
        return ProductMapper.INSTANCE.mapToEntity(newEntity);
    }
}
