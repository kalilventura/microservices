package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByGuidService;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

@Component
public class GetProductByGuidCommand {

  private final GetProductByGuidService service;

  public GetProductByGuidCommand(final GetProductByGuidService getService) {
    service = getService;
  }

  public void execute(final String guid, final Listeners listeners) {
    final var product = service.getByGuid(guid);
    product.ifPresentOrElse(
        (entity) -> listeners.onSuccess().accept(entity), () -> listeners.onEmpty().run());
  }

  public record Listeners(Consumer<Product> onSuccess, Runnable onEmpty) {}
}
