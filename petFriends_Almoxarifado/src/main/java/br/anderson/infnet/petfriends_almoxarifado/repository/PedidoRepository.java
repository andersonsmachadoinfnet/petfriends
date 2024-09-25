package br.anderson.infnet.petfriends_almoxarifado.repository;

import br.anderson.infnet.petfriends_almoxarifado.model.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
