package br.com.github.kalilventura.api.products.infrastructure.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.builders.JpaCategoryBuilder;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles.InMemoryCategoriesRepository;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.builders.JpaProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.repositories.doubles.InMemoryProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import java.util.Objects;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class JpaInsertProductServiceTest {

  @Test
  @VisibleForTesting
  @DisplayName("should save a new product successfully")
  void saveSuccessfully() {
    // given
    final var guid = GuidHelper.getRandomValue();
    final var category = new JpaCategoryBuilder().buildDefault();
    final var product =
        new JpaProductBuilder().withGuid(guid).withCategory(category).buildDefault();

    final var entity = new ProductBuilder().withCategory(category.getGuid()).buildDefault();

    final var repository = new InMemoryProductsRepository(List.of(product));
    final var categoryRepository = new InMemoryCategoriesRepository(List.of(category));
    final var service = new JpaInsertProductService(repository, categoryRepository);

    // when
    final var retrieved = service.save(entity);

    // then
    assertTrue(Objects.nonNull(retrieved), "inserted a new product");
  }
}
