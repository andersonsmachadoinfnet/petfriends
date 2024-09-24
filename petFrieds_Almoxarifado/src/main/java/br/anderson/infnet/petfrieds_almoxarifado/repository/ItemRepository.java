package br.anderson.infnet.petfrieds_almoxarifado.repository;

import br.anderson.infnet.petfrieds_almoxarifado.model.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
