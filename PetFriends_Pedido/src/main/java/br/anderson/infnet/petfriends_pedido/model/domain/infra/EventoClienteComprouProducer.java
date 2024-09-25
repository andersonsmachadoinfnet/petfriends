package br.anderson.infnet.petfriends_pedido.model.domain.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoClienteComprouProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void send(EventoClienteComprou evt) throws JsonProcessingException {
        amqpTemplate.convertAndSend("pedidonovo-exc", "pedidonovo-rk", objectMapper.writeValueAsString(evt));
    }
}
