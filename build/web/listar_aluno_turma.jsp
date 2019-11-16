<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="DAO.AlunoTurmaDAO"%>
<%@page import="model.AlunoTurma"%>
<%@page import="java.util.ArrayList"%>

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
        <title>Chamada</title>

        <script type="text/javascript">

            function confirmarExclusao(idaluno, idturma, nomealuno, nometurma) {
                if (confirm('Deseja realmente desvincular o(a) aluno(a) ' + nomealuno + ' da turma ' + nometurma + '?')) {
                    location.href = 'gerenciar_aluno_turma.do?' +
                            'acao=desvincular&idaluno=' + idaluno + '&idturma=' + idturma;
                }
            }
        </script>

    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
        <div class="row">
            <a href="form_aluno_turma.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Cadastrar Aluno </div></a>
        </div>
        <div class="row  justify-content-center" id="listagem">
            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped"
                       id ="listaAlunoTurma" >

                    <thead>
                        <tr>
                            <th style="text-align: center;">Turma</th>
                            <th>Aluno</th>
                            <th>Professor</th>
                            <th style="text-align: center;">Data</th>
                            <th style="text-align: center;">Frequência</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th style="text-align: center;">Turma</th>
                            <th>Aluno</th>
                            <th>Professor</th>
                            <th style="text-align: center;">Data</th>
                            <th style="text-align: center;">Frequência</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </tfoot>

                    <jsp:useBean class="DAO.AlunoTurmaDAO" id="atuDAO" />
                    <jsp:useBean class="DAO.ProfessorDAO" id="prDAO" />

                    <tbody>
                        <c:forEach var="atu" items="${atuDAO.lista}">
                            <c:forEach var="pr" items="${prDAO.lista}">
                                <c:if test="${ulogado.perfil == 'Administrador(a)' || ulogado.perfil == 'Secretário(a)' 
                                              || ulogado.nome ==  pr.usuario.nome}">
                                    <c:if test="${atu.turma.professor.nome ==  pr.nome}">


                                        <tr>
                                            <td style="text-align: center;">${atu.turma.nome}</td>
                                            <td>${atu.aluno.nome}</td>
                                            <td>${atu.turma.professor.nome}</td>
                                            <td style="text-align: center;">${atu.data}</td>
                                            <td style="text-align: center;">${atu.frequencia}</td>
                                            <td style="text-align: center;">

                                                <a class="icone_lista" 
                                                   href="gerenciar_aluno_turma.do?acao=alterar&idaluno=${atu.aluno.idaluno}&idturma=${atu.turma.idturma}">
                                                    <img src="assets/img/lista/editar.png">
                                                </a>
                                            </td>
                                            <td style="text-align: center;">

                                                <button class="icone_lista deletar" 
                                                        onclick="confirmarExclusao(${atu.aluno.idaluno}, ${atu.turma.idturma},
                                                                        '${atu.aluno.nome}', '${atu.turma.nome}')" >
                                                    <img src="assets/img/lista/deletar.png">
                                                </button>
                                            </td>
                                        </tr>  


                                    </c:if>
                                </c:if>
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
                                                                $("#listaAlunoTurma").dataTable({
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
