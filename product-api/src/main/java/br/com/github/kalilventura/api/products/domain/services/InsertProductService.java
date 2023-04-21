package br.com.github.kalilventura.api.products.domain.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;

public interface InsertProductService {

    Product save(Product product);
}
