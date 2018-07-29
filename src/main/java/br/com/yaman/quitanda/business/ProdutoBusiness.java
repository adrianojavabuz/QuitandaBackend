package br.com.yaman.quitanda.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.yaman.quitanda.dao.entity.Estoque;
import br.com.yaman.quitanda.dao.entity.Produto;
import br.com.yaman.quitanda.service.EstoqueService;
import br.com.yaman.quitanda.service.ProdutoService;

@Component
public class ProdutoBusiness implements GenericCrudBusiness<Produto> {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private EstoqueService estoqueservice;
	
	@Override
	public List<Produto> findAll() {
		return service.findAll();
	}

	@Override
	public Produto save(Produto t) {
		Estoque estoque = new Estoque();
		estoque.setProduto(t);
		estoque.setQuantidadeTotal(estoque.getQuantidadeDisponivel() + 1);
		if(estoqueservice.save(estoque)!=null){
			estoqueservice.save(estoque);
		}
		
		return t;
	}

	@Override
	public Produto findOne(Integer id) {
		return service.findOne(id);
	}

	@Override
	public void delete(Produto t) {
		
		Estoque estoque = new Estoque();
		estoque.setProduto(t);
		estoque.setQuantidadeTotal(estoque.getQuantidadeDisponivel() - 1);
		service.delete(t);
		estoqueservice.delete(estoque);
		
		
	}


}
