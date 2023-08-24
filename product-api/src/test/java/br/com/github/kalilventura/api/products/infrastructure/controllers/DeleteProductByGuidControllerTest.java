package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.commands.doubles.DeleteProductByGuidCommandStub;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
@NoArgsConstructor
class DeleteProductByGuidControllerTest {

    @Test
    @VisibleForTesting
    @DisplayName("should respond OK (200) when trying to get the product successfully")
    void shouldRespondOk() {
        // given
        final var command = new DeleteProductByGuidCommandStub();
        final var controller = new DeleteProductByGuidController(command);

        // when
        // then
    }
}