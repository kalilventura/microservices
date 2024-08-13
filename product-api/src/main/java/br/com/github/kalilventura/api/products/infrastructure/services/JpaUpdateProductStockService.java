package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.UpdateProductStockService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class JpaUpdateProductStockService implements UpdateProductStockService {

    private final ProductsRepository repository;

    public JpaUpdateProductStockService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    @CacheEvict("products")
    public void updateStock(final Product product) {
        final var jpa = repository.findByGuid(product.guid()).orElseThrow();
        jpa.setQuantity(product.quantity());

        repository.save(jpa);
    }
}
