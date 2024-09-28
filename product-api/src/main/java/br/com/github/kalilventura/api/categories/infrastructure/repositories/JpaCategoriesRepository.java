package br.com.github.kalilventura.api.categories.infrastructure.repositories;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoriesRepository
    extends CategoriesRepository, CrudRepository<JpaCategory, Long> {}
