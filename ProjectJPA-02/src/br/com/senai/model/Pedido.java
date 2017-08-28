package br.com.senai.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
@SecondaryTable(name = "produto_pedido")
@SequenceGenerator(name="pedido_seq", sequenceName="pedido_seq",
		initialValue = 1, allocationSize = 1)
public class Pedido {
	
//*******************************************************************
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator = "pedido_seq")
	private long numero;
	
	@Column
	private Date data;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToMany(mappedBy = "pedidos")
	private List<Produto> produtos;
	
	@Column(table = "produto_pedido", name = "qtde_pedido")
	private int qtde;
	
//*****************************************************************************
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	
}
