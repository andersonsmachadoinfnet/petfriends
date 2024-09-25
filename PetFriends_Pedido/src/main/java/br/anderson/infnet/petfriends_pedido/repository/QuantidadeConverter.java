package br.anderson.infnet.petfriends_pedido.repository;

import br.anderson.infnet.petfriends_pedido.model.domain.Quantidade;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class QuantidadeConverter implements AttributeConverter<Quantidade, Float> {

    @Override
    public Float convertToDatabaseColumn(Quantidade valorMonetario) {
        return valorMonetario.getQtd();
    }

    @Override
    public Quantidade convertToEntityAttribute(Float quantia) {
        return new Quantidade(quantia);
    }
}
