package br.com.github.kalilventura.api.categories.domain.services;

import br.com.github.kalilventura.api.categories.domain.entities.Category;

import java.util.Optional;

public interface FindCategoryService {

    Optional<Category> findByDescription(String description);
}
