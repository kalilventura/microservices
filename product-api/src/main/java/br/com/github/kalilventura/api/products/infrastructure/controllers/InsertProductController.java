package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
import br.com.github.kalilventura.api.products.domain.commands.InsertProductCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.ProductRequest;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class InsertProductController {

    private final InsertProductCommand command;

    public InsertProductController(final InsertProductCommand insertCommand) {
        command = insertCommand;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> post(@RequestBody final ProductRequest request) {
        final var wrapper = new ResponseHolder<ProductResponse>();
        final var listeners = new InsertProductCommand.Listeners(
                product -> onSuccess(product, wrapper),
                product -> onExists(product, wrapper));
        command.execute(request.toDomain(), listeners);
        return wrapper.getResponse();
    }

    private void onSuccess(final Product product, final ResponseHolder<ProductResponse> response) {
        response.setResponse(new ResponseEntity<>(ProductResponse.toResponse(product), HttpStatus.CREATED));
    }

    private void onExists(final Product product, final ResponseHolder<ProductResponse> response) {
        response.setResponse(ResponseEntity.ok().body(ProductResponse.toResponse(product)));
    }
}
