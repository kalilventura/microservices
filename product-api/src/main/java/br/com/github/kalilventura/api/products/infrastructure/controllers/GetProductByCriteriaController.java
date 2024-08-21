package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand;
import br.com.github.kalilventura.api.products.domain.commands.GetProductByGuidCommand.Listeners;
import br.com.github.kalilventura.api.products.domain.commands.GetProductByNameCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Consumer;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class GetProductByCriteriaController {

    private final GetProductByGuidCommand getByGuidCommand;
    private final GetProductByNameCommand getByNameCommand;

    public GetProductByCriteriaController(
        final GetProductByGuidCommand getByGuidCommand,
        final GetProductByNameCommand getByNameCommand) {
        this.getByGuidCommand = getByGuidCommand;
        this.getByNameCommand = getByNameCommand;
    }

    @GetMapping("/products")
    public ResponseEntity<ProductResponse> get(
        @RequestParam(required = false, name = "guid") String guid,
        @RequestParam(required = false, name = "name") String name) {
        final var wrapper = new ResponseHolder<ProductResponse>();
        if (guid != null) {
            final var listeners = new Listeners(onSuccess(wrapper), onEmpty(wrapper));
            getByGuidCommand.execute(guid, listeners);
        }
        if (name != null) {
            final var listeners = new GetProductByNameCommand.Listeners(onSuccess(wrapper), onEmpty(wrapper));
            getByNameCommand.execute(name, listeners);
        }
        return wrapper.getResponse();
    }

    private Consumer<Product> onSuccess(final ResponseHolder<ProductResponse> response) {
        return product -> response.setResponse(ResponseEntity.ok(ProductResponse.toResponse(product)));
    }

    private Runnable onEmpty(final ResponseHolder<ProductResponse> response) {
        return () -> response.setResponse(ResponseEntity.noContent().build());
    }
}
