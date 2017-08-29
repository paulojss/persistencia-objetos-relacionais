package br.com.senai.model;


import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="produto")
@SecondaryTable(name = "fornecedor_produto")
@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq",
		initialValue = 1, allocationSize = 1)

public class Produto {

//====================================
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator = "produto_seq")
	@Column(name = "produto_id")
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private double valor;
	
	@ManyToMany
	@JoinTable(name = "produto_pedido", joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name = "numero"))
	private List<Pedido> pedidos;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Fornecedor> fornecedores;
	
	@Temporal(TemporalType.DATE)
	@Column(table="fornecedor_produto", name="data_fornecimento")
	private Calendar dataFornecimento;
	
	
//==========================================
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedido) {
		this.pedidos = pedido;
	}
	
}
