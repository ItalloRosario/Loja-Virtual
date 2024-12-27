<%@ page import="java.util.*, perfumaria.dao.ProdutoDAO, perfumaria.model.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfumaria Tenguam | Loja online de Cosmeticos</title>

<link rel="stylesheet" type="text/css" href="css/estilos.css">
<style type="text/css">
body {
	font-family: Helvetica;
	padding: 0px;
	margin: 0px;
}

</style>
</head>
<body>
	<!-- Incluindo o menu de navegação -->
	<jsp:include page="includes/menu.jsp" />

	<div class="container2">
		<div class="item">
			<h2>
				<a href="#perfumes" style="color: white; text-decoration: none;">Perfumes</a>
			</h2>
		</div>

		<div class="item">
			<h2>
				<a href="#maquiagem" style="color: white; text-decoration: none;">Maquiagem</a>
			</h2>
		</div>

		<div class="item">
			<h2>
				<a href="#cabelo" style="color: white; text-decoration: none;">Cabelo</a>
			</h2>
		</div>
	</div>



	<div class="container3">
		<div class="item">
			<h2 id="perfumes">Perfumes</h2>
		</div>
	</div>


	<div class="containerprodutos">
        <%
            ProdutoDAO produtoDAO = new ProdutoDAO();
            ArrayList<Produto> produtos = produtoDAO.listar();  // Usando o método listar() da DAO
            int contador = 0;
            
            // Loop para exibir os produtos
            for (Produto produto : produtos) {
            	if ("Perfume".equals(produto.getTipo())) { 
                contador++;
                
            
        %>

            <!-- Exibição de um produto -->
            <div class="produto">
                <a href="${pageContext.request.contextPath}/clientes/mostrarProdutoDetalhado?id=<%= produto.getCodigoproduto() %>">
                    <!-- Verificando se a imagem existe em base64, e exibindo uma imagem padrão caso não exista -->
                    <% if (produto.getImagemBase64() != null && !produto.getImagemBase64().isEmpty()) { %>
                        <img src="data:image/jpeg;base64,<%= produto.getImagemBase64() %>" width="50%" height="50%" />
                    <% } else { %>
                        <img src="images/sem_imagem.png" width="50%" height="50%" />  <!-- Imagem padrão caso não tenha imagem base64 -->
                    <% } %>
                    <p class="titulo">
                        <%= produto.getNomeproduto() %> <br> <%= produto.getMarca() %>
                    </p>
                    <br>
                    <p>
                        a partir de <br> R$ <%= produto.getValorproduto() %>0<br> ou 10x de R$ <%= produto.getValorproduto() / 10 %>0
                    </p>
                </a>
            </div>

            <!-- A cada 4 produtos, vamos fechar a div de containerprodutos e abrir uma nova linha -->
            <%
                }
                if (contador % 4 == 0) {
            %>
                </div> <!-- Fecha a linha de 4 produtos -->
                <br>
                <div class="containerprodutos"> <!-- Inicia uma nova linha -->
            <%
                }
            }
            
            // Fechar a última linha caso o número de produtos não seja múltiplo de 4
            if (contador % 4 != 0) {
            %>
                </div> <!-- Fecha a última linha que não é múltipla de 4 -->
            <%
            }
            %>
        
    </div> <!-- Fecha o containerprodutos -->

	<div class="container4">
		<div class="item">
			<h2 id="maquiagem">Maquiagem</h2>
		</div>
	</div>


	<div class="containerprodutos">
        <%
            ProdutoDAO maquiagem = new ProdutoDAO();
            ArrayList<Produto> maquiagemprodutos = produtoDAO.listar();  // Usando o método listar() da DAO
            contador = 0;
            
            // Loop para exibir os produtos
            for (Produto produto : produtos) {
            	if ("Maquiagem".equals(produto.getTipo())) { 
                contador++;
        %>

            <!-- Exibição de um produto -->
            <div class="produto">
                <a href="${pageContext.request.contextPath}/clientes/mostrarProdutoDetalhado?id=<%= produto.getCodigoproduto() %>">
                    <!-- Verificando se a imagem existe em base64, e exibindo uma imagem padrão caso não exista -->
                    <% if (produto.getImagemBase64() != null && !produto.getImagemBase64().isEmpty()) { %>
                        <img src="data:image/jpeg;base64,<%= produto.getImagemBase64() %>" width="50%" height="50%" />
                    <% } else { %>
                        <img src="images/sem_imagem.png" width="50%" height="50%" />  <!-- Imagem padrão caso não tenha imagem base64 -->
                    <% } %>
                    <p class="titulo">
                        <%= produto.getNomeproduto() %> <br> <%= produto.getMarca() %>
                    </p>
                    <br>
                    <p>
                        a partir de <br> R$ <%= produto.getValorproduto() %>0<br> ou 10x de R$ <%= produto.getValorproduto() / 10 %>0
                    </p>
                </a>
            </div>

            <!-- A cada 4 produtos, vamos fechar a div de containerprodutos e abrir uma nova linha -->
            <%
            	}
                if (contador % 4 == 0) {
            %>
                </div> <!-- Fecha a linha de 4 produtos -->
                <br>
                <div class="containerprodutos"> <!-- Inicia uma nova linha -->
            <%
                }
            }
            
            // Fechar a última linha caso o número de produtos não seja múltiplo de 4
            if (contador % 4 != 0) {
            %>
                </div> <!-- Fecha a última linha que não é múltipla de 4 -->
            <%
            }
            %>
        
    </div> <!-- Fecha o containerprodutos -->

	<div class="container4">
		<div class="item">
			<h2 id="cabelo">Cabelo</h2>
		</div>
	</div>


	<div class="containerprodutos">
        <%
            ProdutoDAO cabelo = new ProdutoDAO();
            ArrayList<Produto> cabeloprodutos = produtoDAO.listar();  // Usando o método listar() da DAO
            contador = 0;
            
            // Loop para exibir os produtos
            for (Produto produto : produtos) {
            	if ("Cabelo".equals(produto.getTipo())) { 
                contador++;
        %>

            <!-- Exibição de um produto -->
            <div class="produto">
                <a href="${pageContext.request.contextPath}/clientes/mostrarProdutoDetalhado?id=<%= produto.getCodigoproduto() %>">
                    <!-- Verificando se a imagem existe em base64, e exibindo uma imagem padrão caso não exista -->
                    <% if (produto.getImagemBase64() != null && !produto.getImagemBase64().isEmpty()) { %>
                        <img src="data:image/jpeg;base64,<%= produto.getImagemBase64() %>" width="50%" height="50%" />
                    <% } else { %>
                        <img src="images/sem_imagem.png" width="50%" height="50%" />  <!-- Imagem padrão caso não tenha imagem base64 -->
                    <% } %>
                    <p class="titulo">
                        <%= produto.getNomeproduto() %> <br> <%= produto.getMarca() %>
                    </p>
                    <br>
                    <p>
                        a partir de <br> R$ <%= produto.getValorproduto() %>0 <br> ou 10x de R$ <%= produto.getValorproduto() / 10 %>0
                    </p>
                </a>
            </div>

            <!-- A cada 4 produtos, vamos fechar a div de containerprodutos e abrir uma nova linha -->
            <%
            	}
                if (contador % 4 == 0) {
            %>
                </div> <!-- Fecha a linha de 4 produtos -->
                <br>
                <div class="containerprodutos"> <!-- Inicia uma nova linha -->
            <%
                }
            }
            
            // Fechar a última linha caso o número de produtos não seja múltiplo de 4
            if (contador % 4 != 0) {
            %>
                </div> <!-- Fecha a última linha que não é múltipla de 4 -->
            <%
            }
            %>
        
    </div> <!-- Fecha o containerprodutos -->





	<!-- Incluindo o rodapé do site -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>