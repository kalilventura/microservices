package br.com.github.kalilventura.api.products.domain.commands.doubles;

import br.com.github.kalilventura.api.products.domain.commands.GetProductByNameCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyGetProductByNameService;
import java.util.function.Consumer;

public class GetProductByNameCommandStub extends GetProductByNameCommand {

  private Consumer<Listeners> callback = listeners -> {};

  public GetProductByNameCommandStub() {
    super(new DummyGetProductByNameService());
  }

  @Override
  public void execute(final String name, final Listeners listeners) {
    callback.accept(listeners);
  }

  public GetProductByNameCommandStub withOnSuccess(final Product product) {
    callback = listeners -> listeners.onSuccess().accept(product);
    return this;
  }

  public GetProductByNameCommandStub withOnNotFound() {
    callback = listeners -> listeners.onEmpty().run();
    return this;
  }
}
