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
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <title>Láurea Reforço Escolar</title>
        
        <script type="text/javascript">
            
            function confirmarExclusao(idaluno, idturma , nomealuno, nometurma){
                if(confirm('Deseja realmente desvincular o(a) aluno(a) '+nomealuno+' da turma '+nometurma+'?')){
                    location.href='gerenciar_aluno_turma.do?' +
                    'acao=desvincular&idaluno='+idaluno+'&idturma='+idturma;
                }                
            }            
        </script>

    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            
            
            <h1>Lista de Chamadas</h1>

            <a href="form_aluno_turma.jsp" class="btn btn-primary">
                Novo Cadastro
            </a>
            <table class="table table-hover table-striped table-bordered display" 
                   id ="listaAlunoTurma" >

                <thead>
                    <tr>
                        <th>Nome da Turma</th>
                        <th>Nome do Aluno</th>
                        <th>Nome do Professor</th>
                        <th>Data</th>
                        <th>Frequência</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Nome da Turma</th>
                        <th>Nome do Aluno</th>
                        <th>Nome do Professor</th>
                        <th>Data</th>
                        <th>Frequência</th>
                        <th>Opções</th>
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
                            <td>${atu.turma.nome}</td>
                            <td>${atu.aluno.nome}</td>
                            <td>${atu.turma.professor.nome}</td>
                            <td>${atu.data}</td>
                            <td>${atu.frequencia}</td>
                            <td>
                                
                                <a class="btn btn-primary" 
                                   href="gerenciar_aluno_turma.do?acao=alterar&idaluno=${atu.aluno.idaluno}&idturma=${atu.turma.idturma}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                
                                <button class="btn btn-danger" 
                                        onclick="confirmarExclusao(${atu.aluno.idaluno}, ${atu.turma.idturma}, 
                                                    '${atu.aluno.nome}', '${atu.turma.nome}')" >
                                    <i class="glyphicon glyphicon-trash"></i>
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

        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
        <script type="text/javascript" >
                
            $(document).ready(function(){
                $("#listaAlunoTurma").dataTable({
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
