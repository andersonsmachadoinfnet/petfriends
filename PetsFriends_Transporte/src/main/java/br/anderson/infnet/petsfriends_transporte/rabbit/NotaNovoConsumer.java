package br.anderson.infnet.petsfriends_transporte.rabbit;

import br.anderson.infnet.petsfriends_transporte.model.infra.EventoNotaDisponibilizada;
import br.anderson.infnet.petsfriends_transporte.service.TransporteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class NotaNovoConsumer {
    private final ObjectMapper objectMapper;
    @Autowired
    private TransporteService service;
    @RabbitListener(queues = {"notanovo-fila"})
    public void receive(@Payload String json) {
        EventoNotaDisponibilizada evento = null;
        try {
            evento = objectMapper.readValue(json, EventoNotaDisponibilizada.class);
            log.info("EventoNotaDisponibilizada: " + evento);
            log.info("                json: " + json);
            service.notaEntregue(evento);
        } catch (JsonProcessingException e) {
            log.info("MsgBad: " + json);
            throw new RuntimeException(e);
        }
    }
}
