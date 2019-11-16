<%@page import="DAO.AlunoDAO"%>
<%@page import="model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, 
              user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_listas.css">
        <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
        <title>Listar Aluno</title>

        <script type="text/javascript">

            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente desativar o(a) aluno(a)  ' + nome + ' ?')) {
                    location.href = 'gerenciar_aluno.do?acao=desativar&idaluno=' + id;
                }
            }
        </script>

    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
        <div class="row">
            <a href="form_aluno.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Cadastrar Aluno </div></a>
        </div>
        <div class="row  justify-content-center" id="listagem">
            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped"
                       id ="listaAluno" >

                    <thead>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Nome</th>
                            <th style="text-align: center;">Status</th>
                            <th style="text-align: center;">Responsável</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>

                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Nome</th>                          
                            <th style="text-align: center;">Status</th>
                            <th style="text-align: center;">Responsável</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </tfoot>

                    <jsp:useBean class="DAO.AlunoDAO" id="aDAO" />

                    <tbody>
                        <c:forEach var="a" items="${aDAO.lista}">
                            <tr>
                                <td style="text-align: center;">${a.idaluno}</td>
                                <td>${a.nome}</td>
                                <td style="text-align: center;">
                                    <c:if test="${a.status == 2}" > Desativado </c:if>
                                    <c:if test="${a.status == 1}" > Ativado </c:if>
                                    </td>
                                    <td style="text-align: center;">${a.responsavel}</td>
                                <td style="text-align: center;">
                                    <a class="icone_lista" href="gerenciar_aluno.do?acao=alterar&idaluno=${a.idaluno}">
                                        <img src="assets/img/lista/editar.png">
                                    </a>
                                </td>
                                <td style="text-align: center;">
                                    <button class="icone_lista deletar" onclick="confirmarExclusao(${a.idaluno}, '${a.nome}')" >
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
                                            $("#listaAluno").dataTable({
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
