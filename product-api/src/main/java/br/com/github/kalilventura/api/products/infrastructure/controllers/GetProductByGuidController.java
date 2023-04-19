package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand;
import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand.Listeners;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.mappers.ProductResponseMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class GetProductByGuidController {

    @Getter(AccessLevel.PRIVATE)
    private final GetProductByGuidCommand command;

    private ResponseEntity<ProductResponse> response;

    public GetProductByGuidController(final GetProductByGuidCommand getProductByGuidCommand) {
        command = getProductByGuidCommand;
    }

    @GetMapping("/products/{guid}")
    public ResponseEntity<ProductResponse> get(@PathVariable("guid") final String guid) {
        final var listeners = new Listeners(this::onSuccess, this::onEmpty);
        getCommand().execute(guid, listeners);
        return response;
    }

    private void onSuccess(final Product product) {
        response = ResponseEntity.ok(ProductResponseMapper.INSTANCE.mapToResponse(product));
    }

    private void onEmpty() {
        response = ResponseEntity.noContent().build();
    }
}
