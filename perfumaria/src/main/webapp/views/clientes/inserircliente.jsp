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
	text-decoration: none;
}
a {
text-decoration: none;
color: #000000;
}
</style>
</head>
<body>

<jsp:include page="../../includes/menuadm.jsp" />
	
	<div style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
	<header>
			<a href=""><img class="ml-5 mt-5" src="" alt=""></a>
			<p
				style="font-weight: 500; font-family: cursive; font-size: 20px; color: #000000;"
				class="ml-5 mb-4">Painel Administrativo Inserir</p>

		</header>

	<a href="cadastroclientes.jsp">VOLTAR PARA A LISTA</a>

	<form action="${cliente == null ? 'novo' : 'update'}" method="post"
			enctype="multipart/form-data" id="form_inserir"
			style="color: #000000f3; font-weight: 600; font-family: cursive; font-size: 19px;">

			<input type="hidden" name="codigocliente"
				value="${cliente.getCodigocliente()}">

			<div class="ml-5" style="margin: 0">
				Nome do cliente: <input name="nome" type="text"
					required="required" size="100" value="${cliente.getNome()}"><br>
				<br>
			</div>

			<div class="ml-5" style="margin: 0">
				Sobrenome do cliente: <input name="sobrenome" type="text"
					required="required" size="100" value="${cliente.getSobrenome()}"><br>
				<br>
			</div>

			<div class="ml-5">
				CPF: <input name="cpf" type="text" size="11"
					required="required" value="${cliente.getCpf()}"><br>
				<br>
			</div>

			<div class="ml-5">
				Telefone: <input name="telefone" type="text" size="100"
					value="${cliente.getTelefone()}"><br> <br>
			</div>

			<div class="ml-5">
				Gênero: <input name="sexo" type="text" size="100"
					value="${cliente.getSexo()}"><br> <br>
			</div>

			<div class="ml-5">
				Email: <input name="email" type="text" size="100"
					required="required" value="${cliente.getEmail()}"><br> <br>
			</div>
			
			<div class="ml-5">
				Senha: <input name="senha" type="password" size="15"
					required="required" value="${cliente.getEmail()}"><br> <br>
			</div>
			
			<div class="ml-5">
				Senha: <input name="confsenha" type="password" size="15"
					required="required" value="${cliente.getEmail()}"><br> <br>
			</div>


			<div class="ml-5">
				<input class="btn btn-dark" type="submit" value="Salvar">
			</div>

		</form>
	</div>
	<br>
	<br>


</body>
</html>