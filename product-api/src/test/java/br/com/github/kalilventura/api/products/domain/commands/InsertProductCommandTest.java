package br.com.github.kalilventura.api.products.domain.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.domain.commands.InsertProductCommand.Listeners;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryGetProductByNameService;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryInsertProductService;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class InsertProductCommandTest {

  @Test
  @VisibleForTesting
  @DisplayName("should call onSuccess when add a new product successfully")
  void shouldCallOnSuccess() {
    // given
    final var name = "shampoo";
    final var products = new ProductBuilder().withName(name).buildMany(1);

    final var newProduct = new ProductBuilder().buildDefault();

    final var insertProductService = new InMemoryInsertProductService();
    final var getProductByNameService = new InMemoryGetProductByNameService(products);
    final var command = new InsertProductCommand(insertProductService, getProductByNameService);

    // when
    final var listeners = new Listeners(MockitoHelper.mockConsumer(), null);
    command.execute(newProduct, listeners);

    // then
    verify(listeners.onSuccess(), times(1)).accept(newProduct);
  }

  @Test
  @VisibleForTesting
  @DisplayName("should call onExists when there's a product with the same name")
  void shouldCallOnExists() {
    // given
    final var name = "shampoo";
    final var products = new ProductBuilder().withName(name).buildMany(1);
    final var newProduct = new ProductBuilder().withName(name).buildDefault();

    final var insertProductService = new InMemoryInsertProductService();
    final var getProductByNameService = new InMemoryGetProductByNameService(products);
    final var command = new InsertProductCommand(insertProductService, getProductByNameService);

    // when
    final var listeners = new Listeners(null, MockitoHelper.mockConsumer());
    command.execute(newProduct, listeners);

    // then
    verify(listeners.onExists(), times(1)).accept(newProduct);
  }
}
