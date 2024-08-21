package br.com.github.kalilventura.api.categories.domain.commands;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import br.com.github.kalilventura.api.categories.domain.services.InsertCategoryService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class InsertCategoryCommand {

    private final InsertCategoryService insertService;
    private final FindCategoryService findService;

    public InsertCategoryCommand(
            final InsertCategoryService insertCategoryService,
            final FindCategoryService findCategoryService) {
        insertService = insertCategoryService;
        findService = findCategoryService;
    }

    public void execute(final Category category, final Listeners listeners) {
        findService
            .findByDescription(category.description())
            .ifPresentOrElse(
                existent -> listeners.onExists().run(),
                () -> listeners.onCreated()
                    .accept(insertService.save(category)));
    }

    public record Listeners(Consumer<Category> onCreated, Runnable onExists) {}
}
