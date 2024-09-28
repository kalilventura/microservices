package br.com.github.kalilventura.api.global.domain.helpers;

import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class GuidHelper {

  public static String getRandomValue() {
    return UUID.randomUUID().toString();
  }
}
