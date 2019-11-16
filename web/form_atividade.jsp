
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
            <h3>Nova Atividade</h3>
            
            <form action="gerenciar_atividade.do" method="POST" enctype="multipart/form-data" >
                
                <input type="hidden" name="idatividade" id="idatividade" value="${atividade.idatividade}"/>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nome"> Nome </label>
                        <input type="text" class="form-control" id="nome"
                               name="nome" required="" maxlength="45"
                               value="${atividade.nome}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="arquivo"> Arquivo </label>
                        <input type="file" class="form-control" id="arquivo"
                               name="arquivo" required=""/>
                    </div>    
                </div>
                    
                <jsp:useBean class="DAO.DisciplinaDAO" id="diDAO"/>
                <jsp:useBean class="DAO.ProfessorDAO" id="prDAO"/>
                <jsp:useBean class="DAO.ProfessorDisciplinaDAO" id="pdDAO"/>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="disciplina"> Disciplina </label>
                        <select name="disciplina" required="" class="form-control">
                              <option value="">Selecine a opção</option>
                              <c:forEach var="di" items="${diDAO.lista}">
                              <c:forEach var="pr" items="${prDAO.lista}">
                              <c:forEach var="pd" items="${pdDAO.lista}">
                                  <c:if test="${ulogado.nome == pr.usuario.nome
                                        || ulogado.perfil == 'Administrador(a)' 
                                        ||  ulogado.perfil == 'Secretário(a)'}">
                                  <c:if test="${ di.iddisciplina == pd.disciplina.iddisciplina && 
                                                 pr.idprofessor == pd.professor.idprofessor}">
                                  <option value="${di.iddisciplina}"
                                          <c:if test="${di.iddisciplina==atividade.disciplina.iddisciplina}">
                                              selected=""
                                          </c:if> >
                                      ${di.materia}</option>
                                  </c:if>
                                  </c:if>
                              </c:forEach>
                              </c:forEach>
                              </c:forEach>
                        </select>    
                    </div>    
                </div>
                    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_atividade.jsp" class="btn btn-warning">
                        Voltar
                    </a>    
                </div>    
            </form>    
            
        </div>
        
    </body>
</html>
