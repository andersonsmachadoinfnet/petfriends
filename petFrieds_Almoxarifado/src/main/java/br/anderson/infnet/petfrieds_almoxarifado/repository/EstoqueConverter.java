package br.anderson.infnet.petfrieds_almoxarifado.repository;

import br.anderson.infnet.petfrieds_almoxarifado.model.domain.Estoque;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstoqueConverter implements AttributeConverter<Estoque, Float> {

    @Override
    public Float convertToDatabaseColumn(Estoque estoque) {
        return estoque.getQtd();
    }

    @Override
    public Estoque convertToEntityAttribute(Float qtd) {
        return new Estoque(qtd);
    }
}
