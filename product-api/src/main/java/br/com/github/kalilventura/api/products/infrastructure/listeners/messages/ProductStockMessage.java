package br.com.github.kalilventura.api.products.infrastructure.listeners.messages;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import br.com.github.kalilventura.api.products.infrastructure.listeners.mappers.ProductStockMessageMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductStockMessage(
        @JsonProperty("saleId") String saleId,
        @JsonProperty("transactionId") String transactionId,
        @JsonProperty("products") List<ProductQuantity> products) {
        public Product buildToDomain() {
                return ProductStockMessageMapper.INSTANCE.mapToEntity(this);
        }
}
