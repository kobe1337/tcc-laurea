

<%@page import="DAO.ProfessorDisciplinaDAO"%>
<%@page import="model.ProfessorDisciplina"%>
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
        <title>Listar Professores/Disciplina</title>

        <script type="text/javascript">

            function confirmarExclusao(idprofessor, iddisciplina, nomeprofessor, nomedisciplina) {
                if (confirm('Deseja realmente desvincular o(a) professor(a) ' + nomeprofessor + ' da disciplina ' + nomedisciplina + '?')) {
                    location.href = 'gerenciar_professor_disciplina.do?' +
                            'acao=desvincular&idprofessor=' + idprofessor + '&iddisciplina=' + iddisciplina;
                }
            }
        </script>

    </head>
    <body class="body">
        <%@include file="menu.jsp" %>

        <div class="row">
            <a href="form_professor_disciplina.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Vincular</div></a>
        </div>
        <div class="row  justify-content-center" id="listagem">

            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped" id ="listaProfessorDisciplina" >

                    <thead>
                        <tr>
                            <th>Nome do Professor</th>
                            <th>Disciplina</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Nome do Professor</th>
                            <th>Disciplina</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </tfoot>

                    <jsp:useBean class="DAO.ProfessorDisciplinaDAO" id="pdDAO" />

                    <tbody>
                        <c:forEach var="pd" items="${pdDAO.lista}">
                            <tr>
                                <td>${pd.professor.nome}</td>
                                <td>${pd.disciplina.materia}</td>
                                <td style="text-align: center;">
                                    <button class="deletar icone_lista" onclick="confirmarExclusao(${pd.professor.idprofessor}, ${pd.disciplina.iddisciplina}, '${pd.professor.nome}', '${pd.disciplina.materia}')" >
                                        <img src="assets/img/lista/deletar.png">
                                    </button>    
                                </td>
                            </tr>
                        </c:forEach>                    
                    </tbody>    
                </table>    
            </div>

            <script type="text/javascript" src="datatables/jquery.js"></script>
            <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
            <script type="text/javascript" >

                                        $(document).ready(function () {
                                            $("#listaProfessorDisciplina").dataTable({
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
