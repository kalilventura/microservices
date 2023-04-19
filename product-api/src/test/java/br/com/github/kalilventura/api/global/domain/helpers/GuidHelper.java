package br.com.github.kalilventura.api.global.domain.helpers;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class GuidHelper {

    public static String getRandomValue() {
        final var faker = new Faker();
        return faker.internet().uuid();
    }
}
