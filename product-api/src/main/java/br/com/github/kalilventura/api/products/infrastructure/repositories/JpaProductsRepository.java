package br.com.github.kalilventura.api.products.infrastructure.repositories;

import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductsRepository
    extends ProductsRepository, CrudRepository<JpaProduct, Long> {

  @Override
  @Query("SELECT P FROM JpaProduct AS P JOIN FETCH P.category WHERE P.guid = :guid")
  Optional<JpaProduct> findByGuid(String guid);

  @Override
  @Query("SELECT P FROM JpaProduct AS P JOIN FETCH P.category WHERE P.name = :name")
  Optional<JpaProduct> findByName(String name);

  @Override
  @Query("SELECT P FROM JpaProduct AS P JOIN FETCH P.category WHERE P.category.guid = :guid")
  List<JpaProduct> findByCategoryGuid(String guid);
}
