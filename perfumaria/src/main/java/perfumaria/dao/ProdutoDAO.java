package perfumaria.dao;

import java.sql.Connection;
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

public class ProdutoDAO {
	
	Connection conexao;

    public ArrayList<Produto> listar() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";  
        
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)){

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nomeproduto = rs.getString("nomeproduto");
                int codigoproduto = rs.getInt("codigoproduto");
                String descricao = rs.getString("descricao");
                double valorproduto = rs.getDouble("valorproduto");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");
                int qtd = rs.getInt("qtd");

                Blob blob = rs.getBlob("fotograndeprod");  
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
                
                
                Produto produto = new Produto(nomeproduto, codigoproduto, valorproduto, marca, tipo, qtd, descricao);
                produto.setImagemBase64(imagemBase64);

                produtos.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
    
    

    
    public boolean inserir(Produto produto) {
    	
    	boolean retorno = false;
    	

        try {
            conexao = ConnectionFactory.getConnection();
            String sql = "INSERT INTO produtos (nomeproduto, codigoproduto, descricao, valorproduto, marca, tipo, qtd, fotograndeprod) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, produto.getNomeproduto());
            ps.setInt(2, produto.getCodigoproduto());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getValorproduto()); 
            ps.setString(5, produto.getMarca());
            ps.setString(6, produto.getTipo());
            ps.setInt(7, produto.getQtd());  
            ps.setBlob(8, produto.getFotograndeprod());  

            
            int linhasAfetadas = ps.executeUpdate();
			if(linhasAfetadas >0) { retorno = true; }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return retorno;
		}

	}
    
    public Produto buscarPorId(int id) {
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
                
             // Recuperando a imagem do banco de dados (campo BLOB)
                Blob blob = rs.getBlob("fotograndeprod");  
                String imagemBase64 = null;
                
                if (blob != null) {
                    InputStream foto = blob.getBinaryStream();
                    byte[] buffer = new byte[(int) blob.length()];

                    try {
                        foto.read(buffer);  // Lê os bytes da imagem
                    } catch (IOException e) {
                        e.printStackTrace();  
                    }

                    // Convertendo os bytes para Base64
                    imagemBase64 = Base64.getEncoder().encodeToString(buffer); 
                }
                
                objRetorno = new Produto();
                
                objRetorno.setNomeproduto(nomeproduto);
                objRetorno.setCodigoproduto(codigoproduto);
                objRetorno.setValorproduto(valorproduto);
                objRetorno.setMarca(marca);
                objRetorno.setTipo(tipo);
                objRetorno.setQtd(qtd);
                objRetorno.setDescricao(descricao);
                objRetorno.setImagemBase64(imagemBase64);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objRetorno;
    }
    
    public boolean atualizar(Produto produtoAtualizar) {
		boolean retorno = false;

		try {
			conexao = ConnectionFactory.getConnection();
			
			
			String sql = "UPDATE produtos SET nomeproduto=?, descricao=?, valorproduto=?, marca=?, tipo=?, qtd=?, fotograndeprod=? WHERE codigoproduto = ?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, produtoAtualizar.getNomeproduto());
            ps.setString(2, produtoAtualizar.getDescricao());
            ps.setDouble(3, produtoAtualizar.getValorproduto()); 
            ps.setString(4, produtoAtualizar.getMarca());
            ps.setString(5, produtoAtualizar.getTipo());
            ps.setInt(6, produtoAtualizar.getQtd());  
            ps.setBlob(7, produtoAtualizar.getFotograndeprod());
            ps.setInt(8, produtoAtualizar.getCodigoproduto());

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
			String sql = "DELETE FROM produtos WHERE codigoproduto = ?";

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