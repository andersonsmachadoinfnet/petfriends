package br.anderson.infnet.petfriends_almoxarifado.repository;

import br.anderson.infnet.petfriends_almoxarifado.model.domain.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
}
