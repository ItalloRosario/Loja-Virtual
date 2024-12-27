<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="perfumaria.model.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados do cliente</title>
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
	
	<h1>Dados do Cliente</h1>
	<%
        Cliente cliente = (Cliente) session.getAttribute("cliente"); // Obtém o cliente da sessão
        if (cliente != null) {
    %>
	<p>Nome: ${cliente.nome}</p>
	<p>Sobrenome: ${cliente.sobrenome}</p>
	<p>CPF: ${cliente.cpf}</p>
	<p>Telefone: ${cliente.telefone}</p>
	Gênero: ${cliente.sexo}
	<br />
	<c:choose>
		<c:when test="${cliente.sexo == 'Masculino'}">
			<p>Cliente: ${cliente.nome} cadastrado com sucesso!.</p>
		</c:when>
		<c:when test="${cliente.sexo == 'Feminino'}">
			<p>Cliente: ${cliente.nome} cadastrada com sucesso!.</p>
		</c:when>
		<c:otherwise>
			<p>Cliente: ${cliente.nome} cadastrad(o)a com sucesso!.</p>
		</c:otherwise>
	</c:choose>
	<br />
	<%
	} else {
	%>
	<h1>Nenhum dado de cliente disponível.</h1>
	<%
	}
	%>

	<a href="${pageContext.request.contextPath}/LogoutClienteServlet">Logout</a>


	<!-- Incluindo o footer de navegação -->
	<jsp:include page="../../includes/footer.jsp" />
</body>
</html>