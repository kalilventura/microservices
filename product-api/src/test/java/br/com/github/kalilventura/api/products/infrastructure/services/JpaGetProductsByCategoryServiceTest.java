package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.builders.JpaCategoryBuilder;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.infrastructure.builders.JpaProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.repositories.doubles.DummyProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.doubles.InMemoryProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
@NoArgsConstructor
class JpaGetProductsByCategoryServiceTest {

    @Test
    @VisibleForTesting
    @DisplayName("should return a list of products with the target category successfully")
    void getProductsByCategorySuccessfully() {
        // given
        final var categoryGuid = GuidHelper.getRandomValue();
        final var category = new JpaCategoryBuilder()
                .withGuid(categoryGuid)
                .buildDefault();

        final var products = new JpaProductBuilder()
                .withCategory(category)
                .buildMany(10);

        final var repository = new InMemoryProductsRepository(products);
        final var service = new JpaGetProductsByCategoryService(repository);

        // when
        final var collection = service.getProductsByCategory(categoryGuid);

        // then
        assertEquals(products.size(), collection.size(), "the size is the same");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should return an empty list when there's no product with the target category")
    void getProductsByCategoryEmpty() {
        // given
        final var categoryGuid = GuidHelper.getRandomValue();

        final var repository = new DummyProductsRepository();
        final var service = new JpaGetProductsByCategoryService(repository);

        // when
        final var collection = service.getProductsByCategory(categoryGuid);

        // then
        assertTrue(collection.isEmpty(), "there's no product to show");
    }
}