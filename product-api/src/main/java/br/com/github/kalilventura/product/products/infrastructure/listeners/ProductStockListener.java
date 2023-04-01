package br.com.github.kalilventura.product.products.infrastructure.listeners;

import br.com.github.kalilventura.product.products.domain.commands.UpdateProductStockCommand;
import br.com.github.kalilventura.product.products.domain.commands.UpdateProductStockCommand.Listeners;
import br.com.github.kalilventura.product.products.infrastructure.listeners.mappers.ProductStockMessageMapper;
import br.com.github.kalilventura.product.products.infrastructure.listeners.messages.ProductStockMessage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductStockListener {

    @Getter(AccessLevel.PRIVATE)
    private final UpdateProductStockCommand command;

    public ProductStockListener(
            final UpdateProductStockCommand updateProductStockCommand) {
        command = updateProductStockCommand;
    }

    @RabbitListener(queues = "${app-config.rabbit.queue.product-stock}")
    public void process(final ProductStockMessage message) {
        final var product = ProductStockMessageMapper.INSTANCE.mapToEntity(message);
        final var listeners = new Listeners(this::onSuccess, this::onError);
        getCommand().execute(product, listeners);
    }

    private void onSuccess() {
        log.info("Queue processed: " + getClass());
    }

    private void onError() {
        log.error("Queue processing with error: "+ getClass());
    }
}
