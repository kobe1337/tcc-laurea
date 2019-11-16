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
            <h3>Nova Turma</h3>
            
            <form action="gerenciar_turma.do" method="POST">
                
                <input type="hidden" name="idturma" id="idturma" value="${turma.idturma}"/>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nome"> Nome da Turma </label>
                        <input type="text" class="form-control" id="nome"
                               name="nome" required="" maxlength="45"
                               value="${turma.nome}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="professor"> Professor </label>
                        <select name="idprofessor" required="" class="form-control">
                              <option value="">Selecine a opção</option>
                              <jsp:useBean class="DAO.ProfessorDAO" id="prDAO"/>
                              
                              <c:forEach var="pr" items="${prDAO.lista}">
                                  <c:if test="${ulogado.nome == pr.usuario.nome
                                        || ulogado.perfil == 'Administrador(a)' 
                                        ||  ulogado.perfil == 'Secretário(a)'}">
                                  <c:if test = "${pr.status == 1}" >
                                  <option value="${pr.idprofessor}"
                                          <c:if test="${pr.idprofessor==turma.professor.idprofessor}">
                                              selected=""
                                          </c:if> 
                                  >
                                      ${pr.nome}</option>
                                  </c:if>
                                  </c:if>
                              </c:forEach>
                              
                                  
                        </select>    
                    </div>    
                </div>
                    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_turma.jsp" class="btn btn-warning">
                        Voltar
                    </a>    
                </div>    
            </form>    
            
        </div>
        
    </body>
</html>
