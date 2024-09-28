package br.com.github.kalilventura.api.products.infrastructure.controllers;

import br.com.github.kalilventura.api.global.infrastructure.controllers.ResponseHolder;
import br.com.github.kalilventura.api.products.domain.commands.GetProductsByCategoryCommand;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.controllers.responses.ProductResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.v1.endpoint-prefix}")
public final class GetProductsByCategoryController {

  private final GetProductsByCategoryCommand command;

  public GetProductsByCategoryController(final GetProductsByCategoryCommand getCommand) {
    command = getCommand;
  }

  @GetMapping("/products/category/{guid}")
  public ResponseEntity<List<ProductResponse>> get(
      @PathVariable("guid") final String categoryGuid) {
    final var wrapper = new ResponseHolder<List<ProductResponse>>();
    final var listeners =
        new GetProductsByCategoryCommand.Listeners(
            products -> onSuccess(products, wrapper), () -> onEmpty(wrapper));
    command.execute(categoryGuid, listeners);
    return wrapper.getResponse();
  }

  private void onSuccess(
      final List<Product> products, final ResponseHolder<List<ProductResponse>> response) {
    final var content = products.stream().map(ProductResponse::toResponse).toList();
    response.setResponse(ResponseEntity.ok(content));
  }

  private void onEmpty(final ResponseHolder<List<ProductResponse>> response) {
    response.setResponse(ResponseEntity.noContent().build());
  }
}
