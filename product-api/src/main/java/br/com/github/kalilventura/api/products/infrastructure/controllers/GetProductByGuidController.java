package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand;
import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand.Listeners;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.mappers.ProductResponseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class GetProductByGuidController {

    private final GetProductByGuidCommand command;

    public GetProductByGuidController(final GetProductByGuidCommand getByGuidCommand) {
        command = getByGuidCommand;
    }

    @GetMapping("/products/{guid}")
    public ResponseEntity<ProductResponse> get(@PathVariable("guid") final String guid) {
        final var wrapper = new ResponseHolder<ProductResponse>();
        final var listeners = new Listeners(product -> onSuccess(product, wrapper), () -> onEmpty(wrapper));
        command.execute(guid, listeners);
        return wrapper.getResponse();
    }

    private void onSuccess(final Product product, final ResponseHolder<ProductResponse> response) {
        response.setResponse(ResponseEntity.ok(ProductResponse.toResponse(product)));
    }

    private void onEmpty(final ResponseHolder<ProductResponse> response) {
        response.setResponse(ResponseEntity.noContent().build());
    }
}
