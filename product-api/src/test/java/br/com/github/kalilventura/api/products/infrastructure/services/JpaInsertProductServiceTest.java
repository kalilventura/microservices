package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.builders.JpaProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.repositories.doubles.InMemoryProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
@NoArgsConstructor
class JpaInsertProductServiceTest {

    @Test
    @VisibleForTesting
    @DisplayName("should save a new product successfully")
    void saveSuccessfully() {
        // given
        final var guid = GuidHelper.getRandomValue();

        final var product = new JpaProductBuilder().withGuid(guid).buildDefault();

        final var repository = new InMemoryProductsRepository(List.of(product));
        final var service = new JpaInsertProductService(repository);

        // when
        final var retrieved = service.save(new ProductBuilder().buildDefault());

        // then
        assertTrue(Objects.nonNull(retrieved), "inserted a new product");
    }
}