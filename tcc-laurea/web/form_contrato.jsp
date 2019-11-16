
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, 
              user-scalable=no" name="viewport"/>
       <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <title>Láurea Reforço Escolar</title>
    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h3>Novo Contrato</h3>
            
            <form action="gerenciar_contrato.do" method="POST">
                
                <input type="hidden" name="idcontrato" id="idcontrato" value="${contrato.idcontrato}"/>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="datacontrato"> Data do Contrato </label>
                        <input type="date" class="form-control" id="datacontrato"
                               name="datacontrato" required="" maxlength="45"
                               value="${contrato.datacontrato}"/>
                    </div>    
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="preco"> Preço </label>
                        <input type="text" class="form-control" id="preco"
                               name="preco" required="" maxlength="45"
                               value="${contrato.preco}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="parcela"> Número de Parcelas </label>
                        <input type="text" class="form-control" id="parcela"
                               name="parcela" required="" maxlength="45"
                               value="${contrato.parcela}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="status"> Status </label>
                        <select name="status" required="" class="form-control">
                            <c:if test="${contrato.status !=1 && contrato.status!=2}">
                                <option value=0 selected="" > Selecine a opção </option>
                                <option value=1> Ativado </option>
                                <option value=2> Desativado </option>
                            </c:if>
                            <c:if test="${contrato.status==1}">
                                <option value=1 selected="" > Ativado </option>
                                <option value=2> Desativado </option>
                            </c:if>
                            <c:if test="${contrato.status==2}">
                                <option value=1> Ativado </option>
                                <option value=2 selected="" > Desativado </option>
                            </c:if> 
                        </select>    
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="serie"> Ano (Série) </label>
                        <input type="text" class="form-control" id="serie"
                               name="serie" required="" maxlength="45"
                               value="${contrato.serie}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="escola"> Escola onde estuda </label>
                        <input type="text" class="form-control" id="escola"
                               name="escola" required="" maxlength="45"
                               value="${contrato.escola}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="aluno"> Aluno </label>
                        <select name="aluno" required="" class="form-control">
                              <option value="">Selecine a opção</option>
                              <jsp:useBean class="DAO.AlunoDAO" id="aDAO"/>
                              <c:forEach var="a" items="${aDAO.lista}">
                                  <c:if test="${a.status == 1}" >
                                  <option value="${a.idaluno}"
                                          <c:if test="${a.idaluno==contrato.aluno.idaluno}">
                                              selected=""
                                          </c:if> 
                                  >
                                      ${a.nome}</option>
                                  </c:if>
                              </c:forEach>
                        </select>    
                    </div>    
                </div>
                    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_contrato.jsp" class="btn btn-warning">
                        Voltar
                    </a>    
                </div>    
            </form>    
            
        </div>
        
    </body>
</html>
