package perfumaria.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import perfumaria.dao.ProdutoDAO;
import perfumaria.model.Produto;

@WebServlet(name="ProdutoController", urlPatterns={"/administrador", "/administrador/novo", "/administrador/cadastro", "/administrador/listar", "/administrador/editar", "/administrador/menu", "/administrador/update", "/administrador/excluir" })
@MultipartConfig
public class ProdutoController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private ProdutoDAO produtoDAO = null;

	public ProdutoController() {
		produtoDAO = new ProdutoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {

		String action = request.getServletPath();

		try {
			switch (action) {

			case "/administrador/novo":
				novo(request, response);
				break;

			case "/administrador/listar":
				listar(request, response);
				break;

			case "/administrador/cadastro":
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/administrador/inserir.jsp");
				dispatcher.forward(request, response);
				break;

			case "/administrador/excluir":
				excluir(request, response);
				break;

			case "/administrador/editar":
				editarForm(request, response);
				break;
				
			case "/administrador/menu":
				menu(request, response);
				break;

			case "/administrador/update":
				update(request, response);
				break;

			default:
				listar(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {

		doGet(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

		ArrayList<Produto> listaProdutos = produtoDAO.listar();

		request.setAttribute("listaProdutos", listaProdutos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/administrador/cadastroprodutos.jsp");
		dispatcher.forward(request, response);
	}

	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {

		String nomeproduto = request.getParameter("nomeproduto");
		double valorproduto = Double.parseDouble(request.getParameter("preco"));
		String marca = request.getParameter("marca");
		String tipo = request.getParameter("tipo");
		int qtd = Integer.parseInt(request.getParameter("quantidade"));
		String descricao = request.getParameter("descricao");
		String imagemBase64 = request.getParameter("imagemBase64");


		Part fotograndeprodPart = request.getPart("fotograndeprod");
		InputStream fotograndeprod = null;

		if (fotograndeprodPart != null) {
			fotograndeprod = fotograndeprodPart.getInputStream();
		}

		Produto produto = new Produto();
		
		produto.setNomeproduto(nomeproduto);
		produto.setDescricao(descricao);
		produto.setValorproduto(valorproduto);
		produto.setMarca(marca);
		produto.setTipo(tipo);
		produto.setQtd(qtd);
		produto.setFotograndeprod(fotograndeprod);

		try {

			produtoDAO.inserir(produto);

			ArrayList<Produto> listaProdutos = produtoDAO.listar();
			request.setAttribute("listaProdutos", listaProdutos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/administrador/cadastroprodutos.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir o produto. " + e.getMessage());
		}
	}

	private void editarForm(HttpServletRequest request, HttpServletResponse response) throws
	SQLException, ServletException, IOException {
		
		int codigoproduto = Integer.parseInt(request.getParameter("codigoproduto"));
		Produto produtoAlterar = produtoDAO.buscarPorId(codigoproduto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/administrador/inserir.jsp");
		request.setAttribute("produto", produtoAlterar);
		dispatcher.forward(request, response);
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws
	SQLException, IOException, ServletException {
		
		int codigoproduto = Integer.parseInt(request.getParameter("codigoproduto"));
		String nomeproduto = request.getParameter("nomeproduto");
		double valorproduto = Double.parseDouble(request.getParameter("preco"));
		String marca = request.getParameter("marca");
		String tipo = request.getParameter("tipo");
		int qtd = Integer.parseInt(request.getParameter("quantidade"));
		String descricao = request.getParameter("descricao");
		String imagemBase64 = request.getParameter("imagemBase64"); // Isso parece estar armazenando em base64 mas não está sendo usado no banco

		// Verificando e processando a imagem
		Part fotograndeprodPart = request.getPart("fotograndeprod");
		InputStream fotograndeprod = null;

		// Se a imagem foi enviada no formulário, pegamos o InputStream dela
		if (fotograndeprodPart != null && fotograndeprodPart.getSize() > 0) {
			fotograndeprod = fotograndeprodPart.getInputStream();
		}
		
		// Criando o objeto Produto com as informações recebidas
		Produto produtoAtualizar = new Produto(nomeproduto, codigoproduto, valorproduto, marca, tipo, qtd, descricao, imagemBase64);
		
		// Setando os valores do produto, incluindo a imagem
		produtoAtualizar.setCodigoproduto(codigoproduto);
		produtoAtualizar.setNomeproduto(nomeproduto);
		produtoAtualizar.setValorproduto(valorproduto);
		produtoAtualizar.setMarca(marca);
		produtoAtualizar.setTipo(tipo);
		produtoAtualizar.setQtd(qtd);
		produtoAtualizar.setDescricao(descricao);
		produtoAtualizar.setFotograndeprod(fotograndeprod); // Aqui é onde você está setando a imagem no objeto

		// Atualizando o produto no banco de dados
		produtoDAO.atualizar(produtoAtualizar);

		// Redirecionando para a lista de produtos
		response.sendRedirect("listar");
	}


	private void excluir(HttpServletRequest request, HttpServletResponse response) throws
	SQLException, IOException {
		
		int codigoproduto = Integer.parseInt(request.getParameter("codigoproduto"));
		produtoDAO.excluir(codigoproduto);
		response.sendRedirect("listar");
	}
	
	private void menu(HttpServletRequest request, HttpServletResponse response) throws
	SQLException, IOException {
		
		response.sendRedirect("/perfumaria/views/administrador/cadastro-administrador.jsp");
	}
}