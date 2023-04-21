package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.InsertProductService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InMemoryInsertProductService implements InsertProductService {

    @Override
    public Product save(final Product product) {
        return product;
    }
}
