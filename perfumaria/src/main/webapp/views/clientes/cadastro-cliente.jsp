<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Clientes</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
}
</style>
</head>
<body>

	<!-- Incluindo o menu de navegação -->
	<jsp:include page="../../includes/menu.jsp" />


	<div class="cadastro">

		<h1>Digite seus dados de Cadastro</h1>


		<c:if test="${not empty erros}">
			<div class="erros" style="color: red;">
				<p>${erros}</p>
			</div>
		</c:if>

		<%
		String nome = "";
		String sobrenome = "";
		String cpf = "";
		String telefone = "";
		String email = "";

		// Obtendo os cookies da requisição
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				switch (cookie.getName()) {
				case "nome":
			nome = cookie.getValue();
			break;
				case "sobrenome":
			sobrenome = cookie.getValue();
			break;
				case "cpf":
			cpf = cookie.getValue();
			break;
				case "telefone":
			telefone = cookie.getValue();
			break;
				case "email":
			email = cookie.getValue();
			break;
				}
			}
		}
		%>

		<br />

		<form action="${pageContext.request.contextPath}/ClienteServlet"
			method="post">
			<input type="hidden" name="appType" value="app1" />

			<div class="cad">
				<label for="nome">Nome: </label> <input type="text" id="nome"
					name="nome" style="display: block;" value="<%=nome%>" /> <br />
			</div>

			<div class="cad">
				<label for="sobrenome">Sobrenome: </label> <input type="text"
					id="sobrenome" name="sobrenome" style="display: block;"
					value="<%=sobrenome%>" /> <br />
			</div>

			<div class="cad">
				<label for="cpf">CPF: </label> <input type="text" id="cpf"
					name="cpf" style="display: block;" value="<%=cpf%>" /> <br />
			</div>

			<div class="cad">
				<label for="telefone">Telefone: </label> <input type="text"
					id="telefone" name="telefone" style="display: block;"
					value="<%=telefone%>" /> <br />
			</div>

			<div class="cad">
				Gênero: <input type="radio" name="sexo" value="Masculino">
				Masculino <input type="radio" name="sexo" value="Feminino">
				Feminino <input type="radio" name="sexo" value="ND"> Prefiro
				não definir <br /> <br />
			</div>

			<div class="cad">
				<label for="email">E-mail: </label> <input type="text" id="email"
					name="email" style="display: block;" value="<%=email%>" />
			</div>

			<br>

			<div class="cad">
				<label for="senha">Senha: </label><br> <input type="password"
					id="senha" name="senha" />
			</div>
			<br>
			<div class="cad">
				<label for="confirmarSenha">Confirme a Senha: </label><br> <input
					type="password" id="confirmarSenha" name="confirmarSenha" />
			</div>

			<div class="cad">
				<input type="submit" value="Confirmar" style="margin-top: 10px;" />
			</div>
		</form>




	</div>

	<!-- Incluindo o menu de navegação -->
	<jsp:include page="../../includes/footer.jsp" />





</body>
</html>