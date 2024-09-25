package br.anderson.infnet.petfriends_almoxarifado.repository;

import br.anderson.infnet.petfriends_almoxarifado.model.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}
