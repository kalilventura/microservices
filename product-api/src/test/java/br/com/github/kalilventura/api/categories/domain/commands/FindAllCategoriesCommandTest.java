package br.com.github.kalilventura.api.categories.domain.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import br.com.github.kalilventura.api.categories.domain.builders.CategoryBuilder;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.DummyFindCategoryService;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.InMemoryFindCategoryService;
import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
@NoArgsConstructor
class FindAllCategoriesCommandTest {

  @Test
  @VisibleForTesting
  @DisplayName("should call onSuccess when there are a list of categories")
  void onSuccess() {
    // given
    final var categories = new CategoryBuilder().buildMany(10);
    final var service = new InMemoryFindCategoryService(categories);
    final var command = new FindAllCategoriesCommand(service);

    final var listeners =
        new FindAllCategoriesCommand.Listeners(MockitoHelper.mockConsumer(), null);

    // when
    command.execute(listeners);

    // then
    verify(listeners.onSuccess(), times(1)).accept(categories);
  }

  @Test
  @VisibleForTesting
  @DisplayName("should call onEmpty when there's no category to show")
  void onEmpty() {
    // given
    final var service = new DummyFindCategoryService();
    final var command = new FindAllCategoriesCommand(service);
    final var listeners =
        new FindAllCategoriesCommand.Listeners(null, MockitoHelper.mockRunnable());

    // when
    command.execute(listeners);

    // then
    verify(listeners.onEmpty(), times(1)).run();
  }
}
