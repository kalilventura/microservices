package br.com.github.kalilventura.product.products.infrastructure.controllers;

import br.com.github.kalilventura.product.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.product.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.product.products.domain.commands.doubles.GetProductByGuidCommandStub;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
@NoArgsConstructor
class GetProductByGuidControllerTest {

    @Test
    @VisibleForTesting
    @DisplayName("should respond OK (200) when trying to get the product successfully")
    void shouldRespondOk() {
        // given
        final var guid = GuidHelper.getRandomValue();
        final var product = new ProductBuilder().buildDefault();
        final var command = new GetProductByGuidCommandStub().withOnSuccess(product);

        final var controller = new GetProductByGuidController(command);

        // when
        final var response = controller.get(guid);

        // then
        assertNotNull(response.getBody(), "response body has data");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "http status was 200");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should return NO_CONTENT (201) when there's no product with desired guid")
    void shouldRespondNoContent() {
        // given
        final var guid = GuidHelper.getRandomValue();

        final var command = new GetProductByGuidCommandStub().withOnEmpty();
        final var controller = new GetProductByGuidController(command);

        // when
        final var response = controller.get(guid);

        // then
        assertNull(response.getBody());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode(), "http status was 201");
    }
}