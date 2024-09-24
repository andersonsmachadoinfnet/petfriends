package br.anderson.infnet.petfrieds_almoxarifado.controller;

import br.anderson.infnet.petfrieds_almoxarifado.model.domain.Item;
import br.anderson.infnet.petfrieds_almoxarifado.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/almoxarifado")
public class ItemController {
    @Autowired
    private ItemService _sc;

    @GetMapping(value = "")
    public Iterable<Item> getLista() {
        return _sc.obterLista();
    }
}
