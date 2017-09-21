package edu.lp1.entidade;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Classe que representa um produto no sistema.
 * 
 * @author Andre Pimenta
 *
 */
public class Produto {
	/**
	 * campo que identifica exclusivamente o produto na camada de persistência.
	 */
	private Integer id;
	/**
	 * Código do produto.
	 */
	private String codigo;
	/**
	 * Nome do produto
	 */
	private String nome;
	/**
	 * Preço do produto.
	 */
	private Double preco;

	/**
	 * Construtor do produto.
	 * 
	 * @param codigo
	 * @param nome
	 * @param preco
	 */
	public Produto(String codigo, String nome, Double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale(
				"pt", "br"));
		DecimalFormat formatador = new DecimalFormat("0.00", symbols);
		return "Codigo: " + this.codigo + ", Nome: " + this.nome + ", Preço: "
				+ formatador.format(this.preco);
	}

}
