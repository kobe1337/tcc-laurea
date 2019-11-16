
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Contrato;
import DAO.ContratoDAO;


public class GerenciarContrato extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String mensagem="";
        
        int idcontrato = Integer.parseInt(request.getParameter("idcontrato"));
        String acao = request.getParameter("acao");
        
        
        try{
            Contrato con = new Contrato();
            ContratoDAO conDAO = new ContratoDAO();
            if(acao.equals("alterar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                con = conDAO.getCarregaPorId(idcontrato);
                if(con.getIdcontrato() > 0){
                    RequestDispatcher disp = 
                            getServletContext().getRequestDispatcher("/form_contrato.jsp");
                    request.setAttribute("contrato", con);
                    disp.forward(request, response);
                }else{
                    mensagem = "Contrato não encontrado";
                }
              }else{
                  mensagem = "Acesso negado";
              }  
            }
            
            if(acao.equals("desativar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                con.setIdcontrato(idcontrato);
                if(conDAO.desativar(con)){
                    mensagem = "Desativado com sucesso!";
                }else{
                    mensagem = "Erro ao desativar!";
                }
              }else{
                  mensagem ="Acesso negado";
              }  
            
            }
            
        
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_contrato.jsp';");
        out.println("</script>");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String idcontrato = request.getParameter("idcontrato");
        String datacontrato = request.getParameter("datacontrato");
        String preco = request.getParameter("preco");
        String parcela = request.getParameter("parcela");
        String status = request.getParameter("status");
        String escola = request.getParameter("escola");
        String serie = request.getParameter("serie");
        String idaluno = request.getParameter("aluno");
        
        String mensagem = "";
        
        Contrato con = new Contrato();
        if(!idcontrato.isEmpty()){
            con.setIdcontrato(Integer.parseInt(idcontrato));
        }
        try{
            
            ContratoDAO conDAO = new ContratoDAO();
            
            if(datacontrato.isEmpty() || preco.isEmpty() || parcela.isEmpty() 
                    || status.isEmpty() || serie.isEmpty() ){
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            }else{
            
                con.setDatacontrato(datacontrato);
                con.setPreco(Double.parseDouble(preco));
                con.setParcela(Integer.parseInt(parcela));
                con.setStatus(Integer.parseInt(status));
                con.setEscola(escola);
                con.setSerie(serie);
                
                Aluno a = new Aluno();
                a.setIdaluno(Integer.parseInt(idaluno));
                con.setAluno(a);
                
                if(conDAO.gravar(con)){
                    mensagem = "Gravado com sucesso";
                }else{
                    mensagem = "Erro ao gravar no banco";
                }
            }
        
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_contrato.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
