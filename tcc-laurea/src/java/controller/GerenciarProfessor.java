
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Professor;
import DAO.ProfessorDAO;
import model.Usuario;


public class GerenciarProfessor extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String mensagem="";
        
        int idprofessor = Integer.parseInt(request.getParameter("idprofessor"));
        String acao = request.getParameter("acao");
        
        
        try{
            Professor pr = new Professor();
            ProfessorDAO prDAO = new ProfessorDAO();
            if(acao.equals("alterar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                pr = prDAO.getCarregaPorId(idprofessor);
                if(pr.getIdprofessor() > 0){
                    RequestDispatcher disp = 
                            getServletContext().getRequestDispatcher("/form_professor.jsp");
                    request.setAttribute("professor", pr);
                    disp.forward(request, response);
                }else{
                    mensagem = "Professor não encontrado";
                }
              }else{
                  mensagem = "Acesso negado";
              }  
            }
            
            if(acao.equals("desativar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                pr.setIdprofessor(idprofessor);
                if(prDAO.desativar(pr)){
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
        out.println("location.href='listar_professor.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String idprofessor = request.getParameter("idprofessor");
        String nome = request.getParameter("nome");
        String status = request.getParameter("status");
        String idusuario = request.getParameter("usuario");
        String mensagem = "";
        
        Professor pr = new Professor();
        if(!idprofessor.isEmpty()){
            pr.setIdprofessor(Integer.parseInt(idprofessor));
        }
        try{
            ProfessorDAO prDAO = new ProfessorDAO();
            if(nome.isEmpty() || status.isEmpty() || idusuario.isEmpty()){
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            }else{
                
                pr.setNome(nome);
                pr.setStatus(Integer.parseInt(status));
                
                Usuario u = new Usuario();
                u.setIdusuario(Integer.parseInt(idusuario));
                pr.setUsuario(u);
                
                if(prDAO.gravar(pr)){
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
        out.println("location.href='listar_professor.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
