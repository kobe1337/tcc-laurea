

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
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <title>Láurea Reforço Escolar</title>

        <script type="text/javascript">
            
            function confirmarExclusao(id, nome){
                if(confirm('Deseja realmente desativar o professor  '+nome+' ?')){
                    location.href='gerenciar_professor.do?acao=desativar&idprofessor='+id;
                }                
            }            
        </script>

    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Professores</h1>

            <a href="form_professor.jsp" class="btn btn-primary">
                Novo Cadastro
            </a>
            <table class="table table-hover table-striped table-bordered display" 
                   id ="listaProfessor" >

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Status</th>
                        <th>Nome de Usuário</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Status</th>
                        <th>Nome de Usuário</th>
                        <th>Opções</th>
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
                            <td>
                                <a class="btn btn-primary" href="gerenciar_professor.do?acao=alterar&idprofessor=${pr.idprofessor}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${pr.idprofessor}, '${pr.nome}')" >
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
                $("#listaProfessor").dataTable({
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
