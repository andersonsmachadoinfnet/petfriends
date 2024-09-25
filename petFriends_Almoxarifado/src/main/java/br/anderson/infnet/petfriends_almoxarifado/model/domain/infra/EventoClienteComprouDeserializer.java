package br.anderson.infnet.petfriends_almoxarifado.model.domain.infra;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventoClienteComprouDeserializer extends StdDeserializer<EventoClienteComprou> {
    public EventoClienteComprouDeserializer() {
        super(EventoClienteComprou.class);
    }

    @Override
    public EventoClienteComprou deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        EventoClienteComprou evento = null;
        JsonNode node = jp.getCodec().readTree(jp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //try {
        evento = new EventoClienteComprou(
                node.get("idPedido").asInt(),
                node.get("idCliente").asInt(),
                new Date() /*sdf.parse(node.get("data").asText())*/,
                node.get("obs").asText()
        );
        //} catch (ParseException e) {
        //    throw new IOException("Erro na data");
        //}
        return evento;
    }
}
