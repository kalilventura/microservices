package br.com.github.kalilventura.api.products.domain.services;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import java.util.List;

public interface GetProductsByCategoryService {

  List<Product> getProductsByCategory(String categoryId);
}
