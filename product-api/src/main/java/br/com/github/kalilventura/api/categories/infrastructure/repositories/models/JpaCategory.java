package br.com.github.kalilventura.api.categories.infrastructure.repositories.models;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.infrastructure.services.mappers.CategoryMapper;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class JpaCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String guid;

    @Getter
    @Setter
    @Column(nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<JpaProduct> products;

    @Getter
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Getter
    @Column
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public static JpaCategory toJpa(final Category category) {
        return CategoryMapper.INSTANCE.mapToJpa(category);
    }

    public Category toDomain() {
        return CategoryMapper.INSTANCE.mapToEntity(this);
    }
}
