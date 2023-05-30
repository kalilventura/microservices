package br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository {

    Optional<JpaCategory> findByDescription(String description);

    List<JpaCategory> findAll();

    JpaCategory save(JpaCategory jpa);
}
