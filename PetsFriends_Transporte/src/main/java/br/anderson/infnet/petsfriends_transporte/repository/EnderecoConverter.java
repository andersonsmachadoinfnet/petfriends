package br.anderson.infnet.petsfriends_transporte.repository;

import br.anderson.infnet.petsfriends_transporte.model.domain.Endereco;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class EnderecoConverter  implements AttributeConverter<Endereco, String> {

    @Override
    public String convertToDatabaseColumn(Endereco end) {
        return end.getLogradouro()+"|"+
               end.getNumero()+"|"+
               end.getComplemento()+"|"+
               end.getBairro()+"|"+
               end.getCidade()+"|"+
               end.getEstado();
    }

    @Override
    public Endereco convertToEntityAttribute(String csv) {
        String[] l = csv.split("\\|");
        return new Endereco(l[0],l[1],l[2],l[3],l[4],l[5]);
    }
}
