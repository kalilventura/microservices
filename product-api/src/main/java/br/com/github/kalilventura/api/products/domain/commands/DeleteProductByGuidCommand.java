package br.com.github.kalilventura.api.products.domain.commands;

import br.com.github.kalilventura.api.products.domain.services.DeleteProductByGuidService;
import br.com.github.kalilventura.api.products.domain.services.GetProductByGuidService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductByGuidCommand {

    @Getter(AccessLevel.PRIVATE)
    private final DeleteProductByGuidService deleteService;

    @Getter(AccessLevel.PRIVATE)
    private final GetProductByGuidService findService;

    public DeleteProductByGuidCommand(
            final DeleteProductByGuidService deleteProductByGuidService,
            final GetProductByGuidService getProductByGuidService) {
        deleteService = deleteProductByGuidService;
        findService = getProductByGuidService;
    }

    public void execute(final String guid, final Listeners listeners) {
        getFindService().getByGuid(guid)
                .ifPresentOrElse(product -> {
                    getDeleteService().deleteByGuid(guid);
                    listeners.onSuccess().run();
                    }, () -> listeners.onEmpty().run());
    }

    public record Listeners(Runnable onSuccess, Runnable onEmpty) {}
}
