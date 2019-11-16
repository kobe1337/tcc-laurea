

<%@page import="DAO.MensalidadeDAO"%>
<%@page import="model.Mensalidade"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_listas.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>
        <title>Listar Mensalidade</title>

    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
        <div class="row">
            <a href="form_mensalidade.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Cadastrar Mensalidade</div></a>
        </div>

        <div class="row  justify-content-center" id="listagem">

            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped"
                       id ="listaMensalidade" >

                    <thead>
                        <tr>
                            <th style="text-align: center;">Contrato</th>
                            <th>Aluno</th>
                            <th>Responsável</th>
                            <th style="text-align: center;">Valor</th>
                            <th style="text-align: center;">Vencimento</th> 
                            <th style="text-align: center;">Status</th>
                            <th style="text-align: center;">Editar</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th style="text-align: center;">Contrato</th>
                            <th>Aluno</th>
                            <th>Responsável</th>
                            <th style="text-align: center;">Valor</th>
                            <th style="text-align: center;">Vencimento</th>
                            <th style="text-align: center;">Status</th>
                            <th style="text-align: center;">Editar</th>
                        </tr>
                    </tfoot>

                    <jsp:useBean class="DAO.MensalidadeDAO" id="menDAO" />
                    <jsp:useBean class="DAO.ResponsavelDAO" id="resDAO" />
                    <jsp:useBean class="DAO.AlunoDAO" id="aDAO" />

                    <tbody>
                        <c:forEach var="men" items="${menDAO.lista}">
                            <c:forEach var="res" items="${resDAO.lista}">
                                <c:forEach var="a" items="${aDAO.lista}">
                                    <c:if test="${ulogado.perfil == 'Administrador(a)' || ulogado.perfil == 'Secretário(a)'
                                                  || ulogado.nome == res.usuario.nome}">
                                        <c:if test="${men.contrato.aluno.responsavel.nome == res.nome && men.contrato.aluno.nome == a.nome}">
                                            <tr>
                                                <td style="text-align: center;">${men.contrato.idcontrato}</td>
                                                <td>${men.contrato.aluno.nome}</td>
                                                <td>${men.contrato.aluno.responsavel.nome}</td>

                                                <td style="text-align: center;">R$${men.valor}</td>
                                                <td style="text-align: center;">${men.datap}</td>
                                                <td style="text-align: center;">
                                                    <c:if test="${men.status == 2}" > Pendente </c:if>
                                                    <c:if test="${men.status == 1}" > Pago </c:if>
                                                    </td>
                                                    <td style="text-align: center;"> 
                                                        <a class="icone_lista" 
                                                           href="gerenciar_mensalidade.do?acao=alterar&idcontrato=${men.contrato.idcontrato}&idmensalidade=${men.idmensalidade}">
                                                        <img src="assets/img/lista/editar.png">
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:if>
                                </c:forEach>                    
                            </c:forEach>                    
                        </c:forEach>                    
                    </tbody>    
                </table>    
            </div>
        </div>

        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
        <script type="text/javascript" >

            $(document).ready(function () {
                $("#listaMensalidade").dataTable({
                    "bJQueryUI": true,
                    "oLanguage": {
                        "sProcessing": "Processando ...",
                        "sLengthMenu": "Mostrar _MENU_ registros",
                        "sZeroRecords": "Não foram encontrados resultados",
                        "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                        "sInfoEmpty": "Mostrando de 0 até 0 de 0 resgistros",
                        "sInfoFiltered": "",
                        "sInfoPostFix": "",
                        "sSearch": "Pesquisar",
                        "sUrl": "",
                        "oPaginate": {
                            "sFirst": "Primeiro",
                            "sPrevious": "Anterior",
                            "sNext": "Próximo",
                            "sLast": "Último"
                        }
                    }

                });

            });
        </script>
    </body>
</html>
