package br.com.github.kalilventura.api.products.domain.builders;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductBuilder {

  private String guid = GuidHelper.getRandomValue();
  private String category = GuidHelper.getRandomValue();
  private String productName = "";

  public ProductBuilder withGuid(final String productGuid) {
    guid = productGuid;
    return this;
  }

  public ProductBuilder withName(final String name) {
    productName = name;
    return this;
  }

  public ProductBuilder withCategory(final String value) {
    category = value;
    return this;
  }

  public Product buildDefault() {
    return Product.builder()
        .guid(guid)
        .name(productName)
        .quantity(10L)
        .categoryId(category)
        .build();
  }

  public List<Product> buildMany(final int quantity) {
    final var products = new ArrayList<Product>(1);
    for (int index = 0; index <= quantity; index++) {
      products.add(buildDefault());
    }
    return products;
  }
}
