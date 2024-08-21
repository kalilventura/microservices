package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductsByCategoryService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaGetProductsByCategoryService implements GetProductsByCategoryService {

    @Getter(AccessLevel.PRIVATE)
    private final ProductsRepository repository;

    public JpaGetProductsByCategoryService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    // TODO: why doesn't the cacheable works?
    @Override
    // @Cacheable(value = "products", unless = "#result == null || #result.size() == 0")
    public List<Product> getProductsByCategory(final String categoryId) {
        final var products = getRepository().findByCategoryGuid(categoryId);
        return products.stream().map(JpaProduct::toDomain).toList();
    }
}
