package br.anderson.infnet.petsfriends_transporte.repository;

import br.anderson.infnet.petsfriends_transporte.model.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
}
