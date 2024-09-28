package br.com.github.kalilventura.api.categories.infrastructure.repositories.models;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
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
@Table(name = "category")
public class JpaCategory {

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Column(nullable = false)
  private String guid;

  @Getter
  @Setter
  @Column(nullable = false)
  private String description;

  @Getter
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private List<JpaProduct> products;

  @Getter
  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Getter @Column private LocalDateTime updatedAt;

  @PrePersist
  public void prePersist() {
    guid = UUID.randomUUID().toString();
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }

  public static JpaCategory toJpa(final Category category) {
    return JpaCategory.builder().description(category.description()).build();
  }

  public Category toDomain() {
    return Category.builder().guid(guid).description(description).build();
  }
}
