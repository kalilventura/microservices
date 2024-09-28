package br.com.github.kalilventura.api.products.domain.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyGetProductByGuidService;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryGetProductByGuidService;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class GetProductByGuidCommandTest {

  @Test
  @VisibleForTesting
  @DisplayName("should call onSuccess when there is a product with target guid")
  void shouldCallOnSuccess() {
    // given
    final var guid = GuidHelper.getRandomValue();

    final var product = new ProductBuilder().withGuid(guid).buildDefault();

    final var service = new InMemoryGetProductByGuidService(List.of(product));
    final var command = new GetProductByGuidCommand(service);

    final var listeners =
        new GetProductByGuidCommand.Listeners(
            MockitoHelper.mockConsumer(), MockitoHelper.mockRunnable());

    // when
    final var argumentCaptor = MockitoHelper.captorForClass(Product.class);
    command.execute(guid, listeners);

    // then
    verify(listeners.onSuccess(), times(1)).accept(argumentCaptor.capture());
  }

  @Test
  @VisibleForTesting
  @DisplayName("should call onEmpty when there's no product with target guid")
  void shouldCallOnEmpty() {
    // given
    final var guid = GuidHelper.getRandomValue();

    final var service = new DummyGetProductByGuidService();
    final var command = new GetProductByGuidCommand(service);

    final var listeners =
        new GetProductByGuidCommand.Listeners(
            MockitoHelper.mockConsumer(), MockitoHelper.mockRunnable());

    // when
    command.execute(guid, listeners);

    // then
    verify(listeners.onEmpty(), times(1)).run();
  }
}
