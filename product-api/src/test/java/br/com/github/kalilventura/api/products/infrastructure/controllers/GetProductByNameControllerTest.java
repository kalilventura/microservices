package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.domain.commands.doubles.GetProductByNameCommandStub;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
@NoArgsConstructor
class GetProductByNameControllerTest {

    @Test
    @VisibleForTesting
    @DisplayName("should respond OK (200) when there's a product to show")
    void shouldRespondOk() {
        // given
        final var name = "test";
        final var product = new ProductBuilder().buildDefault();

        final var command = new GetProductByNameCommandStub().withOnSuccess(product);
        final var controller = new GetProductByNameController(command);

        // when
        final var response = controller.get(name);

        // then
        assertNotNull(response.getBody(), "response body has data");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "http status is 200");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should respond NOT_FOUND (404) when there's no product to show")
    void shouldRespondNotFound() {
        // given
        final var name = "test";

        final var command = new GetProductByNameCommandStub().withOnNotFound();
        final var controller = new GetProductByNameController(command);

        // when
        final var response = controller.get(name);

        // then
        assertNull(response.getBody(), "response body has no data");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "http status is 404");
    }
}