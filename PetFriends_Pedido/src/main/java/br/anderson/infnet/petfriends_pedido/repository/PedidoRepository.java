package br.anderson.infnet.petfriends_pedido.repository;

import br.anderson.infnet.petfriends_pedido.model.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
