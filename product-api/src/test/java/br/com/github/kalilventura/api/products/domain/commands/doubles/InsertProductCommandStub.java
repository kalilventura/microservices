package br.com.github.kalilventura.api.products.domain.commands.doubles;

import br.com.github.kalilventura.api.products.domain.commands.InsertProductCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryGetProductByNameService;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryInsertProductService;
import java.util.function.Consumer;

public class InsertProductCommandStub extends InsertProductCommand {

  private Consumer<Listeners> callback = listeners -> {};

  public InsertProductCommandStub() {
    super(new InMemoryInsertProductService(), new InMemoryGetProductByNameService());
  }

  @Override
  public void execute(final Product newProduct, final Listeners listeners) {
    callback.accept(listeners);
  }

  public InsertProductCommandStub withOnSuccess(final Product product) {
    callback = listeners -> listeners.onSuccess().accept(product);
    return this;
  }

  public InsertProductCommandStub withOnExists(final Product product) {
    callback = listeners -> listeners.onExists().accept(product);
    return this;
  }
}
