package br.com.github.kalilventura.api.categories.domain.commands;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class FindCategoryByIdCommand {

    private final FindCategoryService service;

    public FindCategoryByIdCommand(final FindCategoryService findService) {
        service = findService;
    }

    public void execute(final Long id, final Listeners listeners) {
        service.findById(id).ifPresentOrElse(
            category -> listeners.onSuccess().accept(category),
            listeners.onEmpty()
        );
    }

    public record Listeners(Consumer<Category> onSuccess, Runnable onEmpty) {}
}
