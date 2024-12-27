<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produto Detalhado</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
    <style type="text/css">
        body {
            padding: 0px;
            margin: 0px;
            background-color: white;
        }
    </style>
</head>
<body>
    <jsp:include page="../../includes/menu.jsp" />

    <div class="container2">
        <div class="item">
            <h2>Perfumes</h2>
        </div>
        <div class="item">
            <h2>Maquiagem</h2>
        </div>
        <div class="item">
            <h2>Cabelo</h2>
        </div>
    </div>

    <div class="conteirarpaginaproduto">
        <div class="espaço"></div>

        <!-- Exibindo as informações do produto -->
        <div class="imagemprincipal">
            <!-- Imagem do produto -->
						<td><c:choose>
								<c:when test="${not empty produto.imagemBase64}">
									<img src="data:image/jpeg;base64,${produto.imagemBase64}"
										alt="Imagem do Produto" style="width: 80%; height: 80%;">
								</c:when>
								<c:otherwise>
                                </c:otherwise>
							</c:choose></td>
        </div>

        <div class="tituloprod">
            <p class="negrito" id="produto-marca">${produto.marca}</p>
            <p class="negrito" id="produto-nome">${produto.nomeproduto}</p>
            <p id="produto-preco">R$ ${produto.valorproduto}0</p>
            <p id="produto-parcelas">ou 10x de ${produto.valorproduto/10}0</p>

            <form action="/perfumaria/carrinho/novo" method="POST" enctype="multipart/form-data">
            
            <input type="hidden" name="id" value="${produto.getCodigoproduto()}" />
            <input type="hidden" name="nomeproduto" value="${produto.getNomeproduto()}" />
            <input type="hidden" name="valortotal" value="${produto.getValorproduto()}" />
            <img name="imagem" src="data:image/jpeg;base64,${produto.imagemBase64}"
    alt="Imagem do Produto" style="width: 80%; height: 80%;" hidden>
            
            
                <div class="produto-actions">
                    <label for="quantidade_prod">QTD:</label>
                    <select name="quantidade_prod_id">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                    <input type="submit" value="Confirmar" style="margin-top: 10px;" id="adicionarCarrinho" />
                </div>
            </form>
        </div>

        <div class="espaço"></div>
    </div>

    <div class="calculo-cep">
        <label for="cep">Digite seu CEP:</label>
        <input type="text" id="cep" placeholder="Calcular Frete" />
        <button type="button">Calcular</button>
    </div>

    <div class="descricao">
        <h3 id="descricao_produto">${produto.nomeproduto}</h3>
        <p id="descricao_texto">${produto.descricao}</p>
    </div>

    <jsp:include page="../../includes/footer.jsp" />
</body>
</html>