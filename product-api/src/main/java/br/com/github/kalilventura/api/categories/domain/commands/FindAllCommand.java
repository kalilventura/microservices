package br.com.github.kalilventura.api.categories.domain.commands;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Component
@AllArgsConstructor
public class FindAllCommand {

    @Getter(AccessLevel.PRIVATE)
    private final FindCategoryService service;

    public void execute(final Listeners listeners) {
        final var categories = getService().findAll();
        if (categories.isEmpty()) {
            listeners.onEmpty().run();
        } else {
            listeners.onSuccess().accept(categories);
        }
    }

    public record Listeners(Consumer<List<Category>> onSuccess, Runnable onEmpty) {}

}
