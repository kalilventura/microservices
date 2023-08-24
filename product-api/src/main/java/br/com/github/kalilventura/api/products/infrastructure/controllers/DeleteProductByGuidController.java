package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.commands.DeleteProductByGuidCommand;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public class DeleteProductByGuidController {

    @Getter(AccessLevel.PRIVATE)
    private final DeleteProductByGuidCommand command;

    private ResponseEntity<Void> response;

    public DeleteProductByGuidController(final DeleteProductByGuidCommand deleteProductByGuidCommand) {
        command = deleteProductByGuidCommand;
    }

    @DeleteMapping("/products/{guid}")
    public ResponseEntity<Void> get(@PathVariable("guid") final String guid) {
        final var listeners = new DeleteProductByGuidCommand.Listeners(this::onSuccess, this::onEmpty);
        getCommand().execute(guid, listeners);
        return response;
    }

    private void onSuccess() {
        response = ResponseEntity.ok().build();
    }

    private void onEmpty() {
        response = ResponseEntity.noContent().build();
    }

}
