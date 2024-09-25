package br.anderson.infnet.petfriends_almoxarifado.model.domain.infra;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class EventoClienteComprouSerializer extends StdSerializer<EventoClienteComprou> {
    public EventoClienteComprouSerializer() {
        super(EventoClienteComprou.class);
    }

    @Override
    public void serialize(EventoClienteComprou evento, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("idPedido", evento.getIdPedido());
        jgen.writeNumberField("idCliente", evento.getIdCliente());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dtstr = sdf.format(evento.getData()).toString();
        jgen.writeStringField("data", dtstr);
        jgen.writeStringField("obs", evento.getObs());
    }
}
