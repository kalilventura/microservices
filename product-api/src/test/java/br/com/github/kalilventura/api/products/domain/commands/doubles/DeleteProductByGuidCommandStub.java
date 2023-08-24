package br.com.github.kalilventura.api.products.domain.commands.doubles;

import br.com.github.kalilventura.api.products.domain.commands.DeleteProductByGuidCommand;
import br.com.github.kalilventura.api.products.domain.commands.DeleteProductByGuidCommand.Listeners;
import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyDeleteProductByGuidService;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyGetProductByGuidService;

import java.util.function.Consumer;

public class DeleteProductByGuidCommandStub extends DeleteProductByGuidCommand {

    private Consumer<DeleteProductByGuidCommand.Listeners> callback = listeners -> {};

    public DeleteProductByGuidCommandStub() {
        super(new DummyDeleteProductByGuidService(), new DummyGetProductByGuidService());
    }


    @Override
    public void execute(final String guid, final Listeners listeners) {
        callback.accept(listeners);
    }

    public DeleteProductByGuidCommandStub withOnSuccess() {
        callback = listeners -> listeners.onSuccess().run();
        return this;
    }

    public DeleteProductByGuidCommandStub withOnEmpty() {
        callback = listeners -> listeners.onEmpty().run();
        return this;
    }

}
