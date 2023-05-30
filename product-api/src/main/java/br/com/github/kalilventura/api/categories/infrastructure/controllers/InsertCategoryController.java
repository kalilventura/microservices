package br.com.github.kalilventura.api.categories.infrastructure.controllers;

import br.com.github.kalilventura.api.categories.domain.commands.InsertCategoryCommand;
import br.com.github.kalilventura.api.categories.domain.commands.InsertCategoryCommand.Listeners;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.mappers.CategoryMapper;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.InsertCategoryRequest;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.mappers.InsertCategoryMapper;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.CategoryResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public class InsertCategoryController {

    @Getter(AccessLevel.PRIVATE)
    private final InsertCategoryCommand command;

    @Setter(AccessLevel.PRIVATE)
    private ResponseEntity<CategoryResponse> response;

    public InsertCategoryController(final InsertCategoryCommand insertCategoryCommand) {
        command = insertCategoryCommand;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> post(@RequestBody final InsertCategoryRequest request) {
        final var listeners = new Listeners(this::onCreated, this::onExists);
        final var entity = InsertCategoryMapper.INSTANCE.mapToEntity(request);

        getCommand().execute(entity, listeners);
        return response;
    }

    private void onCreated(final Category category) {
        setResponse(new ResponseEntity<>(CategoryMapper.INSTANCE.mapToResponse(category), HttpStatus.CREATED));
    }

    private void onExists() {
        setResponse(ResponseEntity.badRequest().build());
    }
}
