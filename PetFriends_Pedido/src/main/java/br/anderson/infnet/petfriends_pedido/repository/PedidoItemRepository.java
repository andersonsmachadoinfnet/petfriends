package br.anderson.infnet.petfriends_pedido.repository;

import br.anderson.infnet.petfriends_pedido.model.domain.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
}
