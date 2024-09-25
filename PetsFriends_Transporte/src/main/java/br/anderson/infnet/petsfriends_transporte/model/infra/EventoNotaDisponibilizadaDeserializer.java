package br.anderson.infnet.petsfriends_transporte.model.infra;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventoNotaDisponibilizadaDeserializer extends StdDeserializer<EventoNotaDisponibilizada> {
    public EventoNotaDisponibilizadaDeserializer() {
        super(EventoNotaDisponibilizada.class);
    }

    @Override
    public EventoNotaDisponibilizada deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        EventoNotaDisponibilizada evento = null;
        JsonNode node = jp.getCodec().readTree(jp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //try {
        evento = new EventoNotaDisponibilizada(
                node.get("idPedido").asInt(),
                node.get("idCliente").asInt(),
                new Date() /*sdf.parse(node.get("data").asText())*/,
                node.get("endereco").asText()
        );
        //} catch (ParseException e) {
        //    throw new IOException("Erro na data");
        //}
        return evento;
    }
}
