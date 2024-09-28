package br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InMemoryCategoriesRepository implements CategoriesRepository {

  private final List<JpaCategory> items = new ArrayList<>(1);

  public InMemoryCategoriesRepository(final List<JpaCategory> categories) {
    items.addAll(categories);
  }

  @Override
  public Optional<JpaCategory> findByGuid(final String guid) {
    return items.stream().filter(jpaCategory -> jpaCategory.getGuid().equals(guid)).findFirst();
  }

  @Override
  public Optional<JpaCategory> findById(final Long id) {
    return items.stream().filter(jpa -> jpa.getId().equals(id)).findFirst();
  }

  @Override
  public Optional<JpaCategory> findByDescription(final String description) {
    return items.stream().filter(jpa -> jpa.getDescription().equals(description)).findFirst();
  }

  @Override
  public List<JpaCategory> findAll() {
    return items;
  }

  @Override
  public JpaCategory save(final JpaCategory jpa) {
    items.add(jpa);
    return jpa;
  }
}
