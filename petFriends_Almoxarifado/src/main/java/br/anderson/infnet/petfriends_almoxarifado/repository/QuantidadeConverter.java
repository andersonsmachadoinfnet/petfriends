package br.anderson.infnet.petfriends_almoxarifado.repository;

import br.anderson.infnet.petfriends_almoxarifado.model.domain.Quantidade;
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
