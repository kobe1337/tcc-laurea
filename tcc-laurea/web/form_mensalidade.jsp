
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
            <h3>Nova Mensalidade</h3>
            
            <form action="gerenciar_mensalidade.do" method="POST">
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="contrato"> Código do contrato vinculado </label>
                        <select name="contrato" required="" class="form-control">
                              <option value="">Selecine a opção</option>
                              <jsp:useBean class="DAO.ContratoDAO" id="conDAO"/>
                              <c:forEach var="con" items="${conDAO.lista}">
                                  <c:if test="${con.status == 1}" >
                                  <option value="${con.idcontrato}"
                                          <c:if test="${con.idcontrato==mensalidade.contrato.idcontrato}">
                                              selected=""
                                          </c:if> 
                                  >
                                      ${con.idcontrato} &nbsp (${con.aluno.nome})</option>
                                  </c:if>
                              </c:forEach>
                        </select>    
                    </div>    
                </div>
                              
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="mensalidade"> Número da Mensalidade </label>
                        <input type="text" class="form-control" id="mensalidade"
                               name="mensalidade" required="" maxlength="45"
                               value="${mensalidade.idmensalidade}"/>
                    </div>    
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="mes"> Mês </label>
                        <input type="text" class="form-control" id="mes"
                               name="mes" required="" maxlength="45"
                               value="${mensalidade.mes}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="datav"> Data de Vencimento </label>
                        <input type="date" class="form-control" id="datav"
                               name="datav" required="" maxlength="45"
                               value="${mensalidade.datav}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="datap"> Data de Pagamento </label>
                        <input type="date" class="form-control" id="datap"
                               name="datap" required="" maxlength="45"
                               value="${mensalidade.datap}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="valor"> Valor </label>
                        <input type="text" class="form-control" id="valor"
                               name="valor" required="" maxlength="45"
                               value="${mensalidade.valor}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="multa"> Multa </label>
                        <input type="text" class="form-control" id="multa"
                               name="multa" required="" maxlength="45"
                               value="${mensalidade.multa}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="desconto"> Desconto </label>
                        <input type="text" class="form-control" id="desconto"
                               name="desconto" required="" maxlength="45"
                               value="${mensalidade.desconto}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="status"> Status </label>
                        <select name="status" required="" class="form-control">
                            <c:if test="${mensalidade.status !=1 && mensalidade.status!=2}">
                                <option value=0 selected="" > Selecine a opção </option>
                                <option value=1> Pago </option>
                                <option value=2> Pendente </option>
                            </c:if>
                            <c:if test="${mensalidade.status==1}">
                                <option value=1 selected="" > Pago </option>
                                <option value=2> Pendente </option>
                            </c:if>
                            <c:if test="${mensalidade.status==2}">
                                <option value=1> Pago </option>
                                <option value=2 selected="" > Pendente </option>
                            </c:if> 
                        </select>    
                    </div>    
                </div>
                    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_mensalidade.jsp" class="btn btn-warning">
                        Voltar
                    </a>    
                </div>    
            </form>    
            
        </div>
        
    </body>
</html>
