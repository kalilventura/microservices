package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductsByCategoryService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Component
public class GetProductsByCategoryCommand {

    @Getter(AccessLevel.PRIVATE)
    private final GetProductsByCategoryService service;

    public GetProductsByCategoryCommand(final GetProductsByCategoryService productsByCategoryService) {
        service = productsByCategoryService;
    }

    public void execute(final String guid, final Listeners listeners) {
        final var products = getService().getProductsByCategory(guid);
        if (products.isEmpty()) {
            listeners.onEmpty().run();
        } else {
            listeners.onSuccess().accept(products);
        }
    }

    public record Listeners(Consumer<List<Product>> onSuccess, Runnable onEmpty) {}
}
