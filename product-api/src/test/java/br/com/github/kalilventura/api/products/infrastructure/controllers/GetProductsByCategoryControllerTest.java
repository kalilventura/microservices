package br.com.github.kalilventura.api.products.infrastructure.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.domain.commands.doubles.GetProductsByCategoryCommandStub;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@Tag("unit")
@NoArgsConstructor
class GetProductsByCategoryControllerTest {

  @Test
  @VisibleForTesting
  @DisplayName("should respond OK (200) when there are products to show")
  void shouldRespondOk() {
    // given
    final var guid = GuidHelper.getRandomValue();
    final var products = new ProductBuilder().buildMany(10);
    final var command = new GetProductsByCategoryCommandStub().withOnSuccess(products);
    final var controller = new GetProductsByCategoryController(command);

    // when
    final var response = controller.get(guid);

    // then
    assertNotNull(response.getBody(), "response body has data");
    assertEquals(HttpStatus.OK, response.getStatusCode(), "http status is 200");
  }

  @Test
  @VisibleForTesting
  @DisplayName("should respond NO_CONTENT (201) when there's no product to show")
  void shouldRespondNoContent() {
    // given
    final var guid = GuidHelper.getRandomValue();
    final var command = new GetProductsByCategoryCommandStub().withOnEmpty();
    final var controller = new GetProductsByCategoryController(command);

    // when
    final var response = controller.get(guid);

    // then
    assertNull(response.getBody(), "response body has no data");
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode(), "http status is 201");
  }
}
