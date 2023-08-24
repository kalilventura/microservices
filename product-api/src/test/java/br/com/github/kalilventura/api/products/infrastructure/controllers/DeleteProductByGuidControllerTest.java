package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.domain.commands.doubles.DeleteProductByGuidCommandStub;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
@NoArgsConstructor
class DeleteProductByGuidControllerTest {

    @Test
    @VisibleForTesting
    @DisplayName("should respond OK (200) when delete the product successfully")
    void shouldRespondOk() {
        // given
        final var guid = GuidHelper.getRandomValue();
        final var command = new DeleteProductByGuidCommandStub().withOnSuccess();
        final var controller = new DeleteProductByGuidController(command);

        // when
        final var response = controller.get(guid);

        // then
        assertNull(response.getBody(), "response body has no data");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "http status is 200");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should respond NO_CONTENT (201) when there's no product to delete")
    void shouldRespondNoContent() {
        // given
        final var guid = GuidHelper.getRandomValue();
        final var command = new DeleteProductByGuidCommandStub().withOnEmpty();
        final var controller = new DeleteProductByGuidController(command);

        // when
        final var response = controller.get(guid);

        // then
        assertNull(response.getBody(), "response body has no data");
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode(), "http status is 201");
    }
}