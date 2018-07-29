package br.com.yaman.quitanda.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.yaman.quitanda.dao.entity.Estoque;

@Repository
@Transactional
public interface EstoqueRepository extends JpaCustomRepository<Estoque>{

}
