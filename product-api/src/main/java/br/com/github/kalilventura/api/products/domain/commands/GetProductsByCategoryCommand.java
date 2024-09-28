package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductsByCategoryService;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

@Component
public class GetProductsByCategoryCommand {

  private final GetProductsByCategoryService service;

  public GetProductsByCategoryCommand(final GetProductsByCategoryService productsService) {
    service = productsService;
  }

  public void execute(final String guid, final Listeners listeners) {
    final var products = service.getProductsByCategory(guid);
    if (products.isEmpty()) {
      listeners.onEmpty().run();
    } else {
      listeners.onSuccess().accept(products);
    }
  }

  public record Listeners(Consumer<List<Product>> onSuccess, Runnable onEmpty) {}
}
