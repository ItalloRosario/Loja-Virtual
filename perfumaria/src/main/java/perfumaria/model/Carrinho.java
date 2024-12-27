package perfumaria.model;

import java.io.InputStream;
import java.sql.Date;

public class Carrinho {
	
	private int codigocarrinho;
	private String nomeprodutocarrinho;
	private int quantidadecarrinho;
	private double valortotalproduto;
	private InputStream fotocarrinho;
	private String imagemBase64;
	private Date datacarrinho;
	private int codigocliente;
	private int codigoproduto;
	
	
	public Carrinho() {
	}
	
	

	public Carrinho(int codigocarrinho, String nomeprodutocarrinho, int quantidadecarrinho, double valortotalproduto, Date datacarrinho) {
		super();
		this.codigocarrinho = codigocarrinho;
		this.nomeprodutocarrinho = nomeprodutocarrinho;
		this.quantidadecarrinho = quantidadecarrinho;
		this.valortotalproduto = valortotalproduto;
		this.datacarrinho = datacarrinho;
	}



	public int getCodigocarrinho() {
		return codigocarrinho;
	}

	public void setCodigocarrinho(int codigocarrinho) {
		this.codigocarrinho = codigocarrinho;
	}

	public String getNomeprodutocarrinho() {
		return nomeprodutocarrinho;
	}

	public void setNomeprodutocarrinho(String nomeprodutocarrinho) {
		this.nomeprodutocarrinho = nomeprodutocarrinho;
	}

	public int getQuantidadecarrinho() {
		return quantidadecarrinho;
	}

	public void setQuantidadecarrinho(int quantidadecarrinho) {
		this.quantidadecarrinho = quantidadecarrinho;
	}

	public double getValortotalproduto() {
		return valortotalproduto;
	}

	public void setValortotalproduto(double valortotalproduto) {
		this.valortotalproduto = valortotalproduto;
	}

	public InputStream getFotocarrinho() {
		return fotocarrinho;
	}

	public void setFotocarrinho(InputStream fotocarrinho) {
		this.fotocarrinho = fotocarrinho;
	}

	public String getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(String imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}



	public Date getDatacarrinho() {
		return datacarrinho;
	}



	public void setDatacarrinho(Date datacarrinho) {
		this.datacarrinho = datacarrinho;
	}



	public int getCodigocliente() {
		return codigocliente;
	}



	public void setCodigocliente(int codigocliente) {
		this.codigocliente = codigocliente;
	}



	public int getCodigoproduto() {
		return codigoproduto;
	}



	public void setCodigoproduto(int codigoproduto) {
		this.codigoproduto = codigoproduto;
	}
	
	

}
