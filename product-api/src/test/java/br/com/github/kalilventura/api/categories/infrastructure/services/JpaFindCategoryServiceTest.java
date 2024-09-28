package br.com.github.kalilventura.api.categories.infrastructure.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.builders.JpaCategoryBuilder;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles.DummyCategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles.InMemoryCategoriesRepository;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class JpaFindCategoryServiceTest {

  @Test
  @VisibleForTesting
  @DisplayName("should return a category by description")
  void findByDescriptionSuccessfully() {
    // given
    final var category = new JpaCategoryBuilder().buildDefault();
    final var repository = new InMemoryCategoriesRepository(List.of(category));
    final var service = new JpaFindCategoryService(repository);

    // when
    final var response = service.findByDescription(category.getDescription());

    // then
    assertTrue(response.isPresent(), "there's a category with the desired description");
  }

  @Test
  @VisibleForTesting
  @DisplayName("should return an empty category by description")
  void findByDescriptionEmpty() {
    // given
    final var category = new JpaCategoryBuilder().buildDefault();
    final var repository = new DummyCategoriesRepository();
    final var service = new JpaFindCategoryService(repository);

    // when
    final var response = service.findByDescription(category.getDescription());

    // then
    assertTrue(response.isEmpty(), "there's no category with the desired description");
  }

  @Test
  @VisibleForTesting
  @DisplayName("should return a list of categories successfully")
  void findAllSuccessfully() {
    // given
    final var categories = new JpaCategoryBuilder().buildMany(10);
    final var repository = new InMemoryCategoriesRepository(categories);
    final var service = new JpaFindCategoryService(repository);

    // when
    final var elements = service.findAll();

    // then
    assertFalse(elements.isEmpty(), "there are elements to show");
  }

  @Test
  @VisibleForTesting
  @DisplayName("should return an empty list of category")
  void findAllEmpty() {
    // given
    final var repository = new DummyCategoriesRepository();
    final var service = new JpaFindCategoryService(repository);

    // when
    final var elements = service.findAll();

    // then
    assertTrue(elements.isEmpty(), "there are elements to show");
  }
}
