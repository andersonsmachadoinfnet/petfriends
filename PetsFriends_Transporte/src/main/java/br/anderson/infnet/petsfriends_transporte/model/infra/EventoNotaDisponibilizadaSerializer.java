package br.anderson.infnet.petsfriends_transporte.model.infra;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class EventoNotaDisponibilizadaSerializer extends StdSerializer<EventoNotaDisponibilizada> {
    public EventoNotaDisponibilizadaSerializer() {
        super(EventoNotaDisponibilizada.class);
    }

    @Override
    public void serialize(EventoNotaDisponibilizada evento, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("idPedido", evento.getIdPedido());
        jgen.writeNumberField("idCliente", evento.getIdCliente());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dtstr = sdf.format(evento.getData()).toString();
        jgen.writeStringField("data", dtstr);
        jgen.writeStringField("endereco", evento.getEndereco());
    }
}
