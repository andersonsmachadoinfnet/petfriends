package br.anderson.infnet.petfriends_almoxarifado.service;

import br.anderson.infnet.petfriends_almoxarifado.model.domain.Estoque;
import br.anderson.infnet.petfriends_almoxarifado.model.domain.infra.EventoClienteComprou;
import br.anderson.infnet.petfriends_almoxarifado.model.domain.infra.EventoNotaDisponibilizada;
import br.anderson.infnet.petfriends_almoxarifado.model.domain.infra.EventoNotaDisponibilizadaProducer;
import br.anderson.infnet.petfriends_almoxarifado.repository.EstoqueRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository _rps;
    @Autowired
    private EventoNotaDisponibilizadaProducer _producer;

    public EstoqueService(EstoqueRepository rps, EventoNotaDisponibilizadaProducer _producer) {
        _rps = rps;
        _producer = _producer;
    }

    public Estoque salvar(Estoque estoque) {
        return _rps.save(estoque);
    }

    public Optional<Estoque> buscarPorId(Integer id) {
        return _rps.findById(id);
    }

    public void excluir(Integer id) {
        _rps.deleteById(id);
    }

    public Collection<Estoque> buscarTodos() {
        return _rps.findAll();
    }

    public boolean recebeEbaixaEstoque(EventoClienteComprou payload) {
        Date date = new Date();
        EventoNotaDisponibilizada evento = new EventoNotaDisponibilizada(payload.getIdPedido(), payload.getIdCliente(), date, "Rua xxx,90,centro");
        try {
            _producer.send(evento);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
