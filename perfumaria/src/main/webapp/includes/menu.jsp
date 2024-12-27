<!-- menu.jsp -->
<%@ page import="perfumaria.model.Cliente" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<div class="container">

    <div class="item1">
        <a href="${pageContext.request.contextPath}/index.jsp">
            <img src="${pageContext.request.contextPath}/imagens/imagem.png" width="90%" height="30%"/>
        </a>
    </div>
    
    <div class="">
        <p></p>
    </div>

    <div class="item">
        <%
        // Obtém a sessão atual
        Cliente cliente = null;

        if (session != null) {
            cliente = (Cliente) session.getAttribute("cliente"); // Obtém o objeto 'cliente' da sessão
        }

        // Verifica se o cliente está logado
        if (cliente == null) {
        %>
            <a href="${pageContext.request.contextPath}/views/clientes/Login-cliente.jsp">Fazer login</a>
        <%
        } else {
        %>
            <a href="${pageContext.request.contextPath}/views/clientes/vizualiza-cliente.jsp">
                <%= cliente.getNome() + " " + cliente.getSobrenome() %>
            </a>
        <%
        }
        %>
    </div>

    <div class="item">
        <a href="${pageContext.request.contextPath}/carrinho/listar">
            <img src="https://www.sephora.com.br/on/demandware.static/Sites-Sephora_BR-Site/-/default/dw79b3d554/images/svg/basketactive-icon.svg"
                 width="180%" height="180%" />
        </a>
    </div>

</div>