package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.services.DeleteProductByGuidService;
import br.com.github.kalilventura.api.products.domain.services.GetProductByGuidService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductByGuidCommand {

    private final DeleteProductByGuidService deleteService;
    private final GetProductByGuidService findService;

    public DeleteProductByGuidCommand(
            final DeleteProductByGuidService deleteProductService,
            final GetProductByGuidService getService) {
        deleteService = deleteProductService;
        findService = getService;
    }

    public void execute(final String guid, final Listeners listeners) {
        findService.getByGuid(guid)
                .ifPresentOrElse(product -> {
                    deleteService.deleteByGuid(guid);
                    listeners.onSuccess().run();
                    }, () -> listeners.onEmpty().run());
    }

    public record Listeners(Runnable onSuccess, Runnable onEmpty) {}
}
