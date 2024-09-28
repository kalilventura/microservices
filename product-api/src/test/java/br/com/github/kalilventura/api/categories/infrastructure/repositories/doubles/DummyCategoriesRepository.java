package br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DummyCategoriesRepository implements CategoriesRepository {

  @Override
  public Optional<JpaCategory> findByGuid(final String guid) {
    return Optional.empty();
  }

  @Override
  public Optional<JpaCategory> findById(final Long id) {
    return Optional.empty();
  }

  @Override
  public Optional<JpaCategory> findByDescription(final String description) {
    return Optional.empty();
  }

  @Override
  public List<JpaCategory> findAll() {
    return new ArrayList<>(1);
  }

  @Override
  public JpaCategory save(final JpaCategory jpa) {
    return null;
  }
}
