package br.com.github.kalilventura.api.products.infrastructure.repositories;

import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Isolated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Isolated
@DataJpaTest
//@SpringBootTest
@Tag("integration")
@ActiveProfiles("test")
//@ExtendWith(SpringExtension.class)
class JpaProductsRepositoryTest {

    private final ProductsRepository repository;

    @Autowired
    @VisibleForTesting
    JpaProductsRepositoryTest(final ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @BeforeEach
    @VisibleForTesting
    void checkInstance() {
        assertTrue(repository instanceof JpaProductsRepository, "the repository is JPA Repository");
    }

    @Test
    @VisibleForTesting
    @Sql({"/db/seeders/products/product_01.sql"})
    @DisplayName("should get a product by guid successfully")
    void findByGuidSuccessfully() {
        // given
        final var guid = "703cfc68-4e6c-4472-9752-6e658a092744";

        // when
        final var product = repository.findByGuid(guid);

        // then
        assertTrue(product.isPresent(), "there's a product with the desired guid");
    }
}