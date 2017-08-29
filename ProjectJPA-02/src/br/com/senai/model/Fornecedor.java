package br.com.senai.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
@SequenceGenerator(name = "fornecedor_seq", sequenceName = "fornecedor_seq",
		initialValue = 1, allocationSize = 1)
public class Fornecedor {
//=======================================
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator = "fornecedor_seq")
	@Column(name = "fornecedor_id")
	private long codigo;
	
	@Column
	private String nome;
	
	@Column
	private long cnpj;
	
	@ManyToMany
	@JoinTable(name = "fornecedor_produto", joinColumns = @JoinColumn(name = "fornecedor_id"),
			inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos;
	
//========================================
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
