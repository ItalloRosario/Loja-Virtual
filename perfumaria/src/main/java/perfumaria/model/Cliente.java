package perfumaria.model;

import java.io.Serializable;

public class Cliente {
	
	private int codigocliente;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String telefone;
	private String sexo;
	private String email;
	private String senha;
	private String confsenha;
	
	public Cliente() {
	}
	
	public Cliente(int codigocliente, String nome, String sobrenome, String cpf, String telefone, String sexo, String email, String senha, String confsenha) {
		this.codigocliente = codigocliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
		this.confsenha = confsenha;
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfsenha() {
		return confsenha;
	}

	public void setConfsenha(String confsenha) {
		this.confsenha = confsenha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getCodigocliente() {
		return codigocliente;
	}

	public void setCodigocliente(int codigocliente) {
		this.codigocliente = codigocliente;
	}
	
	

}
