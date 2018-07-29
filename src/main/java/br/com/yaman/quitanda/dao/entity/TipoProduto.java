package br.com.yaman.quitanda.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoProduto {

    @Id
    @Column(name = "COD_TIPO_PRODUTO")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoProduto(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public TipoProduto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
