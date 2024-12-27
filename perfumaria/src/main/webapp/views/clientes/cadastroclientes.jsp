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
	background-color: #f8f8f8; /* Cor de fundo neutra */
}

a {
	text-decoration: none;
	color: #000000; /* Cor do texto do link */
}

.link-inserir {
	padding: 10px 15px;
	background-color: #007bff; /* Cor padr�o de bot�o */
	color: white;
	text-decoration: none;
	border-radius: 5px;
	font-family: Arial, sans-serif;
	align-items: left;
	margin-bottom: 20px;
}

.link-inserir:hover {
	background-color: #0056b3; /* Efeito de hover no link */
}

.botaos {
	padding: 6px 15px;
	background-color: #007bff; /* Cor padr�o de bot�o */
	color: white;
	text-decoration: none;
	border-radius: 5px;
	font-family: Arial, sans-serif;
	align-items: left;
	cursor: pointer;
	display: inline-block;
}

.botaos:hover {
	background-color: #0056b3; /* Efeito de hover no bot�o */
}

table {
	width: 100%;
	margin: 20px 0;
	border-collapse: collapse; /* Deixa as bordas da tabela coladas */
}

th, td {
	padding: 12px;
	text-align: center;
	font-family: 'Arial', sans-serif;
	font-size: 16px;
	border: 1px solid #ddd; /* Borda suave */
}

th {
	background-color: #f1f1f1; /* Cor suave para o cabe�alho */
	color: #000000; /* Cor do texto do cabe�alho */
	font-weight: bold;
}

td {
	background-color: #ffffff; /* Cor suave para as c�lulas */
}

tr:nth-child(even) td {
	background-color: #f9f9f9; /* Cor diferente para as linhas pares */
}

tr:hover td {
	background-color: #f1f1f1; /* Efeito hover nas linhas */
}

hr {
	border: none;
	height: 1px;
	background-color: #ddd; /* Cor neutra para a linha */
	margin: 20px 0;
}

@media screen and (max-width: 768px) {
	table {
		font-size: 14px;
	}
	.botaos {
		font-size: 12px;
		padding: 4px 8px;
	}
}
</style>
</head>
<body>
	<jsp:include page="../../includes/menuadm.jsp" />

	<div
		style="display: flex; justify-content: center; flex-direction: column; align-items: center;">
		<header>
			<p
				style="font-weight: 500; font-family: cursive; font-size: 20px; color: #000000;"
				class="ml-5 mb-4">Cadastro de Clientes</p>
		</header>

		<a href="cadastro" class="link-inserir">Inserir</a>

		<table>
			<thead>
				<tr style="color: #DF318E; font-family: cursive; font-weight: 800;"
					class="text-center">
					<!-- Cabe�alho da tabela -->
					<th width="5%">Editar</th>
					<th width="5%">Excluir</th>
					<th width="12%">Id Cliente</th>
					<th width="18%">Nome</th>
					<th width="18%">Cpf</th>
					<th width="12%">Email</th>
					<th width="12%">Telefone</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${listaClientes}">
					<tr
						style="font-weight: 600; font-family: 'Yantramanav'; font-size: 20px;"
						class="text-center">
						<!-- Bot�o editar -->
						<td><a href="editar?codigocliente=${cliente.codigocliente}"
							class="botaos">Editar</a></td>

						<!-- Bot�o excluir -->
						<td><a href="excluir?codigocliente=${cliente.codigocliente}"
							onClick="return confirm('Deseja realmente excluir?')"
							class="botaos">Excluir</a></td>

						<td>${cliente.codigocliente}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.email}</td>
						<td>${cliente.telefone}</td>

						<!-- Imagem do produto -->

					</tr>
				</c:forEach>

			</tbody>
		</table>

		<hr
			style="border: none; height: 4px; background-color: #21252996; margin: 20px 0;">
	</div>
</body>
</html>