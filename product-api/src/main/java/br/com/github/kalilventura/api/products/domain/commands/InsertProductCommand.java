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

    @Getter(AccessLevel.PRIVATE)
    private final InsertProductService insertService;

    @Getter(AccessLevel.PRIVATE)
    private final GetProductByNameService nameService;

    public InsertProductCommand(
            final InsertProductService insertProductService,
            final GetProductByNameService getProductByNameService) {
        insertService = insertProductService;
        nameService = getProductByNameService;
    }

    public void execute(final Product newProduct, final Listeners listeners) {
        final var hasProduct = getNameService().getByName(newProduct.name());
        if (hasProduct.isPresent()) {
            listeners.onExists().accept(newProduct);
        } else {
            final var product = getInsertService().save(newProduct);
            listeners.onSuccess().accept(product);
        }
    }

    public record Listeners(Consumer<Product> onSuccess, Consumer<Product> onExists) {
    }
}
