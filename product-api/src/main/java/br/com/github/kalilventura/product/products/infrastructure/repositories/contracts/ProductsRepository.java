package br.com.github.kalilventura.product.products.infrastructure.repositories.contracts;

import br.com.github.kalilventura.product.products.infrastructure.repositories.models.JpaProduct;

import java.util.Optional;

public interface ProductsRepository {

    Optional<JpaProduct> findByGuid(String guid);
}
