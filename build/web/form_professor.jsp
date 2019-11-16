
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, 
              initial-scale=1, maximum-scale=1, 
              user-scalable=no"
              name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <title>Láurea Reforço Escolar</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <h3>Novo Professor</h3>
            
            <form action="gerenciar_professor.do" method="POST">
                
                <input type="hidden" name="idprofessor" id="idprofessor" value="${professor.idprofessor}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nome"> Nome </label>
                        <input type="text" class="form-control" id="nome"
                               name="nome" required="" maxlength="45"
                               value="${professor.nome}"/>
                    </div>    
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="status"> Status </label>
                        <select name="status" required="" class="form-control">
                            <c:if test="${professor.status !=1 && professor.status!=2}">
                                <option value=0 selected="" > Selecine a opção </option>
                                <option value=1> Ativado </option>
                                <option value=2> Desativado </option>
                            </c:if>
                            <c:if test="${professor.status==1}">
                                <option value=1 selected="" > Ativado </option>
                                <option value=2> Desativado </option>
                            </c:if>
                            <c:if test="${professor.status==2}">
                                <option value=1> Ativado </option>
                                <option value=2 selected="" > Desativado </option>
                            </c:if> 
                        </select>    
                    </div>    
                </div>
                              
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="usuario"> Nome de Usuário </label>
                        <select name="usuario" required="" class="form-control">
                              <option value="">Selecine a opção</option>
                              <jsp:useBean class="DAO.UsuarioDAO" id="uDAO"/>
                              <c:forEach var="u" items="${uDAO.lista}">
                                  <c:if test="${u.status == 1}" >
                                  <option value="${u.idusuario}"
                                          <c:if test="${u.idusuario==professor.usuario.idusuario}">
                                              selected=""
                                          </c:if> 
                                  >
                                      ${u.nome}</option>
                                  </c:if>
                              </c:forEach>
                        </select>    
                    </div>    
                </div>
                    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_professor.jsp" class="btn btn-warning">
                        Voltar
                    </a>    
                </div>    
            </form>    
            
        </div>
        
    </body>
</html>
