package br.com.github.kalilventura.api.products.domain.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import java.util.Optional;

public interface GetProductByGuidService {

  Optional<Product> getByGuid(String guid);
}
