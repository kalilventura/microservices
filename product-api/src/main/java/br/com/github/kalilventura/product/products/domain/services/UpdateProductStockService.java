package br.com.github.kalilventura.product.products.domain.services;

import br.com.github.kalilventura.product.products.domain.entities.Product;

public interface UpdateProductStockService {

    void updateStock(Product product);
}
