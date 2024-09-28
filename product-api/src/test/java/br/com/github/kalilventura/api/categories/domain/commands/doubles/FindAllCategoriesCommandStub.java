package br.com.github.kalilventura.api.categories.domain.commands.doubles;

import br.com.github.kalilventura.api.categories.domain.commands.FindAllCategoriesCommand;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.DummyFindCategoryService;
import java.util.List;
import java.util.function.Consumer;

public class FindAllCategoriesCommandStub extends FindAllCategoriesCommand {

  private Consumer<Listeners> callback = listeners -> {};

  public FindAllCategoriesCommandStub() {
    super(new DummyFindCategoryService());
  }

  @Override
  public void execute(final Listeners listeners) {
    callback.accept(listeners);
  }

  public FindAllCategoriesCommandStub withOnSuccess(final List<Category> categories) {
    callback = listeners -> listeners.onSuccess().accept(categories);
    return this;
  }

  public FindAllCategoriesCommandStub withOnEmpty() {
    callback = listeners -> listeners.onEmpty().run();
    return this;
  }
}
