package br.anderson.infnet.petfriends_transporte.repository;

import br.anderson.infnet.petfriends_transporte.model.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<Pedido, Integer> {
}
