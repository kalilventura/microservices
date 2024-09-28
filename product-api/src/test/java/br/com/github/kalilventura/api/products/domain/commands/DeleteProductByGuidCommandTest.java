package br.com.github.kalilventura.api.products.domain.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyDeleteProductByGuidService;
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
class DeleteProductByGuidCommandTest {

  @Test
  @VisibleForTesting
  @DisplayName("should call onSuccess when there's a product with target guid")
  void shouldCallOnSuccess() {
    // given
    final var guid = GuidHelper.getRandomValue();
    final var product = new ProductBuilder().withGuid(guid).buildDefault();

    final var service = new DummyDeleteProductByGuidService();
    final var getService = new InMemoryGetProductByGuidService(List.of(product));
    final var command = new DeleteProductByGuidCommand(service, getService);
    final var listeners =
        new DeleteProductByGuidCommand.Listeners(MockitoHelper.mockRunnable(), null);

    // when
    command.execute(guid, listeners);

    // then
    verify(listeners.onSuccess(), times(1)).run();
  }

  @Test
  @VisibleForTesting
  @DisplayName("should call onEmpty when there's no product with the provided guid")
  void shouldCallOnEmpty() {
    // given
    final var guid = GuidHelper.getRandomValue();

    final var service = new DummyDeleteProductByGuidService();
    final var getService = new DummyGetProductByGuidService();
    final var command = new DeleteProductByGuidCommand(service, getService);
    final var listeners =
        new DeleteProductByGuidCommand.Listeners(null, MockitoHelper.mockRunnable());

    // when
    command.execute(guid, listeners);

    // then
    verify(listeners.onEmpty(), times(1)).run();
  }
}
