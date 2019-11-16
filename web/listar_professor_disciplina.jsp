

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
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <title>Láurea Reforço Escolar</title>

        <script type="text/javascript">
            
            function confirmarExclusao(idprofessor, iddisciplina , nomeprofessor, nomedisciplina){
                if(confirm('Deseja realmente desvincular o(a) professor(a) '+nomeprofessor+' da disciplina '+nomedisciplina+'?')){
                    location.href='gerenciar_professor_disciplina.do?' +
                    'acao=desvincular&idprofessor='+idprofessor+'&iddisciplina='+iddisciplina;
                }                
            }            
        </script>

    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Vínculos Professor/Disciplina</h1>

            <a href="form_professor_disciplina.jsp" class="btn btn-primary">
                Novo Cadastro
            </a>
            <table class="table table-hover table-striped table-bordered display" 
                   id ="listaProfessorDisciplina" >

                <thead>
                    <tr>
                        <th>Nome do Professor</th>
                        <th>Disciplina</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Nome do Professor</th>
                        <th>Disciplina</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.ProfessorDisciplinaDAO" id="pdDAO" />

                <tbody>
                    <c:forEach var="pd" items="${pdDAO.lista}">
                        <tr>
                            <td>${pd.professor.nome}</td>
                            <td>${pd.disciplina.materia}</td>
                            <td>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${pd.professor.idprofessor}, ${pd.disciplina.iddisciplina}, '${pd.professor.nome}', '${pd.disciplina.materia}')" >
                                    <i class="glyphicon glyphicon-trash"></i>
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
                
            $(document).ready(function(){
                $("#listaProfessorDisciplina").dataTable({
                    "bJQueryUI":  true,
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
                            "sFirst" : "Primeiro",
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
