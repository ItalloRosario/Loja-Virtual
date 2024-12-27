<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login de Clientes</title>
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

		<h1>Digite seus dados de Login</h1>
		
		<c:if test="${not empty erros}">
		<div class="erros" style="color: red;">
			<p>${erros}</p>
		</div>
	</c:if>
<br>

		<form action="${pageContext.request.contextPath}/ClienteServlet"
			method="post">
			<input type="hidden" name="appType" value="app2" />

			<div class="cad">

				<div class="cad">
					<label for="email">E-mail: </label> <input type="text" id="email"
						name="email" style="display: block;" />
				</div>
				<br>
				<div class="cad">
					<label for="senha">Senha: </label><br> <input type="password"
						id="senha" name="senha" />
				</div>

				<div class="bt">
					<input type="submit" value="Confirmar" style="margin-top: 10px;" />
				</div>
		</form>


		<h3>Não possui login? Cadastre-se</h3>
		<br>
		<div class="cadastrar">
			<a
				href="${pageContext.request.contextPath}/views/clientes/cadastro-cliente.jsp">Cadastrar-se</a>
		</div>

	</div>

	<!-- Incluindo o menu de navegação -->
	<jsp:include page="../../includes/footer.jsp" />





</body>
</html>