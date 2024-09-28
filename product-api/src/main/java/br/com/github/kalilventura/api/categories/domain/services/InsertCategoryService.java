package br.com.github.kalilventura.api.categories.domain.services;

import br.com.github.kalilventura.api.categories.domain.entities.Category;

public interface InsertCategoryService {

  Category save(Category category);
}
