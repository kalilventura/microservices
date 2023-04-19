package br.com.github.kalilventura.api.products.infrastructure.repositories.doubles;

import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class DummyProductsRepository implements ProductsRepository {

    @Override
    public Optional<JpaProduct> findByGuid(final String guid) {
        return Optional.empty();
    }
}
