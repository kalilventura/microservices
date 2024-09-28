package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByGuidService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InMemoryGetProductByGuidService implements GetProductByGuidService {

  private final List<Product> items = new ArrayList<>(1);

  public InMemoryGetProductByGuidService(final List<Product> products) {
    items.addAll(products);
  }

  @Override
  public Optional<Product> getByGuid(final String guid) {
    return items.stream().filter(product -> product.guid().equals(guid)).findFirst();
  }
}
