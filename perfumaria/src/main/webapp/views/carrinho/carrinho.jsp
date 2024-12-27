<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfumaria Tenguam | Carrinho</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
    <style type="text/css">
        body {
            font-family: Helvetica;
            padding: 0px;
            margin: 0px;
        }

        .botao-remover {
            background-color: #843951;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>
</head>

<body>

    <jsp:include page="../../includes/menu.jsp" />
    
    <div class="carrinho-container">
        <h1>Carrinho de Compras</h1>

        <table class="tabela-carrinho">
            <thead>
                <tr>
                    <th>Imagem</th>
                    <th>Nome do Produto</th>
                    <th>QTD</th>
                    <th>Valor Total</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterando sobre os produtos do carrinho -->
                <c:forEach var="produto" items="${carrinho}">
                    <tr>
                        <!-- Exibindo a imagem do produto -->
                        <td>
                            <img src="data:image/jpeg;base64,${produto.imagemBase64}" alt="${produto.nomeproduto}" class="produto-imagem">
                        </td>
                        <td>${produto.nomeproduto}</td>
                        <td></td>
                        <td>R$ ${produto.valorproduto * produto.qtd}</td>
                        <td>
                            <form action="/carrinho/remover" method="POST">
                                <input type="hidden" name="produtoId" value="${produto.codigoproduto}" />
                                <button type="submit" class="botao-remover">Remover</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="compra-total">
            <div>
                <p class="negrito">Total Geral: R$<span id="total-geral">0,00</span></p>
            </div>
            <a href="#" onclick="finalizarCompra()" class="cadastrar" style="text-decoration: none; color: white;">Finalizar Compra</a>
        </div>

    </div>

    
    <jsp:include page="../../includes/footer.jsp" />

</body>

</html>