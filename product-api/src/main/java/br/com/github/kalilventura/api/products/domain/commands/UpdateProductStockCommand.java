package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.UpdateProductStockService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductStockCommand {

    @Getter(AccessLevel.PRIVATE)
    private final UpdateProductStockService service;

    public UpdateProductStockCommand(final UpdateProductStockService updateProductStockService) {
        service = updateProductStockService;
    }

    public void execute(final Product product, final Listeners listeners) {
        getService().updateStock(product);
        listeners.onSuccess().run();
    }

    public record Listeners(Runnable onSuccess, Runnable onError) {}
}
