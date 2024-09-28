package br.com.github.kalilventura.api.categories.infrastructure.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.github.kalilventura.api.categories.domain.builders.CategoryBuilder;
import br.com.github.kalilventura.api.categories.domain.commands.doubles.InsertCategoryCommandStub;
import br.com.github.kalilventura.api.categories.infrastructure.builders.InsertCategoryRequestBuilder;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@Tag("unit")
@NoArgsConstructor
class InsertCategoryControllerTest {

  @Test
  @VisibleForTesting
  @DisplayName("should respond CREATED (201) when add a category successfully")
  void shouldRespondOk() {
    // given
    final var category = new CategoryBuilder().buildDefault();
    final var request = new InsertCategoryRequestBuilder().buildDefault();

    final var command = new InsertCategoryCommandStub().withOnCreated(category);
    final var controller = new InsertCategoryController(command);

    // when
    final var response = controller.post(request);

    // then
    assertNotNull(response.getBody(), "the response has body");
    assertEquals(HttpStatus.CREATED, response.getStatusCode(), "the status code is 201");
  }

  @Test
  @VisibleForTesting
  @DisplayName("should respond BAD_REQUEST (400) when the category already exists")
  void shouldRespondBadRequest() {
    // given
    final var request = new InsertCategoryRequestBuilder().buildDefault();

    final var command = new InsertCategoryCommandStub().withOnExists();
    final var controller = new InsertCategoryController(command);

    // when
    final var response = controller.post(request);

    // then
    assertNull(response.getBody(), "the response body is empty");
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "the status code is 400");
  }
}
