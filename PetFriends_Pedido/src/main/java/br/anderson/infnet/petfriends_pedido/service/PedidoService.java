package br.anderson.infnet.petfriends_pedido.service;

import br.anderson.infnet.petfriends_pedido.model.domain.Pedido;
import br.anderson.infnet.petfriends_pedido.model.domain.PedidoItem;
import br.anderson.infnet.petfriends_pedido.repository.PedidoItemRepository;
import br.anderson.infnet.petfriends_pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository _rps;
    @Autowired
    private PedidoItemRepository _pir;
    /*@Autowired
    private PubSubTemplate pubSubTemplate;
    @Autowired
    private JacksonPubSubMessageConverter cvt;*/

    public PedidoService(PedidoRepository rps, PedidoItemRepository pir/*, PubSubTemplate pubSubTemplate, JacksonPubSubMessageConverter cvt*/) {
        _rps = rps;
        _pir = pir;
        //this.pubSubTemplate = pubSubTemplate;
        //this.cvt = cvt;
    }

    public Pedido salvar(Pedido p) {
        p = _rps.save(p);
        for(PedidoItem pi: p.getPedidoItem()){
            pi.setPedidoId(p.getId());
            _pir.save(pi);
        }
        Date date = new Date();
        //EventoClienteComprou eventoClienteComprou = new EventoClienteComprou(p.getId(), p.getIdCliente(), date, "Teste de envio");
        //pubSubTemplate.setMessageConverter(cvt);
        //pubSubTemplate.publish("appPetsFriendsTopic", eventoClienteComprou);
        return p;
    }

    public Optional<Pedido> buscarPorId(Integer id) {
        return _rps.findById(id);
    }

    public void excluir(Integer id) {
        _rps.deleteById(id);
    }

    public Collection<Pedido> buscarTodos() {
        return _rps.findAll();
    }
}
