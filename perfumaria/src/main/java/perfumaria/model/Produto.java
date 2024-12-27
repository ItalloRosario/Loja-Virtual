package perfumaria.model;

import java.io.InputStream;

public class Produto {

	private int codigoproduto;
	private String nomeproduto;
	private double valorproduto;
	private String marca;
	private String tipo;
	private int qtd; // Alterado de String para int para representar a quantidade corretamente
	private String descricao;
	private InputStream fotograndeprod; // Representando o arquivo de imagem como InputStream
	private String imagemBase64;

	// Construtor padrão
	public Produto() {
	}

	// Construtor com parâmetros
	public Produto(String nomeproduto, int codigoproduto, double valorproduto, String marca, String tipo, int qtd, String descricao) {
		this.nomeproduto = nomeproduto;
		this.codigoproduto = codigoproduto;
		this.valorproduto = valorproduto;
		this.marca = marca;
		this.tipo = tipo;
		this.qtd = qtd;
		this.descricao = descricao;
	}
	
	public Produto(String nomeproduto, int codigoproduto, double valorproduto, String marca, String tipo, int qtd, String descricao, String imagemBase64) {
		this.nomeproduto = nomeproduto;
		this.codigoproduto = codigoproduto;
		this.valorproduto = valorproduto;
		this.marca = marca;
		this.tipo = tipo;
		this.qtd = qtd;
		this.descricao = descricao;
		this.imagemBase64 = imagemBase64;
	}

	// Getters e setters
	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public int getCodigoproduto() {
		return codigoproduto;
	}

	public void setCodigoproduto(int codigoproduto) {
		this.codigoproduto = codigoproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorproduto() {
		return valorproduto;
	}

	public void setValorproduto(double valorproduto) {
		this.valorproduto = valorproduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQtd() { // Alterado para int
		return qtd;
	}

	public void setQtd(int qtd) { // Alterado para int
		this.qtd = qtd;
	}

	public InputStream getFotograndeprod() {
		return fotograndeprod;
	}

	public void setFotograndeprod(InputStream fotograndeprod) {
		this.fotograndeprod = fotograndeprod;
	}

	public String getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(String imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}

	
	
	
}