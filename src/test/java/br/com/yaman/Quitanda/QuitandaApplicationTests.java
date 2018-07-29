package br.com.yaman.Quitanda;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatcher.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import br.com.yaman.quitanda.controller.ProdutoController;
import br.com.yaman.quitanda.dao.entity.Produto;
import br.com.yaman.quitanda.dao.entity.TipoProduto;
import br.com.yaman.quitanda.service.EstoqueService;
import br.com.yaman.quitanda.service.ProdutoService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProdutoController.class)
public class QuitandaApplicationTests {
	
	private static final String T = null;
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private	ProdutoService produtoService;
	
	@MockBean
	private	EstoqueService estoqueService;
	
	@Before
	public void setup(){}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void findAll() throws Exception {
		TipoProduto tipo = new TipoProduto(1,"FRUTA");
		
		Produto produto = new Produto(1, "UVA", tipo,"UVA",1.2,2.0);
		List<Produto> mockPeople = Arrays.asList(produto);
		
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockPeopleJSON = ow.writeValueAsString(mockPeople);
		
		when(produtoService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/find-all")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockPeopleJSON));
	}
	
	@Test
	public void save() throws Exception {
		TipoProduto tipo = new TipoProduto(1,"FRUTA");
		
		Produto produto = new Produto(1, "MELANCIA", tipo,"MELANCIA",1.2,2.0);
		
		when(produtoService.save((Produto) any(produto))).thenReturn(produto);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockPersonJSON = ow.writeValueAsString(produto);
		
		mock.perform(post("/save")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockPersonJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockPersonJSON));
		verify(produtoService).save((produto));		
	}
	

	

	private Produto any(Produto produto) {
		
		return produto;
	}

	@Test
	public void removePerson() throws Exception {
		mock.perform(delete("/produto" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	

}
