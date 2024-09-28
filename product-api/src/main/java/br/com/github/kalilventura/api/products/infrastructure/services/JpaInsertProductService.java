package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.domain.services.InsertProductService;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class JpaInsertProductService implements InsertProductService {

  private final ProductsRepository repository;
  private final CategoriesRepository categoriesRepository;

  public JpaInsertProductService(
      final ProductsRepository productsRepository, final CategoriesRepository categoriesRepo) {
    repository = productsRepository;
    categoriesRepository = categoriesRepo;
  }

  @Override
  @CacheEvict(value = "products", allEntries = true)
  public Product save(final Product product) {
    final var category = categoriesRepository.findByGuid(product.categoryId()).orElseThrow();

    final var jpa = JpaProduct.toJpa(product);
    jpa.setCategory(category);

    final var newEntity = repository.save(jpa);
    return newEntity.toDomain();
  }
}
