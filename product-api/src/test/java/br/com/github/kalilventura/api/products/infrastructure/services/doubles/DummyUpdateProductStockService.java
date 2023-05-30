package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.UpdateProductStockService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DummyUpdateProductStockService implements UpdateProductStockService {

    @Override
    public void updateStock(final Product product) {
        /* do nothing because it's a dummy */
    }
}
