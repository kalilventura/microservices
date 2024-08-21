package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.builders.JpaCategoryBuilder;
import br.com.github.kalilventura.api.products.infrastructure.builders.JpaProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.repositories.doubles.DummyProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.doubles.InMemoryProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
@NoArgsConstructor
class JpaGetProductByNameServiceTest {

    @Test
    @VisibleForTesting
    @DisplayName("should get a product with the target name successfully")
    void getByNameSuccessfully() {
        // given
        final var name = "spoon";
        final var products = new JpaProductBuilder()
            .withName(name)
            .withCategory(new JpaCategoryBuilder().buildDefault())
            .buildMany(1);

        final var repository = new InMemoryProductsRepository(products);
        final var service = new JpaGetProductByNameService(repository);

        // when
        final var response = service.getByName(name);

        // then
        assertTrue(response.isPresent(), "there's a product with the desired name");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should return an empty product with the target name")
    void getByNameEmpty() {
        // given
        final var name = "spoon";

        final var repository = new DummyProductsRepository();
        final var service = new JpaGetProductByNameService(repository);

        // when
        final var response = service.getByName(name);

        // then
        assertTrue(response.isEmpty(), "there's no product with the desired name");
    }
}