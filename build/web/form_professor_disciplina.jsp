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
            <h3>Novo Vínculo Professore / Disciplina</h3>
            
            <form action="gerenciar_professor_disciplina.do" method="POST">
                
                <jsp:useBean class="DAO.DisciplinaDAO" id="diDAO"/>
                <jsp:useBean class="DAO.ProfessorDAO" id="prDAO"/>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nomeprofessor"> Professor </label>
                        <select name="nomeprofessor" required="" class="form-control">
                              <option value="">Selecine a opção</option>
                              <c:forEach var="pr" items="${prDAO.lista}">
                                  <c:if test="${pr.status == 1}" >
                                  <option value="${pr.idprofessor}">
                                      ${pr.nome} </option>
                                  </c:if>
                              </c:forEach>
                        </select>    
                    </div>    
                </div>
                              
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nomedisciplina"> Disciplina </label>
                        <select name="nomedisciplina" required="" class="form-control">
                              <option value="">Selecine a opção</option>
                              <c:forEach var="di" items="${diDAO.lista}">
                                  <option value="${di.iddisciplina}">
                                      ${di.materia}</option>
                              </c:forEach>
                        </select>    
                    </div>    
                </div>
                    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_professor_disciplina.jsp" class="btn btn-warning">
                        Voltar
                    </a>    
                </div>    
            </form>    
            
        </div>
        
    </body>
</html>
