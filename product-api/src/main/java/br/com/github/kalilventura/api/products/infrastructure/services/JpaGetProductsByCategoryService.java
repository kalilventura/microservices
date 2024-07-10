package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductsByCategoryService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import br.com.github.kalilventura.api.products.infrastructure.services.mappers.ProductMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaGetProductsByCategoryService implements GetProductsByCategoryService {

    @Getter(AccessLevel.PRIVATE)
    private final ProductsRepository repository;

    public JpaGetProductsByCategoryService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    public List<Product> getProductsByCategory(final String guid) {
        final var products = getRepository().findByCategoryGuid(guid);
        return products.stream().map(JpaProduct::toDomain).toList();
    }
}
