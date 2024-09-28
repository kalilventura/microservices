package br.com.github.kalilventura.api.categories.infrastructure.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.github.kalilventura.api.categories.domain.builders.CategoryBuilder;
import br.com.github.kalilventura.api.categories.domain.commands.doubles.FindAllCategoriesCommandStub;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@Tag("unit")
@NoArgsConstructor
class FindAllControllerTest {

  @Test
  @VisibleForTesting
  @DisplayName("should respond OK (200) when return a list of categories")
  void shouldRespondOk() {
    // given
    final var categories = new CategoryBuilder().buildMany(10);

    final var command = new FindAllCategoriesCommandStub().withOnSuccess(categories);
    final var controller = new FindAllCategoriesController(command);

    // when
    final var response = controller.get();

    // then
    assertNotNull(response.getBody(), "the response has body");
    assertEquals(HttpStatus.OK, response.getStatusCode(), "the status code is 200");
  }

  @Test
  @VisibleForTesting
  @DisplayName("should respond NO_CONTENT (201) when return an empty list")
  void shouldRespondBadRequest() {
    // given
    final var command = new FindAllCategoriesCommandStub().withOnEmpty();
    final var controller = new FindAllCategoriesController(command);

    // when
    final var response = controller.get();

    // then
    assertNull(response.getBody(), "the response body is empty");
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode(), "the status code is 201");
  }
}
