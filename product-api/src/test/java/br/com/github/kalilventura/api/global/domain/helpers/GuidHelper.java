package br.com.github.kalilventura.api.global.domain.helpers;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public final class GuidHelper {

    public static String getRandomValue() {
        return UUID.randomUUID().toString();
    }
}
