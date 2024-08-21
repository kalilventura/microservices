package br.com.github.kalilventura.api.products.infrastructure.listeners.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductQuantity(
        @JsonProperty("guid") String id,
        @JsonProperty("quantity") Integer quantity) {}
