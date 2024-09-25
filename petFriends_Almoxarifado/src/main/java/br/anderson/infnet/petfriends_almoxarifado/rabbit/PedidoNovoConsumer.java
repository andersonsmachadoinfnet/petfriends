package br.anderson.infnet.petfriends_almoxarifado.rabbit;

import br.anderson.infnet.petfriends_almoxarifado.model.domain.infra.EventoClienteComprou;
import br.anderson.infnet.petfriends_almoxarifado.service.EstoqueService;
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
public class PedidoNovoConsumer {
    private final ObjectMapper objectMapper;
    @Autowired
    private EstoqueService service;
    @RabbitListener(queues = {"pedidonovo-fila"})
    public void receive(@Payload String json) {
        EventoClienteComprou evento = null;
        try {
            evento = objectMapper.readValue(json, EventoClienteComprou.class);
            log.info("EventoClienteComprou: " + evento);
            log.info("                json: " + json);
            service.recebeEbaixaEstoque(evento);
        } catch (JsonProcessingException e) {
            log.info("MsgBad: " + json);
            throw new RuntimeException(e);
        }
    }
}
