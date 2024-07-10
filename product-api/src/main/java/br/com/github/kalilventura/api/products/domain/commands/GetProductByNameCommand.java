package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByNameService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class GetProductByNameCommand {

    private final GetProductByNameService service;

    public GetProductByNameCommand(final GetProductByNameService getService) {
        service = getService;
    }

    public void execute(final String name, final Listeners listeners) {
        final var product = service.getByName(name);
        product.ifPresentOrElse(
                (entity) -> listeners.onSuccess().accept(entity),
                () -> listeners.onEmpty().run()
        );
    }

    public record Listeners(Consumer<Product> onSuccess, Runnable onEmpty) {}
}
