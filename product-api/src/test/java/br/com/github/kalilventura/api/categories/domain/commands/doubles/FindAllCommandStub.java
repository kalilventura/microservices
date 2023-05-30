package br.com.github.kalilventura.api.categories.domain.commands.doubles;

import br.com.github.kalilventura.api.categories.domain.commands.FindAllCommand;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.DummyFindCategoryService;

import java.util.List;
import java.util.function.Consumer;

public class FindAllCommandStub extends FindAllCommand {

    private Consumer<Listeners> callback = listeners -> {};

    public FindAllCommandStub() {
        super(new DummyFindCategoryService());
    }

    @Override
    public void execute(final Listeners listeners) {
        callback.accept(listeners);
    }

    public FindAllCommandStub withOnSuccess(final List<Category> categories) {
        callback = listeners -> listeners.onSuccess().accept(categories);
        return this;
    }

    public FindAllCommandStub withOnEmpty() {
        callback = listeners -> listeners.onEmpty().run();
        return this;
    }
}
