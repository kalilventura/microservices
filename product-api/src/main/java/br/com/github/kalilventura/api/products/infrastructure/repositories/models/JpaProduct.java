package br.com.github.kalilventura.api.products.infrastructure.repositories.models;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.services.mappers.ProductMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private JpaCategory category;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static JpaProduct toJpa(final Product product) {
        return ProductMapper.INSTANCE.mapToJpa(product);
    }

    public Product toDomain() {
        return ProductMapper.INSTANCE.mapToEntity(this);
    }
}
