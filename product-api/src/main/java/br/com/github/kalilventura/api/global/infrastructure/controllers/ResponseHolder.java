package br.com.github.kalilventura.api.global.infrastructure.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

public final class ResponseHolder<T> {

  @Getter @Setter private ResponseEntity<T> response;
}
