package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class InsertProductCommand {

    public void execute(final Product product, final Listeners listeners) {

    }

    public record Listeners(Consumer<Product> onSuccess, Runnable onError) {}
}
