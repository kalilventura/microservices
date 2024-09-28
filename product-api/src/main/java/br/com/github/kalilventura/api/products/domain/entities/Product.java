package br.com.github.kalilventura.api.products.domain.entities;

import java.io.Serializable;
import lombok.Builder;

@Builder
public record Product(String guid, String name, Long quantity, String categoryId, Float price)
    implements Serializable {}
