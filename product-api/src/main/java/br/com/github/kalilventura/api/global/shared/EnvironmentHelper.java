package br.com.github.kalilventura.api.global.shared;

import java.util.Objects;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EnvironmentHelper {

  public static int coalesce(final String environment, final int defaultValue) {
    final var variable = System.getenv(environment);
    return Objects.nonNull(variable) ? Integer.parseInt(variable) : defaultValue;
  }
}
