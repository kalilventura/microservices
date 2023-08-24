package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByNameService;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class DummyGetProductByNameService implements GetProductByNameService {

    private final List<Product> items = new ArrayList<>(1);

    public DummyGetProductByNameService(final List<Product> collection) {
        items.addAll(collection);
    }

    @Override
    public Optional<Product> getByName(final String name) {
        return items.stream()
                .filter(product -> product.name().equals(name))
                .findFirst();
    }
}
