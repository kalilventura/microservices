package br.com.github.kalilventura.product.products.domain.commands;

import br.com.github.kalilventura.product.products.domain.entities.Product;
import br.com.github.kalilventura.product.products.domain.services.GetProductByGuidService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class GetProductByGuidCommand {

    @Getter(AccessLevel.PRIVATE)
    private final GetProductByGuidService service;

    public GetProductByGuidCommand(final GetProductByGuidService getProductByGuidService) {
        service = getProductByGuidService;
    }

    public void execute(final String guid, final Listeners listeners) {
        final var product = getService().getByGuid(guid);
        product.ifPresentOrElse(
                (entity) -> listeners.onSuccess().accept(entity),
                () -> listeners.onEmpty().run()
        );
    }

    public record Listeners(Consumer<Product> onSuccess, Runnable onEmpty) {}
}
