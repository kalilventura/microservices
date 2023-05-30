package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyUpdateProductStockService;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Tag("unit")
@NoArgsConstructor
class UpdateProductStockCommandTest {

    @Test
    @VisibleForTesting
    @DisplayName("should call onSuccess when update a product successfully")
    void shouldCallOnSuccess() {
        // given
        final var product = new ProductBuilder().buildDefault();

        final var service = new DummyUpdateProductStockService();
        final var command = new UpdateProductStockCommand(service);
        final var listeners = new UpdateProductStockCommand.Listeners(MockitoHelper.mockRunnable(), null);

        // when
        command.execute(product, listeners);

        // then
        verify(listeners.onSuccess(), times(1)).run();
    }

}