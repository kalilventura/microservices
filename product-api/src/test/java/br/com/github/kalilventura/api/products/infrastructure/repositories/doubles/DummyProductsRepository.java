package br.com.github.kalilventura.api.products.infrastructure.repositories.doubles;

import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class DummyProductsRepository implements ProductsRepository {

    @Override
    public Optional<JpaProduct> findByGuid(final String guid) {
        return Optional.empty();
    }

    @Override
    public JpaProduct save(final JpaProduct product) {
        return null;
    }

    @Override
    public Optional<JpaProduct> findByName(final String name) {
        return Optional.empty();
    }

    @Override
    public List<JpaProduct> findByCategoryGuid(final String guid) {
        return new ArrayList<>(1);
    }

    @Override
    public void deleteByGuid(final String guid) {
        // do nothing
    }
}
