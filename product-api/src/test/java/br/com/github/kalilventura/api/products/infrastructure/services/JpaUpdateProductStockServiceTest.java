package br.com.github.kalilventura.api.products.infrastructure.services;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.builders.JpaProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@Tag("unit")
@NoArgsConstructor
class JpaUpdateProductStockServiceTest {

  @Test
  @VisibleForTesting
  @DisplayName("should return a product with target guid successfully")
  void updateStockSuccessfully() {
    // given
    final var product = new ProductBuilder().buildDefault();
    final var jpa = new JpaProductBuilder().buildDefault();

    final var repository = Mockito.mock(ProductsRepository.class);
    when(repository.findByGuid(anyString())).thenReturn(Optional.of(jpa));

    final var service = new JpaUpdateProductStockService(repository);

    // when
    service.updateStock(product);

    // then
    verify(repository).save(jpa);
  }
}
