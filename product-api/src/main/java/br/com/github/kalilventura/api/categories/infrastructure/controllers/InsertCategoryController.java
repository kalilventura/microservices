package br.com.github.kalilventura.api.categories.infrastructure.controllers;

import br.com.github.kalilventura.api.categories.domain.commands.InsertCategoryCommand;
import br.com.github.kalilventura.api.categories.domain.commands.InsertCategoryCommand.Listeners;
import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.requests.InsertCategoryRequest;
import br.com.github.kalilventura.api.categories.infrastructure.controllers.responses.CategoryResponse;
import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
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
public final class InsertCategoryController {

  private final InsertCategoryCommand command;

  public InsertCategoryController(final InsertCategoryCommand insertCategoryCommand) {
    command = insertCategoryCommand;
  }

  @PostMapping("/categories")
  public ResponseEntity<CategoryResponse> post(@RequestBody final InsertCategoryRequest request) {
    final var wrapper = new ResponseHolder<CategoryResponse>();
    final var listeners =
        new Listeners(category -> onCreated(category, wrapper), () -> onExists(wrapper));
    command.execute(request.toDomain(), listeners);
    return wrapper.getResponse();
  }

  private void onCreated(final Category category, final ResponseHolder<CategoryResponse> response) {
    response.setResponse(
        new ResponseEntity<>(CategoryResponse.toResponse(category), HttpStatus.CREATED));
  }

  private void onExists(final ResponseHolder<CategoryResponse> response) {
    response.setResponse(ResponseEntity.badRequest().build());
  }
}
