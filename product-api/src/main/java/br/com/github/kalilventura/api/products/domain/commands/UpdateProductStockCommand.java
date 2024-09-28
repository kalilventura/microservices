package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.UpdateProductStockService;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductStockCommand {

  private final UpdateProductStockService service;

  public UpdateProductStockCommand(final UpdateProductStockService updateService) {
    service = updateService;
  }

  public void execute(final Product product, final Listeners listeners) {
    service.updateStock(product);
    listeners.onSuccess().run();
  }

  public record Listeners(Runnable onSuccess, Runnable onError) {}
}
