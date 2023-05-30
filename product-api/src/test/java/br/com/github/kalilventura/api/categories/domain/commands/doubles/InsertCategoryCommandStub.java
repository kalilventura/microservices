package br.com.github.kalilventura.api.categories.domain.commands.doubles;

import br.com.github.kalilventura.api.categories.domain.commands.InsertCategoryCommand;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.DummyFindCategoryService;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.DummyInsertCategoryService;

import java.util.function.Consumer;

public class InsertCategoryCommandStub extends InsertCategoryCommand {

    private Consumer<Listeners> callback = listeners -> {};

    public InsertCategoryCommandStub() {
        super(new DummyInsertCategoryService(), new DummyFindCategoryService());
    }

    @Override
    public void execute(final Category categoryToInsert, final Listeners listeners) {
        callback.accept(listeners);
    }

    public InsertCategoryCommandStub withOnCreated(final Category category) {
        callback = listeners -> listeners.onCreated().accept(category);
        return this;
    }

    public InsertCategoryCommandStub withOnExists() {
        callback = listeners -> listeners.onExists().run();
        return this;
    }
}
