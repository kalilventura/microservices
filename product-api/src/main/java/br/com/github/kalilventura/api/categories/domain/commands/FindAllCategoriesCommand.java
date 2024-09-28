package br.com.github.kalilventura.api.categories.domain.commands;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

@Component
public class FindAllCategoriesCommand {

  private final FindCategoryService service;

  public FindAllCategoriesCommand(final FindCategoryService findService) {
    service = findService;
  }

  public void execute(final Listeners listeners) {
    final var categories = service.findAll();
    if (categories.isEmpty()) {
      listeners.onEmpty().run();
    } else {
      listeners.onSuccess().accept(categories);
    }
  }

  public record Listeners(Consumer<List<Category>> onSuccess, Runnable onEmpty) {}
}
