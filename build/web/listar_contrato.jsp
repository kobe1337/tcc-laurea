

<%@page import="DAO.ContratoDAO"%>
<%@page import="model.Contrato"%>
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

            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente desativar o contrato do(a) aluno(a) ' + nome + ' ?')) {
                    location.href = 'gerenciar_contrato.do?acao=desativar&idcontrato=' + id;
                }
            }
        </script>

    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Contratos</h1>

            <a href="form_contrato.jsp" class="btn btn-primary">
                Novo Cadastro
            </a>
            <table class="table table-hover table-striped table-bordered display" 
                   id ="listaContrato" >

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do Aluno</th>
                        <th>Escola</th>
                        <th>Série</th>
                        <th>Nome do Responsável</th>
                        <th>Data do Contrato</th>
                        <th>Valor do Contrato</th>
                        <th>Quantidade de Parcelas</th>
                        <th>Status</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome do Aluno</th>
                        <th>Escola</th>
                        <th>Série</th>
                        <th>Nome do Responsável</th>
                        <th>Data do Contrato</th>
                        <th>Valor do Contrato</th>
                        <th>Quantidade de Parcelas</th>
                        <th>Status</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.ContratoDAO" id="conDAO" />
                <jsp:useBean class="DAO.ResponsavelDAO" id="resDAO" />
                <jsp:useBean class="DAO.AlunoDAO" id="aDAO" />

                <tbody>
                    <c:forEach var="con" items="${conDAO.lista}">
                    <c:forEach var="res" items="${resDAO.lista}">
                    <c:forEach var="a" items="${aDAO.lista}">
                    
                        <c:if test="${ulogado.perfil == 'Administrador(a)' || ulogado.perfil == 'Secretário(a)'
                              || ulogado.nome == res.usuario.nome}">
                            <c:if test="${con.aluno.responsavel.nome == res.nome && con.aluno.nome == a.nome}">
                                <tr>
                                    <td>${con.idcontrato}</td>
                                    <td>${con.aluno.nome}</td>
                                    <td>${con.escola}</td>
                                    <td>${con.serie}</td>
                                    <td>${con.aluno.responsavel.nome}</td>
                                    <td>${con.datacontrato}</td>
                                    <td>R$${con.preco}</td>
                                    <td>${con.parcela}</td>
                                    <td>
                                        <c:if test="${con.status == 2}" > Desativado </c:if>
                                        <c:if test="${con.status == 1}" > Ativado </c:if>
                                        </td>
                                        <td>
                                            <a class="btn btn-primary" href="gerenciar_contrato.do?acao=alterar&idcontrato=${con.idcontrato}">
                                            <i class="glyphicon glyphicon-pencil"></i>
                                        </a>
                                        <button class="btn btn-danger" onclick="confirmarExclusao(${con.idcontrato}, '${con.aluno.nome}')" >
                                            <i class="glyphicon glyphicon-trash"></i>
                                        </button>    
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

        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
        <script type="text/javascript" >

                                    $(document).ready(function () {
                                        $("#listaContrato").dataTable({
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
