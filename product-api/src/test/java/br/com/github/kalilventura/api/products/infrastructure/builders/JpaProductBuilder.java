package br.com.github.kalilventura.api.products.infrastructure.builders;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.infrastructure.repositories.models.JpaProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpaProductBuilder {

    private JpaCategory category;
    private String guid = GuidHelper.getRandomValue();
    private String name = "";

    public JpaProductBuilder withCategory(final JpaCategory jpaCategory) {
        category = jpaCategory;
        return this;
    }

    public JpaProductBuilder withGuid(final String productGuid) {
        guid = productGuid;
        return this;
    }

    public JpaProductBuilder withName(final String productName) {
        name = productName;
        return this;
    }

    public JpaProduct buildDefault() {
        final var builder = JpaProduct
                .builder()
                .guid(guid)
                .name(name)
                .quantity(10L);

        if (Objects.nonNull(category)) {
            builder.category(category);
        }

        return builder.build();
    }

    public List<JpaProduct> buildMany(final int quantity) {
        final var products = new ArrayList<JpaProduct>(1);
        for (int index = 0; index <= quantity; index++) {
            products.add(buildDefault());
        }
        return products;
    }
}
