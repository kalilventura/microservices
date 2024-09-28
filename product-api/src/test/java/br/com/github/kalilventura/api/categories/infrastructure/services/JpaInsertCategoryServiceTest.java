package br.com.github.kalilventura.api.categories.infrastructure.services;

import static org.junit.jupiter.api.Assertions.*;

import br.com.github.kalilventura.api.categories.domain.builders.CategoryBuilder;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles.InMemoryCategoriesRepository;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class JpaInsertCategoryServiceTest {

  @Test
  @VisibleForTesting
  @DisplayName("should save a product successfully")
  void saveSuccessfully() {
    // given
    final var category = new CategoryBuilder().buildDefault();

    final var repository = new InMemoryCategoriesRepository();
    final var service = new JpaInsertCategoryService(repository);

    // when
    final var entity = service.save(category);

    // then
    assertNotNull(entity, "a new entity has been saved");
  }
}
