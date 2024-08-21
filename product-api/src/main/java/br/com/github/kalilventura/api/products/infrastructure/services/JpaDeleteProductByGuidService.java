package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.products.domain.services.DeleteProductByGuidService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class JpaDeleteProductByGuidService implements DeleteProductByGuidService {

    private final ProductsRepository repository;

    public JpaDeleteProductByGuidService(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @Override
    @CacheEvict(value = "products", key = "#guid")
    public void deleteByGuid(final String guid) {
        repository.deleteByGuid(guid);
    }
}
