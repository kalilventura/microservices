package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductsByCategoryService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class InMemoryGetProductByCategoryService implements GetProductsByCategoryService {

    @Getter(AccessLevel.PRIVATE)
    private final List<Product> items = new ArrayList<>(1);

    public InMemoryGetProductByCategoryService(final List<Product> collection) {
        items.addAll(collection);
    }

    @Override
    public List<Product> getProductsByCategory(final String guid) {
        return getItems();
    }
}
