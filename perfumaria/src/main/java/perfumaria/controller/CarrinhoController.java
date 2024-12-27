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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import perfumaria.dao.CarrinhoDAO;
import perfumaria.dao.ClienteDAO;
import perfumaria.dao.ProdutoDAO;
import perfumaria.model.Carrinho;
import perfumaria.model.Cliente;
import perfumaria.model.Produto;


@WebServlet(name="/CarrinhoController", urlPatterns= {"/carrinho", "/carrinho/novo", "/carrinho/listar"})
@MultipartConfig
public class CarrinhoController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private ProdutoDAO produtoDAO = null;

	private ClienteDAO clienteDAO = null;
	
	private CarrinhoDAO carrinhoDAO = null;

	public CarrinhoController() {
		clienteDAO = new ClienteDAO();
		carrinhoDAO = new CarrinhoDAO();
		produtoDAO = new ProdutoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {

		String action = request.getServletPath();

		try {
			switch (action) {

			case "/carrinho/novo":
				novo(request, response);
				break;

			case "/carrinho/listar":
				listar(request, response);
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


		ArrayList<Carrinho> listaCarrinho = carrinhoDAO.listarcarrinho();

		request.setAttribute("listaCarrinho", listaCarrinho);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/carrinho/carrinho.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nomeprodutocarrinho = request.getParameter("nomeproduto");
	    double valortotalproduto = Double.parseDouble(request.getParameter("valortotal"));
	    int quantidadecarrinho = Integer.parseInt(request.getParameter("quantidade_prod_id"));
	    int codigoproduto = Integer.parseInt(request.getParameter("id"));
	    // Captura da imagem
	    Part fotocarrinhoPart = request.getPart("imagem");
	    InputStream imagem = null;
	    
	    if (fotocarrinhoPart != null) {
	        imagem = fotocarrinhoPart.getInputStream();
	    }

	    // Criando o carrinho
	    Carrinho carrinho = new Carrinho();
	    carrinho.setNomeprodutocarrinho(nomeprodutocarrinho);
	    carrinho.setValortotalproduto(valortotalproduto);
	    carrinho.setQuantidadecarrinho(quantidadecarrinho);
	    carrinho.setFotocarrinho(imagem);
	    carrinho.setCodigoproduto(codigoproduto);

	    // Definindo a data de compra como a data atual
	    Calendar calendar = Calendar.getInstance();
	    Date dataCompra = new Date(calendar.getTimeInMillis());
	    carrinho.setDatacarrinho(dataCompra);

	    try {
	        carrinhoDAO.inserir(carrinho);

	        ArrayList<Produto> listaProdutos = produtoDAO.listar();
	        request.setAttribute("listaProdutos", listaProdutos);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/carrinho/carrinho.jsp");
	        dispatcher.forward(request, response);

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir o produto. " + e.getMessage());
	    }
	}

}
