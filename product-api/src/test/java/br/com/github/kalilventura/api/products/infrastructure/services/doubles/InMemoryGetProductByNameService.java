package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.GetProductByNameService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InMemoryGetProductByNameService implements GetProductByNameService {

  private final List<Product> items = new ArrayList<>(1);

  public InMemoryGetProductByNameService(final List<Product> products) {
    items.addAll(products);
  }

  @Override
  public Optional<Product> getByName(final String name) {
    return items.stream().filter(product -> product.name().equals(name)).findFirst();
  }
}
