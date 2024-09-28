package br.com.github.kalilventura.api.products.infrastructure.builders;

import br.com.github.kalilventura.api.products.infrastructure.controllers.requests.ProductRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductRequestBuilder {

  public ProductRequest buildDefault() {
    return new ProductRequest("", 0L, "", 0F);
  }
}
