package br.com.github.kalilventura.api.products.infrastructure.listeners.messages;

import br.com.github.kalilventura.api.products.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductStockMessage(
        @JsonProperty("saleId") String saleId,
        @JsonProperty("transactionId") String transactionId,
        @JsonProperty("products") List<ProductQuantity> products) {

        public Product toDomain() {
            return null;
        }
}
