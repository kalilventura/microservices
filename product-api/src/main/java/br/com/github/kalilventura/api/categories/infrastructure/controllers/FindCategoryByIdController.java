package br.com.github.kalilventura.api.categories.infrastructure.controllers;

import br.com.github.kalilventura.api.categories.domain.commands.FindCategoryByIdCommand;
import br.com.github.kalilventura.api.categories.domain.commands.FindCategoryByIdCommand.Listeners;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.CategoryResponse;
import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Consumer;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class FindCategoryByIdController {

    private final FindCategoryByIdCommand command;

    public FindCategoryByIdController(final FindCategoryByIdCommand findCommand) {
        command = findCommand;
    }

    @GetMapping("/categories/{id}")
    public @ResponseBody ResponseEntity<CategoryResponse> get(@PathVariable Long id) {
        final var wrapper = new ResponseHolder<CategoryResponse>();

        final var listeners = new Listeners(onSuccess(wrapper), onEmpty(wrapper));
        command.execute(id, listeners);
        return wrapper.getResponse();
    }

    private Consumer<Category> onSuccess(final ResponseHolder<CategoryResponse> wrapper) {
        return category -> wrapper.setResponse(ResponseEntity.ok(CategoryResponse.toResponse(category)));
    }

    private Runnable onEmpty(final ResponseHolder<CategoryResponse> wrapper) {
        return () -> wrapper.setResponse(ResponseEntity.noContent().build());
    }
}
