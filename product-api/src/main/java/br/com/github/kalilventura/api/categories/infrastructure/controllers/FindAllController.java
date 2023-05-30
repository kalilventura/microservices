package br.com.github.kalilventura.api.categories.infrastructure.controllers;

import java.util.List;

import br.com.github.kalilventura.api.categories.infrastructure.controllers.mappers.CategoryMapper;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.kalilventura.api.categories.domain.commands.FindAllCommand;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.CategoryResponse;
import lombok.AccessLevel;
import lombok.Getter;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public class FindAllController {

    @Getter(AccessLevel.PRIVATE)
    private final FindAllCommand command;

    @Setter(AccessLevel.PRIVATE)
    private ResponseEntity<List<CategoryResponse>> response;

    public FindAllController(final FindAllCommand findAllCommand) {
        command = findAllCommand;
    }

    @GetMapping("/categories")
    public @ResponseBody ResponseEntity<List<CategoryResponse>> get() {
        final var listeners = new FindAllCommand.Listeners(this::onSuccess, this::onEmpty);
        getCommand().execute(listeners);
        return response;
    }

    private void onSuccess(final List<Category> categories) {
        setResponse(ResponseEntity.ok().body(CategoryMapper.INSTANCE.mapToResponse(categories)));
    }

    private void onEmpty() {
        setResponse(ResponseEntity.noContent().build());
    }
}
