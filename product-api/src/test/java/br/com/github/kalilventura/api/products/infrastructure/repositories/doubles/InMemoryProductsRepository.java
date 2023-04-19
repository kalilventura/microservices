package br.com.github.kalilventura.api.products.infrastructure.repositories.doubles;

import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class InMemoryProductsRepository implements ProductsRepository {

    private final List<JpaProduct> items = new ArrayList<>(1);

    public InMemoryProductsRepository(final List<JpaProduct> products) {
        items.addAll(products);
    }

    @Override
    public Optional<JpaProduct> findByGuid(final String guid) {
        return items.stream().filter(product -> product.getGuid().equals(guid)).findFirst();
    }
}
