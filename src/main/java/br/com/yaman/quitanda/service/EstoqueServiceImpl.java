package br.com.yaman.quitanda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yaman.quitanda.dao.entity.Estoque;
import br.com.yaman.quitanda.dao.entity.Produto;
import br.com.yaman.quitanda.repository.EstoqueRepository;
import br.com.yaman.quitanda.repository.ProdutoRepository;

@Service
public class EstoqueServiceImpl implements EstoqueService{
	
	@Autowired
    private EstoqueRepository repository;
	
	@Override
	public List<Estoque> findAll() {
		return repository.findAll();
	}

	@Override
	public Estoque save(Estoque t) {
		return repository.save(t);
	}

	@Override
	public Estoque findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Estoque t) {
		repository.delete(t);
	}


}
