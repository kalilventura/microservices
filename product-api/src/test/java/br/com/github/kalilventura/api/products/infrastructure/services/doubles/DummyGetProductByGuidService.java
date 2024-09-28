package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByGuidService;
import java.util.Optional;

public class DummyGetProductByGuidService implements GetProductByGuidService {

  @Override
  public Optional<Product> getByGuid(String guid) {
    return Optional.empty();
  }
}
