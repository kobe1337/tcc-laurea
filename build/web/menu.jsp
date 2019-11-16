<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controller.GerenciarLogin"%>
<%@page import="model.Usuario"%>

<%
    Usuario ulogado = GerenciarLogin.verificarAcesso(request, response);
    request.setAttribute("ulogado", ulogado);
%>
<head>
    <meta charset="utf-8"/>

    <link rel="stylesheet" type="text/css" href="estilo/menu.css"/>
</head>

<div class="menu">

    <div class="logo">
        <img src="assets/img/logo/logo_menu.png"> 

        <c:if test="${ulogado!=null}">${ulogado.nome}</c:if>

        </div>

    <c:if test="${ulogado != null && ulogado.perfil != null}">
        <c:forEach var="menu" items="${ulogado.perfil.menus}">
            <c:if test="${menu.exibir == 1}">
                <a href="${menu.link}"><div class="menu_item" ><img src="assets/img/menu/painel.png">${menu.menu}</div></a>                  
                    </c:if>    
                </c:forEach>
            </c:if>
    <a class="menu_item" href="gerenciar_login.do"> <div> <img src="assets/img/icone menu/sair.png"> Sair </div> </a>
</div>   











