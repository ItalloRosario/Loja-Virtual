package perfumaria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;

import perfumaria.model.Carrinho;
import perfumaria.model.Produto;
import perfumaria.utils.ConnectionFactory;


public class CarrinhoDAO {

	Connection conexao;

	public ArrayList<Carrinho> listarcarrinho() {
		ArrayList<Carrinho> carrinhos = new ArrayList<>();
		String sql = "SELECT * FROM carrinhos";  

		try (Connection conexao = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conexao.prepareStatement(sql)){

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int codigocarrinho = rs.getInt("codigocarrinho");
				String nomeprodutocarrinho = rs.getString("nomeprodutocarrinho");
				int quantidadecarrinho = rs.getInt("quantidadecarrinho");
				double valortotalproduto = rs.getDouble("valortotalproduto");
				Date datacarrinho = rs.getDate("datacarrinho");

				Blob blob = rs.getBlob("fotocarrinho");  
				String imagemBase64 = null;

				if (blob != null) {
					InputStream foto = blob.getBinaryStream();
					byte[] buffer = new byte[(int) blob.length()];

					try {
						foto.read(buffer); 
					} catch (IOException e) {
						e.printStackTrace();  
					}

					imagemBase64 = Base64.getEncoder().encodeToString(buffer); 
				}


				Carrinho carrinho = new Carrinho(codigocarrinho, nomeprodutocarrinho, quantidadecarrinho, valortotalproduto, datacarrinho);
				carrinho.setImagemBase64(imagemBase64);

				carrinhos.add(carrinho);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carrinhos;
	}

	public boolean inserir(Carrinho carrinho) {

		boolean retorno = false;


		try {
			conexao = ConnectionFactory.getConnection();
			String sql = "INSERT INTO carrinhos (nomeprodutocarrinho, quantidadecarrinho, valortotalproduto, fotocarrinho, datacarrinho, codigoproduto) "
		             + "VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = conexao.prepareStatement(sql);
		// Remova a linha abaixo, pois o codigocarrinho é auto-incrementado
		// ps.setInt(1, carrinho.getCodigocarrinho());

		ps.setString(1, carrinho.getNomeprodutocarrinho());
		ps.setInt(2, carrinho.getQuantidadecarrinho());
		ps.setDouble(3, carrinho.getValortotalproduto());
		ps.setBlob(4, carrinho.getFotocarrinho());
		ps.setDate(5, new java.sql.Date(carrinho.getDatacarrinho().getTime()));
		ps.setInt(6, carrinho.getCodigoproduto());

			int linhasAfetadas = ps.executeUpdate();
			if(linhasAfetadas >0) { retorno = true; }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return retorno;
		}

	}
	

	public boolean atualizar(Carrinho CarrinhoAtualizar) {
		boolean retorno = false;

		try {
			conexao = ConnectionFactory.getConnection();


			String sql = "UPDATE carrinhos SET nomeprodutocarrinho=?, quantidadecarrinho=?, valortotalproduto=?, fotocarrinho=?, datacarrinho=? WHERE codigocarrinho = ?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, CarrinhoAtualizar.getNomeprodutocarrinho());
			ps.setInt(2, CarrinhoAtualizar.getQuantidadecarrinho());
			ps.setDouble(3, CarrinhoAtualizar.getValortotalproduto());  
			ps.setBlob(4, CarrinhoAtualizar.getFotocarrinho());
			ps.setDate(4, CarrinhoAtualizar.getDatacarrinho());
			ps.setInt(5, CarrinhoAtualizar.getCodigocarrinho());

			int linhasAfetadas = ps.executeUpdate();

			if(linhasAfetadas >0) {retorno = true;}

		} catch (SQLException e) {
			e.printStackTrace();
		}  finally { //código omitido}
			return retorno;
		}

	}


	public boolean excluir(int codigoproduto) {
		boolean retorno = false;

		try {

			conexao = ConnectionFactory.getConnection();
			String sql = "DELETE FROM carrinhos WHERE codigoproduto = ?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, codigoproduto);
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

}
