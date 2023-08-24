package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.commands.GetProductByNameCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.mappers.ProductResponseMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public class GetProductByNameController {

    @Getter(AccessLevel.PRIVATE)
    private final GetProductByNameCommand command;

    private ResponseEntity<ProductResponse> response;

    public GetProductByNameController(final GetProductByNameCommand productByNameCommand) {
        command = productByNameCommand;
    }

    @GetMapping("/products/{name}")
    public ResponseEntity<ProductResponse> get(@PathVariable("name") final String name) {
        final var listeners = new GetProductByNameCommand.Listeners(this::onSuccess, this::onEmpty);
        getCommand().execute(name, listeners);
        return response;
    }

    private void onSuccess(final Product product) {
        response = ResponseEntity.ok(ProductResponseMapper.INSTANCE.mapToResponse(product));
    }

    private void onEmpty() {
        response = ResponseEntity.notFound().build();
    }
}
