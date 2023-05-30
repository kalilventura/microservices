package br.com.github.kalilventura.api.categories.domain.commands;

import br.com.github.kalilventura.api.categories.domain.builders.CategoryBuilder;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.InMemoryFindCategoryService;
import br.com.github.kalilventura.api.categories.infrastructure.services.doubles.InMemoryInsertCategoryService;
import br.com.github.kalilventura.api.global.infrastructure.helpers.MockitoHelper;
import br.com.github.kalilventura.api.products.domain.builders.ProductBuilder;
import br.com.github.kalilventura.api.products.domain.commands.InsertProductCommand;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryGetProductByNameService;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.InMemoryInsertProductService;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Tag("unit")
@NoArgsConstructor
class InsertCategoryCommandTest {

    @Test
    @VisibleForTesting
    @DisplayName("should call onSuccess when add a new category successfully")
    void shouldCallOnSuccess() {
        // given
        final var description = "food";
        final var category = new CategoryBuilder().withDescription(description).buildDefault();

        final var insertService = new InMemoryInsertCategoryService();
        final var getService = new InMemoryFindCategoryService();
        final var command = new InsertCategoryCommand(insertService, getService);

        // when
        final var listeners = new InsertCategoryCommand.Listeners(MockitoHelper.mockConsumer(), null);
        command.execute(category, listeners);

        // then
        verify(listeners.onCreated(), times(1)).accept(category);
    }

    @Test
    @VisibleForTesting
    @DisplayName("should call onExists when there's a category with the same description")
    void shouldCallOnExists() {
        // given
        final var description = "food";
        final var category = new CategoryBuilder().withDescription(description).buildDefault();

        final var insertService = new InMemoryInsertCategoryService();
        final var getService = new InMemoryFindCategoryService(List.of(category));
        final var command = new InsertCategoryCommand(insertService, getService);

        // when
        final var listeners = new InsertCategoryCommand.Listeners(null, MockitoHelper.mockRunnable());
        command.execute(category, listeners);

        // then
        verify(listeners.onExists(), times(1)).run();
    }
}