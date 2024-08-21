package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.builders.JpaCategoryBuilder;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.infrastructure.builders.JpaProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.repositories.doubles.InMemoryProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
@NoArgsConstructor
class JpaGetProductByGuidServiceTest {

    @Test
    @VisibleForTesting
    @DisplayName("should return a product with target guid successfully")
    void getByGuidSuccessfully() {
        // given
        final var guid = GuidHelper.getRandomValue();

        final var product = new JpaProductBuilder()
            .withGuid(guid)
            .withCategory(new JpaCategoryBuilder().buildDefault())
            .buildDefault();

        final var repository = new InMemoryProductsRepository(List.of(product));
        final var service = new JpaGetProductByGuidService(repository);

        // when
        final var retrieved = service.getByGuid(guid);

        // then
        assertTrue(retrieved.isPresent(), "there's a product with desired guid");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should return an empty product with target guid")
    void getByGuidEmpty() {
        // given
        final var guid = GuidHelper.getRandomValue();

        final var repository = new InMemoryProductsRepository();
        final var service = new JpaGetProductByGuidService(repository);

        // when
        final var product = service.getByGuid(guid);

        // then
        assertTrue(product.isEmpty(), "there's no product with desired guid");
    }
}