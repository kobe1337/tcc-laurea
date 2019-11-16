

<%@page import="DAO.ProfessorDAO"%>
<%@page import="model.Professor"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, 
              user-scalable=no" name="viewport"/>
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_listas.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
        <title>Listar Professor</title>

        <script type="text/javascript">

            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente desativar o professor  ' + nome + ' ?')) {
                    location.href = 'gerenciar_professor.do?acao=desativar&idprofessor=' + id;
                }
            }
        </script>

    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
        <div class="row">
            <a href="form_professor.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Cadastrar Professor </div></a>
        </div>
        <div class="row  justify-content-center" id="listagem">

            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped" id="listaUsuario">

                    <thead>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Nome</th>
                            <th>Status</th>
                            <th>Nome de Usuário</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Nome</th>
                            <th>Status</th>
                            <th>Nome de Usuário</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </tfoot>

                    <jsp:useBean class="DAO.ProfessorDAO" id="prDAO" />

                    <tbody>
                        <c:forEach var="pr" items="${prDAO.lista}">
                            <tr>
                                <td>${pr.idprofessor}</td>
                                <td>${pr.nome}</td>
                                <td>
                                    <c:if test="${pr.status == 2}" > Desativado </c:if>
                                    <c:if test="${pr.status == 1}" > Ativado </c:if>
                                    </td>
                                    <td>${pr.usuario}</td>
                                <td style="text-align: center;">
                                    <a class="icone_lista" href="gerenciar_professor.do?acao=alterar&idprofessor=${pr.idprofessor}">
                                        <img src="assets/img/lista/editar.png">
                                    </a>
                                </td>
                                <td style="text-align: center;">
                                    <button class="deletar icone_lista" onclick="confirmarExclusao(${pr.idprofessor}, '${pr.nome}')" >
                                        <img src="assets/img/lista/deletar.png">
                                    </button>    
                                </td>
                            </tr>
                        </c:forEach>                    
                    </tbody>    
                </table>    
            </div>
        </div>
        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
        <script type="text/javascript" >

                                        $(document).ready(function () {
                                            $("#listaProfessor").dataTable({
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
