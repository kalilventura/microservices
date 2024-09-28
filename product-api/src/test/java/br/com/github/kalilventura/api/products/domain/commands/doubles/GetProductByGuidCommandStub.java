package br.com.github.kalilventura.api.products.domain.commands.doubles;

import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import java.util.function.Consumer;

public class GetProductByGuidCommandStub extends GetProductByGuidCommand {

  private Consumer<Listeners> callback = listeners -> {};

  public GetProductByGuidCommandStub() {
    super(null);
  }

  @Override
  public void execute(final String guid, final Listeners listeners) {
    callback.accept(listeners);
  }

  public GetProductByGuidCommandStub withOnSuccess(final Product product) {
    callback = listeners -> listeners.onSuccess().accept(product);
    return this;
  }

  public GetProductByGuidCommandStub withOnEmpty() {
    callback = listeners -> listeners.onEmpty().run();
    return this;
  }
}
