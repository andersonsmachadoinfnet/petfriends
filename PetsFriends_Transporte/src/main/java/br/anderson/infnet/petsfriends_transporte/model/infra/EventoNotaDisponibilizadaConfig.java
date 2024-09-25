package br.anderson.infnet.petsfriends_transporte.model.infra;

import br.anderson.infnet.petsfriends_transporte.service.TransporteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import com.google.cloud.spring.pubsub.support.converter.ConvertedBasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;

@Configuration
public class EventoNotaDisponibilizadaConfig {
    @Autowired
    private TransporteService service;

    @Bean
    public JacksonPubSubMessageConverter jacksonPubSubMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(EventoNotaDisponibilizada.class, new EventoNotaDisponibilizadaSerializer());
        simpleModule.addDeserializer(EventoNotaDisponibilizada.class, new EventoNotaDisponibilizadaDeserializer());
        return new JacksonPubSubMessageConverter(objectMapper);
    }

    @Bean
    public MessageChannel inputMessageChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public PubSubInboundChannelAdapter inboundChannelAdapter(
            @Qualifier("inputMessageChannel") MessageChannel messageChannel, PubSubTemplate pubSubTemplate) {

        pubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter());
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "appPetsFriendsTopic-sub");
        adapter.setOutputChannel(messageChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(EventoNotaDisponibilizada.class);
        return adapter;
    }

    @ServiceActivator(inputChannel = "inputMessageChannel")
    public void messageReceiver(EventoNotaDisponibilizada payload,
                                @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) ConvertedBasicAcknowledgeablePubsubMessage<EventoNotaDisponibilizada> message) {

        service.notaEntregue(payload);
        message.ack();
    }
}
