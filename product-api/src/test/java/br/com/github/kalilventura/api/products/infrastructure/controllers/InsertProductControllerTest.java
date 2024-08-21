package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.domain.commands.doubles.InsertProductCommandStub;
import br.com.github.kalilventura.api.products.infrastructure.builders.ProductRequestBuilder;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("unit")
@NoArgsConstructor
class InsertProductControllerTest {

    @Test
    @VisibleForTesting
    @DisplayName("should respond CREATED (201) when add a product successfully")
    void shouldRespondOk() {
        // given
        final var product = new ProductBuilder().buildDefault();
        final var request = new ProductRequestBuilder().buildDefault();

        final var command = new InsertProductCommandStub().withOnSuccess(product);
        final var controller = new InsertProductController(command);

        // when
        final var response = controller.post(request);

        // then
        assertNotNull(response.getBody(), "the response has body");
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "the status code is 201");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should respond OK (200) when the product already exists")
    void shouldRespondBadRequest() {
        // given
        final var product = new ProductBuilder().buildDefault();
        final var request = new ProductRequestBuilder().buildDefault();

        final var command = new InsertProductCommandStub().withOnExists(product);
        final var controller = new InsertProductController(command);

        // when
        final var response = controller.post(request);

        // then
        assertNotNull(response.getBody(), "the response has body");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "the status code is 200");
    }
}