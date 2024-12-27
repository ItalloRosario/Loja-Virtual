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
}
</style>
</head>
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
                <th>Produto</th>
                <th>Quantidade</th>
                <th>Valor Produto</th>
                <th>Valor Total</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td rowspan="1">Elenice Alencar</td>
                <td rowspan="1">11/10/2024</td>
                <td>
                    <img src="https://www.sephora.com.br/dw/image/v2/BFJC_PRD/on/demandware.static/-/Sites-masterCatalog_Sephora/pt_BR/dwfe59ce07/images/hi-res-BR/3616303473396%20.01_1000px.jpg?sw=1200&sh=1200&sm=fit" width="50" height="50"/>
                    perfume calvin klein one essence intense
                </td>
                <td>1</td>
                <td>R$ 439,00</td>
                <td>R$ 439,00</td>
            </tr>
            <tr>
                <td rowspan="2">José Cunha Silva</td>
                <td rowspan="2">07/10/2024</td>
                <td>
                    <img src="https://www.sephora.com.br/dw/image/v2/BFJC_PRD/on/demandware.static/-/Sites-masterCatalog_Sephora/pt_BR/dwfa0d0850/images/hi-res-BR/_8411061088555_0065200348_0_1000px.jpg?sw=1200&sh=1200&sm=fit" width="50" height="50" />
                    Perfume banderas the secret absolu masculino eau de parfum
                </td>
                <td>1</td>
                <td>R$ 189,00</td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <img src="https://www.sephora.com.br/dw/image/v2/BFJC_PRD/on/demandware.static/-/Sites-masterCatalog_Sephora/pt_BR/dwc394d85e/images/hi-res-BR/1.%203348901709019.jpg?sw=1200&sh=1200&sm=fit" alt="Produto B2" width="50" height="50"/>
                    Perfume dior miss dior roller pearl feminino parfum
                </td>
                <td>1</td>
                <td>R$ 365,00</td>
                <td>R$ 554,00</td>
            </tr>
            <tr>
                <td rowspan="1">Rebecca dos Campos</td>
                <td rowspan="1">03/10/2024</td>
                <td>
                    <img src="https://www.sephora.com.br/dw/image/v2/BFJC_PRD/on/demandware.static/-/Sites-masterCatalog_Sephora/pt_BR/dw7f028a7b/images/Color%20BR/guerlain/PUCCI/SOMBRA/3346470441330_1.jpg?sw=216&sh=216&sm=fit" width="50" height="50"/>
                    Paleta de sombras guerlain x pucci ombres g
                </td>
                <td>1</td>
                <td>R$ 555,00</td>
                <td>R$ 555,00</td>
            </tr>
            <tr>
                <td rowspan="1">Laurenice Jangadeiro</td>
                <td rowspan="1">14/10/2024</td>
                <td>
                    <img src="https://www.sephora.com.br/dw/image/v2/BFJC_PRD/on/demandware.static/-/Sites-masterCatalog_Sephora/pt_BR/dw9264c08b/images/hi-res-BR/PDPs/MAB/NEW/PR/Mask-300-Power_1000px.jpg?sw=1200&sh=1200&sm=fit" width="50" height="50" />
                    Máscara capilar mab by alfaparf power reconstruction
                </td>
                <td>1</td>
                <td>R$ 149,00</td>
                <td>R$ 149,00</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="5" style="text-align: right; font-weight: bold;">Total:</td>
                <td style="font-weight: bold;">R$ 1.697,00</td>
            </tr>
        </tfoot>
    </table>
</div>

</body>
</html>