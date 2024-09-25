package br.anderson.infnet.petfriends_pedido.repository;

import br.anderson.infnet.petfriends_pedido.model.domain.ValorMonetario;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.math.BigDecimal;

@Converter(autoApply = true)
public class ValorMonetarioConverter implements AttributeConverter<ValorMonetario, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(ValorMonetario valorMonetario) {
        return valorMonetario.getQuantia();
    }

    @Override
    public ValorMonetario convertToEntityAttribute(BigDecimal quantia) {
        return new ValorMonetario(quantia);
    }
}
