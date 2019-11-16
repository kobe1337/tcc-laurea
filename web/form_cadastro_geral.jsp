
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, 
              user-scalable=no" name="viewport"/>
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_form.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  

        <title>Láurea Reforço Escolar</title>
    </head>
    <body class="">
        <%@include file="menu.jsp" %>


        <nav class="container" style="padding: 20px 150px;">
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Aluno</a>
                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Responsável</a>
                <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Contrato</a>
                <a class="nav-item nav-link" id="nav-mensalidade-tab" data-toggle="tab" href="#nav-mensalidade" role="tab" aria-controls="nav-mensalidade" aria-selected="false">Mensalidade</a>
            </div>
        </nav>


        <div class="div_formulario">
            
            <form action="gerenciar_cadastro_geral.do" method="POST" class="form">
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <h3 class="titulo"> Dados do Aluno </h3>

                        <div class="row">
                            <div class="form-group col-md-6 mb-3">
                                <label for="nome_al"> Nome </label>
                                <input type="text" class="form-control" id="nome_al"
                                       name="nome_al" required="" maxlength="45"/>
                            </div>  
                            <div class="form-group col-md-6 mb-3">           
                                <label for="datanasc_al"> Data de Nascimento </label>
                                <input type="date" class="form-control" id="datanasc_al"
                                       name="datanasc_al" required="" maxlength="45"/>
                            </div>    
                        </div>   


                        <div class="row">
                            <div class="form-group col-md-4 mb-3">
                                <label for="cpf_al"> CPF </label>
                                <input type="text" class="form-control" id="cpf_al"
                                       name="cpf_al" maxlength="45"/>
                            </div>    



                            <div class="form-group col-md-4 mb-3">
                                <label for="rg_al"> RG </label>
                                <input type="text" class="form-control" id="rg_al"
                                       name="rg_al" maxlength="45"/>
                            </div>    



                            <div class="form-group col-md-4 mb-3">
                                <label for="status_al"> Status do Aluno </label>
                                <select name="status_al" required="" class="form-control">
                                    <option value=0 selected="" > Selecine a opção </option>
                                    <option value=1> Ativado </option>
                                    <option value=2> Desativado </option>
                                </select>    
                            </div>    
                        </div>  


                        <div class="row">
                            <div class="form-group col-md-4 mb-3"> 
                                <label for="nome_u_al"> Nome (Usuário) </label>
                                <input type="text" class="form-control" id="nome_u_al"
                                       name="nome_u_al" required="" maxlength="45"/>
                            </div>    



                            <div class="form-group col-md-4 mb-3">
                                <label for="login_al"> Login </label>
                                <input type="text" class="form-control" id="login_al"
                                       name="login_al" required="" maxlength="45"/>
                            </div>    




                            <div class="form-group col-md-4 mb-3">
                                <label for="senha_al"> Senha </label>
                                <input type="password" class="form-control" id="senha_al"
                                       name="senha_al" maxlength="45" required=""/>
                            </div>   
                        </div>  



                        <div class="row">
                            <div class="form-group col-md-6 mb-3"> 
                                <label for="status_u_al"> Status de Usuário do Aluno </label>
                                <select name="status_u_al" required="" class="form-control">
                                    <option value="">Selecine a opção</option>
                                    <option value="1">Ativado</option>
                                    <option value="2">Desativado</option>
                                </select>    
                            </div>    

                            <div class="form-group col-md-6 mb-3"> 
                                <label for="perfil_al"> Perfil de Usuário do Aluno </label>
                                <select name="perfil_al" required="" class="form-control">
                                    <option value="">Selecine a opção</option>
                                    <jsp:useBean class="DAO.PerfilDAO" id="pDAO"/>
                                    <c:forEach var="p" items="${pDAO.lista}">
                                        <c:if test="${p.perfil == 'Aluno(a)' || p.perfil == 'Responsável'}">
                                            <option 

                                                <c:if test="${p.perfil == 'Aluno(a)'}" > selected="" </c:if>

                                                    value="${p.idperfil}"> ${p.perfil} </option>
                                        </c:if>
                                    </c:forEach>
                                </select>    
                            </div>   
                        </div>  
                    </div>

                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <h3 class="titulo"> Dados do Responsável </h3>


                        <div class="row">
                            <div class="form-group col-md-6 mb-3">
                                <label for="nome_res"> Nome </label>
                                <input type="text" class="form-control" id="nome_res"
                                       name="nome_res" required="" maxlength="45"/>
                            </div>    

                            <div class="form-group col-md-3 mb-3">
                                <label for="cpf_res"> CPF </label>
                                <input type="text" class="form-control" id="cpf_res"
                                       name="cpf_res" required="" maxlength="45"/>
                            </div>  


                            <div class="form-group col-md-3 mb-3">
                                <label for="rg_res"> RG </label>
                                <input type="text" class="form-control" id="rg_res"
                                       name="rg_res" required="" maxlength="45"/>
                            </div> 
                        </div>

                        <div class="row">
                            <div class="form-group col-md-3 mb-3">
                                <label for="status_res"> Status do Responsável </label>
                                <select name="status_res" required="" class="form-control">
                                    <option value=0 selected="" > Selecine a opção </option>
                                    <option value=1> Ativado </option>
                                    <option value=2> Desativado </option>
                                </select>    
                            </div>    

                            <div class="form-group col-md-3 mb-3">
                                <label for="nome_u_res"> Nome (Usuário) </label>
                                <input type="text" class="form-control" id="nome_u_res"
                                       name="nome_u_res" required="" maxlength="45"/>
                            </div>    

                            <div class="form-group col-md-3 mb-3">
                                <label for="login_res"> Login </label>
                                <input type="text" class="form-control" id="login_res"
                                       name="login_res" required="" maxlength="45"/>
                            </div>    

                            <div class="form-group col-md-3 mb-3">
                                <label for="senha_res"> Senha </label>
                                <input type="password" class="form-control" id="senha_res"
                                       name="senha_res" maxlength="45" required=""/>
                            </div>  
                        </div>  

                        <div class="row">
                            <div class="form-group col-md-6 mb-3">
                                <label for="status_u_res"> Status de Usuário do Responsável</label>
                                <select name="status_u_res" required="" class="form-control">
                                    <option value="">Selecine a opção</option>
                                    <option value="1"> Ativado </option>
                                    <option value="2"> Desativado </option>
                                </select>    
                            </div>    



                            <div class="form-group col-md-6 mb-3">
                                <label for="perfil_res"> Perfil de Usuário do Responsável </label>
                                <select name="perfil_res" required="" class="form-control">
                                    <option value="">Selecine a opção</option>
                                    <c:forEach var="p" items="${pDAO.lista}">
                                        <c:if test="${p.perfil == 'Responsável'}">
                                            <option 

                                                <c:if test="${p.perfil == 'Responsável'}" > selected="" </c:if>

                                                    value="${p.idperfil}"> ${p.perfil} </option>
                                        </c:if>
                                    </c:forEach>
                                </select>    
                            </div>  
                        </div>


                    </div>
                    <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                        <h3 class="titulo"> Dados do Contrato </h3>

                        <div class="row">
                            <div class="form-group col-md-4 mb-3">
                                <label for="datacontrato"> Data do Contrato </label>
                                <input type="date" class="form-control" id="datacontrato"
                                       name="datacontrato" required="" maxlength="45"/>
                            </div>    


                            <div class="form-group col-md-4 mb-3">
                                <label for="qtd_parcelas"> Número de Parcelas </label>
                                <input type="text" class="form-control" id="qtd_parcelas"
                                       name="qtd_parcelas" required="" maxlength="45"/>
                            </div>    
                        </div>

                        <div class="row">
                            <div class="form-group col-sm-8">
                                <label for="status_con"> Status do Contrato</label>
                                <select name="status_con" required="" class="form-control">
                                    <option value=0 selected="" > Selecine a opção </option>
                                    <option value=1> Ativado </option>
                                    <option value=2> Desativado </option>
                                </select>    
                            </div>    
                        </div>

                        <div class="row">
                            <div class="form-group col-sm-8">
                                <label for="serie"> Ano (Série) que o aluno(a) está cursando</label>
                                <input type="text" class="form-control" id="serie"
                                       name="serie" required="" maxlength="45"/>
                            </div>    
                        </div>

                        <div class="row">
                            <div class="form-group col-sm-8">
                                <label for="escola"> Escola onde estuda </label>
                                <input type="text" class="form-control" id="escola"
                                       name="escola" required="" maxlength="45"/>
                            </div>    
                        </div>
                    </div>
                    <div class="tab-pane fade" id="nav-mensalidade" role="tabpanel" aria-labelledby="nav-mensalidade-tab">

                        <h3 class="titulo"> Dados de Mensalidades </h3>

                        <div class="row">
                            <div class="form-group col-md-4 mb-3">
                                <label for="mes_i"> Mês Inicial </label>
                                <select name="mes_i" required="" class="form-control">
                                    <option value="">Selecine a opção</option>
                                    <option value="1">   Janeiro   </option>
                                    <option value="2">   Fevereiro </option>
                                    <option value="3">   Março     </option>
                                    <option value="4">   Abril     </option>
                                    <option value="5">   Maio      </option>
                                    <option value="6">   Junho     </option>
                                    <option value="7">   Julho     </option>
                                    <option value="8">   Agosto    </option>
                                    <option value="9">   Setembro  </option>
                                    <option value="10">  Outubro   </option>
                                    <option value="11">  Novembro  </option>
                                    <option value="12">  Dezembro  </option>
                                </select>    
                            </div>    


                            <div class="form-group col-md-4 mb-3">
                                <label for="datav"> Data de Vencimento </label>
                                <input type="date" class="form-control" id="datav"
                                       name="datav" required="" maxlength="45"/>
                            </div>    
                        </div>

                        <div class="row">
                            <div class="form-group col-md-4 mb-3">
                                <label for="valor_men"> Valor de cada Mensalidade </label>
                                <input type="text" class="form-control" id="desconto"
                                       name="valor_men" required="" maxlength="45"/>
                            </div>    
                            <div class="form-group col-md-4 mb-3">
                                <label for="desconto_men"> Desconto em cada Mensalidade</label>
                                <input type="text" class="form-control" id="desconto"
                                       name="desconto_men" required="" maxlength="45"/>
                            </div>    
                        </div>


                        <button class="btn btn-primary">Gravar</button>
                        <a href="index.jsp" class="btn btn-outline-dark">
                            Voltar
                        </a> 
                    </div>
                </div>
            </form>
        </div>  




    </div>
    <!-- animações de entrada na página -->
    <script type="text/javascript" src="assets/js/simple-anime.js"></script>

    <!-- Slide deve ser colado em toda pagina de HTML  -->
    <script type="text/javascript" src="assets/js/simple-slide.js"></script>


    <!-- Jquery 3.4.1 e bootstrap -->
    <script type="text/javascript" src="assets/js/jquery.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="assets/js/script.js"></script>
    <script type="text/javascript">
        $('#minhaAba a').on('click', function (e) {
            e.preventDefault()
            $(this).tab('show')
        })
    </script>



</body>
</html>
