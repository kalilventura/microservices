package br.com.github.kalilventura.api.products.domain.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryGetProductByCategoryService;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class GetProductsByCategoryCommandTest {

  @Test
  @VisibleForTesting
  @DisplayName("should call onSuccess when there are products to show")
  void shouldCallOnSuccess() {
    // given
    final var guid = GuidHelper.getRandomValue();
    final var products = new ProductBuilder().buildMany(10);

    final var service = new InMemoryGetProductByCategoryService(products);
    final var command = new GetProductsByCategoryCommand(service);
    final var listeners =
        new GetProductsByCategoryCommand.Listeners(MockitoHelper.mockConsumer(), null);

    // when
    command.execute(guid, listeners);

    // then
    verify(listeners.onSuccess(), times(1)).accept(products);
  }

  @Test
  @VisibleForTesting
  @DisplayName("should call onEmpty when there's no product to show")
  void shouldCallOnEmpty() {
    // given
    final var guid = GuidHelper.getRandomValue();

    final var service = new InMemoryGetProductByCategoryService();
    final var command = new GetProductsByCategoryCommand(service);
    final var listeners =
        new GetProductsByCategoryCommand.Listeners(null, MockitoHelper.mockRunnable());

    // when
    command.execute(guid, listeners);

    // then
    verify(listeners.onEmpty(), times(1)).run();
  }
}
