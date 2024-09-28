package br.com.github.kalilventura.api.products.domain.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyGetProductByNameService;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryGetProductByNameService;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class GetProductByNameCommandTest {

  @Test
  @VisibleForTesting
  @DisplayName("should call onSuccess when there is a product with target name")
  void shouldCallOnSuccess() {
    // given
    final var name = "test";
    final var product = new ProductBuilder().withName(name).buildDefault();

    final var service = new InMemoryGetProductByNameService(List.of(product));
    final var command = new GetProductByNameCommand(service);
    final var listeners = new GetProductByNameCommand.Listeners(MockitoHelper.mockConsumer(), null);

    // when
    command.execute(name, listeners);

    // then
    verify(listeners.onSuccess(), times(1)).accept(product);
  }

  @Test
  @VisibleForTesting
  @DisplayName("should call onEmpty when there's no product with target name")
  void shouldCallOnEmpty() {
    // given
    final var name = "test";

    final var service = new DummyGetProductByNameService();
    final var command = new GetProductByNameCommand(service);
    final var listeners = new GetProductByNameCommand.Listeners(null, MockitoHelper.mockRunnable());

    // when
    command.execute(name, listeners);

    // then
    verify(listeners.onEmpty(), times(1)).run();
  }
}
