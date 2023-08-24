package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.products.domain.commands.GetProductsByCategoryCommand;
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

import java.util.List;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public class GetProductsByCategoryController {

    @Getter(AccessLevel.PRIVATE)
    private final GetProductsByCategoryCommand command;

    private ResponseEntity<List<ProductResponse>> response;

    public GetProductsByCategoryController(final GetProductsByCategoryCommand getProductsByCategoryCommand) {
        command = getProductsByCategoryCommand;
    }

    @GetMapping("/products/category/{guid}")
    public ResponseEntity<List<ProductResponse>> get(@PathVariable("guid") final String categoryGuid) {
        final var listeners = new GetProductsByCategoryCommand.Listeners(this::onSuccess, this::onEmpty);
        getCommand().execute(categoryGuid, listeners);
        return response;
    }

    private void onSuccess(final List<Product> products) {
        response = ResponseEntity.ok(products.stream().map(ProductResponseMapper.INSTANCE::mapToResponse).toList());
    }

    private void onEmpty() {
        response = ResponseEntity.noContent().build();
    }
}
