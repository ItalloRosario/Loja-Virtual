<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">

<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
	background-color: white;
}
</style>
<body>
	<jsp:include page="../../includes/menuadm.jsp" />

	<br>
	
    <div class="tabelaresumida">
    <h1>Resumo de Vendas</h1>
    <table>
        <thead>
            <tr>
                <th>Nome do Cliente</th>
                <th>Data</th>
                <th>Quantidade de itens</th>
                <th>Valor Total</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Elenice Alencar</td>
                <td>11/10/2024</td>
                <td>1</td>
                <td>R$ 439,00</td>
            </tr>
            <tr>
                <td>José Cunha Silva</td>
                <td>07/10/2024</td>
                <td>2</td>
                <td>R$ 554,00</td>
            </tr>
            <tr>
                <td>Rebecca dos Campos</td>
                <td>03/10/2024</td>
                <td>1</td>
                <td>R$ 555,00</td>
            </tr>
            <tr>
                <td>Laurenice Jangadeiro</td>
                <td>14/10/2024</td>
                <td>1</td>
                <td>R$ 149,00</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="3" style="text-align: right; font-weight: bold;">Total:</td>
                <td style="font-weight: bold;">R$ 1.697,00</td>
            </tr>
        </tfoot>
    </table>
</div>

	
</body>
</html>