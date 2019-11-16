
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Professor;
import model.Turma;
import DAO.TurmaDAO;


public class GerenciarTurma extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        int idturma = Integer.parseInt(request.getParameter("idturma"));
        String acao = request.getParameter("acao");
        String mensagem="";
        Turma tu = new Turma();
        try{
            TurmaDAO tuDAO = new TurmaDAO();
            if(acao.equals("alterar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                tu = tuDAO.getCarregaPorId(idturma);
                if(tu.getIdturma() > 0){
                    RequestDispatcher disp = 
                            getServletContext().getRequestDispatcher("/form_turma.jsp");
                    request.setAttribute("turma", tu);
                    disp.forward(request, response);
                }else{
                    mensagem = "Turma não encontrado";
                }
              }else{
                  mensagem = "Acesso negado";
              }  
            }
            
            if(acao.equals("excluir")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                tu.setIdturma(idturma);
                if(tuDAO.excluir(tu)){
                    mensagem = "Excluído com sucesso!";
                }else{
                    mensagem = "Erro ao excluir!";
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
        out.println("location.href='listar_turma.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String idturma = request.getParameter("idturma");
        String nome = request.getParameter("nome");
        String idprofessor = request.getParameter("idprofessor");
        String mensagem = "";
        
        Turma tu = new Turma();
        if(!idturma.isEmpty()){
            tu.setIdturma(Integer.parseInt(idturma));
        }
        try{
            TurmaDAO tuDAO = new TurmaDAO();
            if(nome.isEmpty() || idprofessor.isEmpty()){
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            }else{
                
                tu.setNome(nome);
                
                Professor pr = new Professor();
                pr.setIdprofessor(Integer.parseInt(idprofessor));
                tu.setProfessor(pr);
                
                
                if(tuDAO.gravar(tu)){
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
        out.println("location.href='listar_turma.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
