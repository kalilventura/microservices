package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByNameService;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class DummyGetProductByNameService implements GetProductByNameService {

    @Override
    public Optional<Product> getByName(final String name) {
        return Optional.empty();
    }
}
