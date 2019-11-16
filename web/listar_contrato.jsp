

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
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_listas.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
        <title>Listar Contrato</title>

        <script type="text/javascript">

            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente desativar o contrato do(a) aluno(a) ' + nome + ' ?')) {
                    location.href = 'gerenciar_contrato.do?acao=desativar&idcontrato=' + id;
                }
            }
        </script>

    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
        <div class="row">
            <a href="form_contrato.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Cadastrar Contrato</div></a>
        </div>

        <div class="row  justify-content-center" id="listagem">

            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped"
                       id ="listaContrato" >

                    <thead>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Aluno</th>            
                            <th style="text-align: center;">Data</th>
                            <th style="text-align: center;">Valor</th>
                            <th style="text-align: center;">Qtd. Parcelas</th>
                            <th style="text-align: center;">Status</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Aluno</th>            
                            <th style="text-align: center;">Data</th>
                            <th style="text-align: center;">Valor</th>
                            <th style="text-align: center;">Qtd. Parcelas</th>
                            <th style="text-align: center;">Status</th>
                            <th style="text-align: center;">Editar</th>
                            <th style="text-align: center;">Excluir</th>
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
                                                <td style="text-align: center;">${con.idcontrato}</td>
                                                <td>${con.aluno.nome}</td>
                                                <td style="text-align: center;">${con.datacontrato}</td>
                                                <td style="text-align: center;">R$${con.preco}</td>
                                                <td style="text-align: center;">${con.parcela}</td>
                                                <td style="text-align: center;">
                                                    <c:if test="${con.status == 2}" > Desativado </c:if>
                                                    <c:if test="${con.status == 1}" > Ativado </c:if>
                                                    </td>
                                                    <td style="text-align: center;">
                                                        <a class="icone_lista" href="gerenciar_contrato.do?acao=alterar&idcontrato=${con.idcontrato}">
                                                        <img src="assets/img/lista/editar.png">
                                                    </a>
                                                </td>
                                                <td style="text-align: center;">
                                                    <button class="deletar icone_lista" onclick="confirmarExclusao(${con.idcontrato}, '${con.aluno.nome}')" >
                                                        <img src="assets/img/lista/deletar.png">
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
        </div>

        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
        <script type="text/javascript">
                                                        $(document).ready(function () {
                                                            $("#listaContrato").dataTable({
                                                                "bJQueryUI": true,
                                                                "oLanguage": {
                                                                    "sProcessing": "Processando...",
                                                                    "sLengthMenu": "MOSTRAR _MENU_",
                                                                    "sZeroRecords": "Não foram encontrados resultados",
                                                                    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                                                    "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                                                                    "sInfoFiltered": "",
                                                                    "sInfoPostFix": "",
                                                                    "sSearch": "PESQUISAR",
                                                                    "sUrl": "",
                                                                    "oPaginate": {
                                                                        "sFirst": "Primeiro",
                                                                        "sPrevious": "Anterior",
                                                                        "sNext": "Próximo",
                                                                        "sLast": "Último"
                                                                    }
                                                                }
                                                            })
                                                        });
        </script>            
    </body>
</html>
