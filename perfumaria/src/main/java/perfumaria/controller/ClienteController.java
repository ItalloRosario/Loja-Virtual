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
import java.util.ArrayList;


import perfumaria.dao.ClienteDAO;
import perfumaria.dao.ProdutoDAO;
import perfumaria.model.Cliente;
import perfumaria.model.Produto;

@WebServlet(name="ClienteController", urlPatterns={"/clientes", "/clientes/novo", "/clientes/cadastro", "/clientes/listar", "/clientes/editar",
		"/clientes/update", "/clientes/mostrarProdutoDetalhado", "/clientes/adicionarcarrinho", "/clientes/excluir"})
@MultipartConfig
public class ClienteController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	private ProdutoDAO produtoDAO = null;

	private ClienteDAO clienteDAO = null;

	public ClienteController() {
		clienteDAO = new ClienteDAO();
		produtoDAO = new ProdutoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		
		String action = request.getServletPath();
		
		try {
			switch (action) {

			case "/clientes/novo":
				novo(request, response);
				break;

			case "/clientes/listar":
				listar(request, response);
				break;

			case "/clientes/cadastro":
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clientes/inserircliente.jsp");
				dispatcher.forward(request, response);
				break;

			case "/clientes/excluir":
				excluir(request, response);
				break;

			case "/clientes/editar":
				editarForm(request, response);
				break;
			
			case "/clientes/mostrarProdutoDetalhado":
				mostrarProdutoDetalhado(request, response);
				break;
			
				
			case "/clientes/update":
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

			ArrayList<Cliente> listaClientes = clienteDAO.listar();


			request.setAttribute("listaClientes", listaClientes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clientes/cadastroclientes.jsp");
			dispatcher.forward(request, response);
		}

		private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException,
		IOException {


			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String cpf = request.getParameter("cpf");
			String telefone = request.getParameter("telefone");
			String sexo = request.getParameter("sexo");        
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String confsenha = request.getParameter("confsenha");

			Cliente cliente = new Cliente();


				cliente.setNome(nome);
				cliente.setSobrenome(sobrenome);
				cliente.setCpf(cpf);
				cliente.setTelefone(telefone);
				cliente.setSexo(sexo);
				cliente.setEmail(email);
				cliente.setSenha(senha);
				cliente.setConfsenha(confsenha);

				try {

					clienteDAO.inserir(cliente);

					ArrayList<Cliente> listaClientes = clienteDAO.listar();
					request.setAttribute("listaClientes", listaClientes);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clientes/cadastroclientes.jsp");
					dispatcher.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir o produto. " + e.getMessage());
				}
			}
		

		private void editarForm(HttpServletRequest request, HttpServletResponse response) throws
		SQLException, ServletException, IOException {

			int codigocliente = Integer.parseInt(request.getParameter("codigocliente"));
			Cliente clienteAlterar = clienteDAO.buscarPorId(codigocliente);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clientes/inserircliente.jsp");
			request.setAttribute("cliente", clienteAlterar);
			dispatcher.forward(request, response);
		}
		
		private void update(HttpServletRequest request, HttpServletResponse response) throws
		SQLException, IOException, ServletException {
			
			int codigocliente = Integer.parseInt(request.getParameter("codigocliente"));
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String cpf = request.getParameter("cpf");
			String telefone = request.getParameter("telefone");
			String sexo = request.getParameter("sexo");        
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String confsenha = request.getParameter("confsenha");
			
			Cliente clienteAtualizar = new Cliente( codigocliente , nome,  sobrenome,  cpf,  telefone,  sexo,  email,  senha,  confsenha);
			
			clienteAtualizar.setCodigocliente(codigocliente);
			clienteAtualizar.setNome(nome);
			clienteAtualizar.setSobrenome(sobrenome);
			clienteAtualizar.setCpf(cpf);
			clienteAtualizar.setTelefone(telefone);
			clienteAtualizar.setSexo(sexo);
			clienteAtualizar.setEmail(email);
			clienteAtualizar.setSenha(senha);
			clienteAtualizar.setConfsenha(confsenha);
			
			clienteDAO.atualizar(clienteAtualizar);
			response.sendRedirect("listar");
		}
		
		private void mostrarProdutoDetalhado(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		    int produtoId = Integer.parseInt(request.getParameter("id"));
		    
		    // Recuperando o produto do banco de dados
		    Produto produto = produtoDAO.buscarPorId(produtoId);

		    // Passando o produto para a JSP
		    request.setAttribute("produto", produto);
		    
		    // Redirecionando para a página de detalhes do produto
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clientes/pagina-produto.jsp");
		    dispatcher.forward(request, response);
		}
		
	
		
		private void excluir(HttpServletRequest request, HttpServletResponse response) throws
		SQLException, IOException {
			
			int codigocliente = Integer.parseInt(request.getParameter("codigocliente"));
			clienteDAO.excluir(codigocliente);
			response.sendRedirect("listar");
		}
		
		
		
	}
