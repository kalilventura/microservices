package br.com.github.kalilventura.api.products.domain.commands.doubles;

import br.com.github.kalilventura.api.products.domain.commands.GetProductsByCategoryCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryGetProductByCategoryService;

import java.util.List;
import java.util.function.Consumer;

public class GetProductsByCategoryCommandStub extends GetProductsByCategoryCommand {

    private Consumer<Listeners> callback = listeners -> {};

    public GetProductsByCategoryCommandStub() {
        super(new InMemoryGetProductByCategoryService());
    }

    @Override
    public void execute(final String guid, final Listeners listeners) {
        callback.accept(listeners);
    }

    public GetProductsByCategoryCommandStub withOnSuccess(final List<Product> products) {
        callback = listeners -> listeners.onSuccess().accept(products);
        return this;
    }

    public GetProductsByCategoryCommandStub withOnEmpty() {
        callback = listeners -> listeners.onEmpty().run();
        return this;
    }
}
