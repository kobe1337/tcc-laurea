

<%@page import="DAO.MensalidadeDAO"%>
<%@page import="model.Mensalidade"%>
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

    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Mensalidades</h1>

            <a href="form_mensalidade.jsp" class="btn btn-primary">
                Novo Cadastro
            </a>
            <table class="table table-hover table-striped table-bordered display" 
                   id ="listaMensalidade" >

                <thead>
                    <tr>
                        <th>Nº Con</th>
                        <th>Nº Men</th>
                        <th>Nome do Aluno</th>
                        <th>Nome do Resp.</th>
                        <th>Mês</th>
                        <th>Data de Venc</th>
                        <th>Data do Pag</th>
                        <th>Valor</th>
                        <th>Multa</th>
                        <th>Desconto</th>
                        <th>Total</th>
                        <th>Status</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Nº Con</th>
                        <th>Nº Men</th>
                        <th>Nome do Aluno</th>
                        <th>Nome do Resp.</th>
                        <th>Mês</th>
                        <th>Data de Venc</th>
                        <th>Data do Pag</th>
                        <th>Valor</th>
                        <th>Multa</th>
                        <th>Desconto</th>
                        <th>Total</th>
                        <th>Status</th>
                        <th>Opções</th>
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
                                            <td>${men.contrato.idcontrato}</td>
                                            <td>${men.idmensalidade}</td>
                                            <td>${men.contrato.aluno.nome}</td>
                                            <td>${men.contrato.aluno.responsavel.nome}</td>
                                            <td>${men.mes}</td>
                                            <td>${men.datav}</td>
                                            <td>${men.datap}</td>
                                            <td>R$${men.valor}</td>
                                            <td>R$${men.multa}</td>
                                            <td>R$${men.desconto}</td>
                                            <td>R$${men.valor + men.multa - men.desconto}</td>
                                            <td>
                                                <c:if test="${men.status == 2}" > Pendente </c:if>
                                                <c:if test="${men.status == 1}" > Pago </c:if>
                                                </td>
                                                <td>
                                                    <a class="btn btn-primary" 
                                                       href="gerenciar_mensalidade.do?acao=alterar&idcontrato=${men.contrato.idcontrato}&idmensalidade=${men.idmensalidade}">
                                                    <i class="glyphicon glyphicon-pencil"></i>
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
