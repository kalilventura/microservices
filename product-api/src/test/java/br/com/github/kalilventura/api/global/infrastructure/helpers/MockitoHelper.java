package br.com.github.kalilventura.api.global.infrastructure.helpers;

import java.util.List;
import java.util.function.Consumer;
import lombok.experimental.UtilityClass;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@UtilityClass
@SuppressWarnings("unchecked")
public final class MockitoHelper {

  public static Runnable mockRunnable() {
    return Mockito.mock(Runnable.class);
  }

  public static <T> Consumer<T> mockConsumer() {
    final var clazz = (Class<Consumer<T>>) (Object) Consumer.class;
    return Mockito.mock(clazz);
  }

  public static <T> ArgumentCaptor<List<T>> captorForList(final Class<T> ignored) {
    final var clazz = (Class<List<T>>) (Object) List.class;
    return ArgumentCaptor.forClass(clazz);
  }

  public static <T> ArgumentCaptor<T> captorForClass(final Class<T> ignored) {
    final var clazz = (Class<T>) Object.class;
    return ArgumentCaptor.forClass(clazz);
  }
}
