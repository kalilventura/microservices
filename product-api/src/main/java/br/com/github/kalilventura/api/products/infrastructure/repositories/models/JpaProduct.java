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
import java.util.UUID;

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
        guid = UUID.randomUUID().toString();
        createdAt = LocalDateTime.now();
    }

    public static JpaProduct toJpa(final Product product) {
        return JpaProduct
            .builder()
            .guid(product.guid())
            .name(product.name())
            .quantity(product.quantity())
            .build();
    }

    public Product toDomain() {
        return Product
            .builder()
            .guid(guid)
            .name(name)
            .quantity(quantity)
            .categoryId(category.getGuid())
            .build();
    }
}
