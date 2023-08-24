package br.com.github.kalilventura.api.products.infrastructure.services;

import br.com.github.kalilventura.api.global.domain.helpers.GuidHelper;
import br.com.github.kalilventura.api.products.infrastructure.repositories.contracts.ProductsRepository;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Tag("unit")
@NoArgsConstructor
class JpaDeleteProductByGuidServiceTest {

    @Test
    @VisibleForTesting
    @DisplayName("should delete a product by the guid successfully")
    void deleteByGuidSuccessfully() {
        // given
        final var guid = GuidHelper.getRandomValue();
        final var repository = Mockito.mock(ProductsRepository.class);
        final var service = new JpaDeleteProductByGuidService(repository);

        // when
        service.deleteByGuid(guid);

        // then
        verify(repository, times(1)).deleteByGuid(guid);
    }
}