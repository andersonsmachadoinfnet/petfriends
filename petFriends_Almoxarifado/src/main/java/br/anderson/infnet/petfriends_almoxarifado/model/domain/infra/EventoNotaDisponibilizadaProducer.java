package br.anderson.infnet.petfriends_almoxarifado.model.domain.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoNotaDisponibilizadaProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void send(EventoNotaDisponibilizada evt) throws JsonProcessingException {
        amqpTemplate.convertAndSend("notanovo-exc", "notanovo-rk", objectMapper.writeValueAsString(evt));
    }
}
