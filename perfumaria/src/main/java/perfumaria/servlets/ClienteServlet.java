package perfumaria.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import perfumaria.dao.ClienteDAO;
import perfumaria.model.Cliente;
import java.io.IOException;

public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ClienteServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder erros = new StringBuilder();

		String appType = request.getParameter("appType");

		Cliente cliente = new Cliente();

		if ("app1".equals(appType)) {
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String cpf = request.getParameter("cpf");
			String telefone = request.getParameter("telefone");
			String sexo = request.getParameter("sexo");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String confirmarSenha = request.getParameter("confirmarSenha");

			if (nome == null || nome.isEmpty()) {
				erros.append("Nome é obrigatório.<br>");
			}

			if (sobrenome == null || sobrenome.isEmpty()) {
				erros.append("Sobrenome é obrigatório.<br>");
			}

			if (cpf == null || cpf.isEmpty()) {
				erros.append("CPF é obrigatório.<br>");
			}

			if (telefone == null || telefone.isEmpty()) {
				erros.append("Telefone é obrigatório.<br>");
			}

			if (sexo == null || sexo.isEmpty()) {
				erros.append("Gênero é obrigatório.<br>");
			}

			if (email == null || email.isEmpty()) {
				erros.append("E-mail é obrigatório.<br>");
			}

			if (senha == null || senha.isEmpty()) {
				erros.append("Senha é obrigatória.<br>");
			}

			if (confirmarSenha == null || confirmarSenha.isEmpty()) {
				erros.append("Confirmação de Senha é obrigatória.<br>");
			}

			if (!senha.equals(confirmarSenha)) {
				erros.append("As senhas não coincidem.<br>");
			}
			
			ClienteDAO clienteDAO = new ClienteDAO();
			
			if (clienteDAO.isCpfCadastrado(cpf)) {
	            erros.append("Este CPF já está cadastrado.<br>");
	        }

	        if (clienteDAO.isEmailCadastrado(email)) {
	            erros.append("Este e-mail já está cadastrado.<br>");
	        }

			if (erros.length() > 0) {
				response.addCookie(new Cookie("nome", nome != null ? nome : ""));
				response.addCookie(new Cookie("sobrenome", sobrenome != null ? sobrenome : ""));
				response.addCookie(new Cookie("cpf", cpf != null ? cpf : ""));
				response.addCookie(new Cookie("telefone", telefone != null ? telefone : ""));
				response.addCookie(new Cookie("email", email != null ? email : ""));

				request.setAttribute("erros", erros.toString());
				request.getRequestDispatcher("/views/clientes/cadastro-cliente.jsp").forward(request, response);

				request.setAttribute("erros", erros.toString());
				request.getRequestDispatcher("/includes/menu.jsp").forward(request, response);

				return;
			}

			if (erros.length() == 0) {
				cliente.setNome(nome);
				cliente.setSobrenome(sobrenome);
				cliente.setCpf(cpf);
				cliente.setTelefone(telefone);
				cliente.setSexo(sexo);
				cliente.setEmail(email);
				cliente.setSenha(senha);
				cliente.setConfsenha(confirmarSenha);

				response.addCookie(new Cookie("nome", nome != null ? nome : ""));
				response.addCookie(new Cookie("sobrenome", sobrenome != null ? sobrenome : ""));
				response.addCookie(new Cookie("cpf", cpf != null ? cpf : ""));
				response.addCookie(new Cookie("telefone", telefone != null ? telefone : ""));
				response.addCookie(new Cookie("email", email != null ? email : ""));

				HttpSession sessao = request.getSession();

				clienteDAO.inserir(cliente);

				sessao.setAttribute("cliente", cliente);
				request.getRequestDispatcher("/views/clientes/vizualiza-cliente.jsp").forward(request, response);
			}

		} else if ("app2".equals(appType)) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			if (email == null || email.isEmpty()) {
				erros.append("E-mail é obrigatório.<br>");
			}

			if (senha == null || senha.isEmpty()) {
				erros.append("Senha é obrigatória.<br>");
			}

			if (erros.length() > 0) {
				request.setAttribute("erros", erros.toString());
				request.getRequestDispatcher("/views/clientes/Login-cliente.jsp").forward(request, response);

				return; 
			}

			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente clienteAutenticado = clienteDAO.autenticar(email, senha);

			if ("1234".equals(email) && "1234".equals(senha)) {
				cliente.setEmail(email);
				cliente.setSenha(senha);

				request.setAttribute("cliente", cliente);
				request.getRequestDispatcher("/views/administrador/cadastro-administrador.jsp").forward(request, response);

			} 

			if (clienteAutenticado != null) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("cliente", clienteAutenticado);

				request.getRequestDispatcher("/views/clientes/vizualiza-cliente.jsp").forward(request, response);

			} else {
				erros.append("Login inválido.<br>");
				request.setAttribute("erros", erros.toString());
				request.getRequestDispatcher("/views/clientes/Login-cliente.jsp").forward(request, response);
			}   
		}
	}
}