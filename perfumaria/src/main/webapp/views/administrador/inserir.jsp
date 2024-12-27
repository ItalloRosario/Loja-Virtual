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

	<div
		style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
		<header>
			<a href=""><img class="ml-5 mt-5" src="" alt=""></a>
			<p
				style="font-weight: 500; font-family: cursive; font-size: 20px; color: #000000;"
				class="ml-5 mb-4">Painel Administrativo Inserir</p>

		</header>

		<a href="cadastroprodutos.jsp">VOLTAR PARA A LISTA</a>

		<form action="${produto == null ? 'novo' : 'update'}" method="post"
			enctype="multipart/form-data" id="form_inserir"
			style="color: #000000f3; font-weight: 600; font-family: cursive; font-size: 19px;">

			<input type="hidden" name="codigoproduto"
				value="${produto.getCodigoproduto()}">

			<div class="ml-5" style="margin: 0">
				Nome do Produto: <input name="nomeproduto" type="text"
					required="required" size="100" value="${produto.getNomeproduto()}"><br>
				<br>
			</div>

			<div class="ml-5">
				Descrição:
				<textarea name="descricao" cols="40"">${produto.descricao != null ? produto.descricao : 'TA VAZIO'}</textarea>
				<br> <br>
			</div>

			<div class="ml-5">
				Valor: <input name="preco" type="number" size="15"
					required="required" value="${produto.getValorproduto()}"><br>
				<br>
			</div>

			<div class="ml-5">
				Marca: <input name="marca" type="text" size="100"
					value="${produto.getMarca()}"><br> <br>
			</div>

			<div class="ml-5">
				<div class="ml-5">
				<div class="ml-5">
					Tipo do produto: <select name="tipo">		
							<option value="Perfume">Perfume</option>
							<option value="Maquiagem">Maquiagem</option>
							<option value="Cabelo">Cabelo</option>
					</select>
				</div>
			</div>
			<br>
			</div>

			<div class="ml-5">
				Quantidade: <input name="quantidade" type="number" size="15"
					required="required" value="${produto.getQtd()}"><br> <br>
			</div>

			<div class="ml-5">
				Imagem Grande: <input class="btn btn-dark" name="fotograndeprod"
					type="file" value="${produto.getFotograndeprod()}"><br>
				<br>
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