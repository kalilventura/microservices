package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByNameService;
import br.com.github.kalilventura.api.products.domain.services.InsertProductService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class InsertProductCommand {

    private final InsertProductService insertService;
    private final GetProductByNameService getService;

    public InsertProductCommand(
            final InsertProductService insertProductService,
            final GetProductByNameService getProductByNameService) {
        insertService = insertProductService;
        getService = getProductByNameService;
    }

    public void execute(final Product newProduct, final Listeners listeners) {
        final var hasProduct = getService.getByName(newProduct.name());
        if (hasProduct.isPresent()) {
            listeners.onExists().accept(newProduct);
        } else {
            listeners.onSuccess().accept(insertService.save(newProduct));
        }
    }

    public record Listeners(Consumer<Product> onSuccess, Consumer<Product> onExists) {
    }
}
