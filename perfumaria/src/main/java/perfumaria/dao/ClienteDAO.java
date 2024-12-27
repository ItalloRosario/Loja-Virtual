package perfumaria.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import perfumaria.model.Cliente;
import perfumaria.model.Produto;
import perfumaria.utils.ConnectionFactory;

public class ClienteDAO {

	Connection conexao;

	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes";  

		try (Connection conexao = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conexao.prepareStatement(sql)){

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int codigocliente = rs.getInt("codigocliente");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String sexo = rs.getString("sexo");        
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String confsenha = rs.getString("confsenha");


				Cliente cliente = new Cliente( codigocliente, nome,  sobrenome,  cpf,  telefone,  sexo,  email,  senha,  confsenha);

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	public boolean isCpfCadastrado(String cpf) {
		String sql = "SELECT COUNT(*) FROM clientes WHERE cpf = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0; // Retorna true se o CPF já estiver cadastrado
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Caso não haja erro e o CPF não esteja cadastrado
	}

	public boolean isEmailCadastrado(String email) {
		String sql = "SELECT COUNT(*) FROM clientes WHERE email = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0; // Retorna true se o email já estiver cadastrado
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Caso não haja erro e o email não esteja cadastrado
	}


	public boolean inserir(Cliente cliente) {
		boolean retorno = false;

		try {

			conexao = ConnectionFactory.getConnection();

			String sql = "INSERT INTO clientes(codigocliente, nome, sobrenome, cpf, telefone, sexo, email, senha, confsenha) " 
						+ "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setInt(1, cliente.getCodigocliente());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getSobrenome());
			ps.setString(4, cliente.getCpf());
			ps.setString(5, cliente.getTelefone());
			ps.setString(6, cliente.getSexo());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getSenha());
			ps.setString(9, cliente.getConfsenha());

			int linhasAfetadas = ps.executeUpdate();
			if(linhasAfetadas >0) { retorno = true; }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return retorno;
		}

	}
	
	public Cliente buscarPorId(int id) {
        Cliente objRetorno = null;
        String sql = "SELECT * FROM clientes WHERE codigocliente= ?";

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int codigocliente = rs.getInt("codigocliente");
            	String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String sexo = rs.getString("sexo");        
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String confsenha = rs.getString("confsenha");

                objRetorno = new Cliente();
                
                objRetorno.setCodigocliente(codigocliente);
                objRetorno.setNome(nome);
                objRetorno.setSobrenome(sobrenome);
                objRetorno.setCpf(cpf);
                objRetorno.setTelefone(telefone);
                objRetorno.setSexo(sexo);
                objRetorno.setEmail(email);
                objRetorno.setSenha(senha);
                objRetorno.setConfsenha(confsenha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objRetorno;
    }

	public boolean atualizar(Cliente clienteAtualizar) {
		boolean retorno = false;

		try {
			conexao = ConnectionFactory.getConnection();
			
			
			String sql = "UPDATE clientes SET nome=?, sobrenome=?, cpf=?, telefone=?, sexo=?, email=?, senha=?, confsenha=? WHERE codigocliente= ?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, clienteAtualizar.getNome());
            ps.setString(2, clienteAtualizar.getSobrenome());
            ps.setString(3, clienteAtualizar.getCpf()); 
            ps.setString(4, clienteAtualizar.getTelefone());
            ps.setString(5, clienteAtualizar.getSexo());
            ps.setString(6, clienteAtualizar.getEmail());  
            ps.setString(7, clienteAtualizar.getSenha());
            ps.setString(8, clienteAtualizar.getConfsenha());
            ps.setInt(9, clienteAtualizar.getCodigocliente());

			int linhasAfetadas = ps.executeUpdate();
			
			if(linhasAfetadas >0) {retorno = true;}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally { //código omitido}
			return retorno;
		}

    }
	
	public boolean excluir(int codigocliente) {
		boolean retorno = false;

		try {

			conexao = ConnectionFactory.getConnection();
			String sql = "DELETE FROM clientes WHERE codigocliente = ?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, codigocliente);
			int linhasAfetadas = ps.executeUpdate();

			if(linhasAfetadas >0) {retorno = true;}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (conexao != null) {
				try {
					conexao.close();
				} catch (SQLException e) {e.printStackTrace();}
			}
		}
		return retorno;        
    }
	
	public Produto buscarPorIddetalhes(int id) {
        Produto objRetorno = null;
        String sql = "SELECT * FROM produtos WHERE codigoproduto= ?";

        System.out.println("Buscando produto com codigoproduto: " + id);

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int codigoproduto = rs.getInt("codigoproduto");
                String nomeproduto = rs.getString("nomeproduto");
                double valorproduto = rs.getDouble("valorproduto");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");
                int qtd = rs.getInt("qtd");
                String descricao = rs.getString("descricao");

                objRetorno = new Produto();
                
                objRetorno.setNomeproduto(nomeproduto);
                objRetorno.setCodigoproduto(codigoproduto);
                objRetorno.setValorproduto(valorproduto);
                objRetorno.setMarca(marca);
                objRetorno.setTipo(tipo);
                objRetorno.setQtd(qtd);
                objRetorno.setDescricao(descricao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objRetorno;
    }

	public Cliente autenticar(String email, String senha) {
		Cliente cliente = null;
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionFactory.getConnection();

			// SQL para verificar as credenciais do cliente
			String sql = "SELECT * FROM clientes WHERE email = ? AND senha = ?";

			// Preparar o statement
			ps = conexao.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);

			// Executa a consulta
			rs = ps.executeQuery();

			// Verifica se encontrou algum registro
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setConfsenha(rs.getString("confsenha"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conexao != null) conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cliente;
	}



}
