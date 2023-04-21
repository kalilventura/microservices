package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.commands.InsertProductCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.ProductRequest;
import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.mappers.ProductRequestMapper;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.mappers.ProductResponseMapper;
import lombok.AccessLevel;
import lombok.Getter;
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
public class InsertProductController {

    @Getter(AccessLevel.PRIVATE)
    private final InsertProductCommand command;

    private ResponseEntity<ProductResponse> response;

    public InsertProductController(
            final InsertProductCommand insertProductCommand) {
        command = insertProductCommand;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> post(@RequestBody final ProductRequest request) {
        final var listeners = new InsertProductCommand.Listeners(this::onSuccess, this::onError);
        getCommand().execute(ProductRequestMapper.INSTANCE.mapToEntity(request), listeners);
        return response;
    }

    private void onSuccess(final Product product) {
        response = new ResponseEntity<>(ProductResponseMapper.INSTANCE.mapToResponse(product), HttpStatus.CREATED);
    }

    private void onError(final Product product) {
        response = ResponseEntity
                .badRequest()
                .body(ProductResponseMapper.INSTANCE.mapToResponse(product));
    }
}
