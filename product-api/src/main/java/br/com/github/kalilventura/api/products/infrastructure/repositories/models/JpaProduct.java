package br.com.github.kalilventura.api.products.infrastructure.repositories.models;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class JpaProduct {

  @Id
  @Setter
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Column(nullable = false)
  private String guid;

  @Getter
  @Setter
  @Column(nullable = false)
  private String name;

  @Getter
  @Setter
  @Column(nullable = false)
  private Long quantity;

  @Getter
  @Setter
  @Column(nullable = false)
  private Float price;

  @Getter
  @Setter
  @JoinColumn(name = "category_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private JpaCategory category;

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  public void prePersist() {
    guid = UUID.randomUUID().toString();
    createdAt = LocalDateTime.now();
  }

  public static JpaProduct toJpa(final Product product) {
    return JpaProduct.builder()
        .guid(product.guid())
        .name(product.name())
        .quantity(product.quantity())
        .price(product.price())
        .build();
  }

  public Product toDomain() {
    return Product.builder()
        .guid(guid)
        .name(name)
        .quantity(quantity)
        .categoryId(category.getGuid())
        .build();
  }
}
