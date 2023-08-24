package br.com.github.kalilventura.api.products.infrastructure.repositories.contracts;

import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository {

    Optional<JpaProduct> findByGuid(String guid);

    JpaProduct save(JpaProduct product);

    Optional<JpaProduct> findByName(String name);

    List<JpaProduct> findByCategoryGuid(String guid);

    void deleteByGuid(String guid);
}
