package br.com.github.kalilventura.api.products.infrastructure.services.doubles;

import br.com.github.kalilventura.api.products.domain.services.DeleteProductByGuidService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DummyDeleteProductByGuidService implements DeleteProductByGuidService {

    @Override
    public void deleteByGuid(final String guid) {

    }
}
