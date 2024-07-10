package br.com.github.kalilventura.api.categories.infrastructure.controllers;

import java.util.List;

import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.kalilventura.api.categories.domain.commands.FindAllCategoriesCommand;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.CategoryResponse;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class FindAllCategoriesController {

    private final FindAllCategoriesCommand command;

    public FindAllCategoriesController(final FindAllCategoriesCommand findAllCommand) {
        command = findAllCommand;
    }

    @GetMapping("/categories")
    public @ResponseBody ResponseEntity<List<CategoryResponse>> get() {
        final var wrapper = new ResponseHolder<List<CategoryResponse>>();
        final var listeners = new FindAllCategoriesCommand.Listeners(categories -> onSuccess(categories, wrapper), () -> onEmpty(wrapper));
        command.execute(listeners);
        return wrapper.getResponse();
    }

    private void onSuccess(final List<Category> categories, final ResponseHolder<List<CategoryResponse>> response) {
        final var content = categories.stream().map(CategoryResponse::toResponse).toList();
        response.setResponse(ResponseEntity.ok(content));
    }

    private void onEmpty(final ResponseHolder<List<CategoryResponse>> response) {
        response.setResponse(ResponseEntity.noContent().build());
    }
}
