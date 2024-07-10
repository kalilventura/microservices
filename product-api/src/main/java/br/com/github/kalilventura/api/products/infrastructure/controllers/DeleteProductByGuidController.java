package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
import br.com.github.kalilventura.api.products.domain.commands.DeleteProductByGuidCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class DeleteProductByGuidController {

    private final DeleteProductByGuidCommand command;

    public DeleteProductByGuidController(final DeleteProductByGuidCommand deleteCommand) {
        command = deleteCommand;
    }

    @DeleteMapping("/products/{guid}")
    public ResponseEntity<Void> get(@PathVariable("guid") final String guid) {
        final var wrapper = new ResponseHolder<Void>();
        final var listeners = new DeleteProductByGuidCommand.Listeners(
                () -> onSuccess(wrapper),
                () -> onEmpty(wrapper));
        command.execute(guid, listeners);
        return wrapper.getResponse();
    }

    private void onSuccess(final ResponseHolder<Void> response) {
        response.setResponse(ResponseEntity.ok().build());
    }

    private void onEmpty(final ResponseHolder<Void> response) {
        response.setResponse(ResponseEntity.noContent().build());
    }

}
