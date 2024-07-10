package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.InsertProductService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import org.springframework.stereotype.Service;

@Service
public class JpaInsertProductService implements InsertProductService {

    private final ProductsRepository repository;

    public JpaInsertProductService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    public Product save(final Product product) {
        final var newEntity = repository.save(JpaProduct.toJpa(product));
        return newEntity.toDomain();
    }
}
