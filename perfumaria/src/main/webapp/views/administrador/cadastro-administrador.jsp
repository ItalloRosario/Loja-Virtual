<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">

<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
	background-color: white;
	h1 {
    text-align: center;
    margin: 20px 0;
    color: #333;
}

</style>
</head>
<body>

<jsp:include page="${pageContext.request.contextPath}../../includes/menuadm.jsp" />

<div class="admdiv">
<a href="${pageContext.request.contextPath}/views/administrador/relatorioresumido.jsp">Relatorio Resumido</a>
<br>
<a href="${pageContext.request.contextPath}/views/administrador/relatoriodetalhado.jsp">Relatorio Detalhado</a>
<br>
<a href="${pageContext.request.contextPath}/administrador/listar">Cadastro Produtos</a>
<br>
<a href="${pageContext.request.contextPath}/clientes/listar">Cadastro Clientes</a>
<br>
<a href="${pageContext.request.contextPath}/LogoutClienteServlet">Logout</a>
</div>

</body>
</html>