package br.com.github.kalilventura.api.products.domain.commands.doubles;

import br.com.github.kalilventura.api.products.domain.commands.DeleteProductByGuidCommand;
import br.com.github.kalilventura.api.products.domain.commands.DeleteProductByGuidCommand.Listeners;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyDeleteProductByGuidService;
import br.com.github.kalilventura.api.products.infrastructure.services.doubles.DummyGetProductByGuidService;

public class DeleteProductByGuidCommandStub extends DeleteProductByGuidCommand {
    
    public DeleteProductByGuidCommandStub() {
        super(new DummyDeleteProductByGuidService(), new DummyGetProductByGuidService());
    }


    @Override
    public void execute(final String guid, final Listeners listeners) {

    }
}
