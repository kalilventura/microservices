package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.UpdateProductStockService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class JpaUpdateProductStockService implements UpdateProductStockService {

    @Getter(AccessLevel.PRIVATE)
    private final ProductsRepository repository;

    public JpaUpdateProductStockService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    public void updateStock(final Product product) {
        final var jpa = getRepository().findByGuid(product.guid()).orElseThrow();
        jpa.setQuantity(product.quantity());

        getRepository().save(jpa);
    }
}
