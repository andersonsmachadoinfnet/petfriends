package br.anderson.infnet.petfrieds_almoxarifado.service;

import br.anderson.infnet.petfrieds_almoxarifado.model.domain.Estoque;
import br.anderson.infnet.petfrieds_almoxarifado.model.domain.Item;
import br.anderson.infnet.petfrieds_almoxarifado.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ItemService {
    ItemRepository _rps;

    public ItemService(ItemRepository rps) {
        _rps = rps;
    }

    private void _populaDados() {
        if (_rps.count()==0) {
            // Nomes criados na plataforma 4Devs
            // link: https://www.4devs.com.br/gerador_de_pessoas
            // aleatorios
            _rps.save(new Item("Escova de pelos", new Estoque(10f)));
            _rps.save(new Item("Pasta dente pets",new Estoque(20f)));
        }
    }

    public Item incluir(Item item) {
        item.setId(null);
        return _rps.save(item);
    }

    public Optional<Item> ler(Integer key) {
        return _rps.findById(key);
    }

    public void excluir(Integer key) {
        _rps.deleteById(key);
    }

    public Collection<Item> obterLista(){
        _populaDados();
        return (Collection<Item>) _rps.findAll();
    }

    public Item salvar(Item item) {
        return _rps.save(item);
    }
}
