
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ProfessorDisciplinaDAO;


public class GerenciarProfessorDisciplina extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String mensagem="";
        String acao = request.getParameter("acao");
        
        String idprofessor = request.getParameter("idprofessor");
        String iddisciplina = request.getParameter("iddisciplina");
        
        try{
            ProfessorDisciplinaDAO aatiDAO = new ProfessorDisciplinaDAO();
            
            if(acao.equals("desvincular")){
              if(GerenciarLogin.verificarPermissao(request, response)){
                
               if(aatiDAO.desvincular(Integer.parseInt(idprofessor), Integer.parseInt(iddisciplina))){
                        mensagem = "Desvinculado com sucesso!";
                    }else{
                        mensagem = "Erro ao desvincular!";
                    }
                
              }else{
                  mensagem = "Acesso Negado";
              } 
            }
            
        
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar o comando";
        } 
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_professor_disciplina.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idprofessor = request.getParameter("nomeprofessor");
        String iddisciplina = request.getParameter("nomedisciplina");
        
        try{
            ProfessorDisciplinaDAO aatiDAO = new ProfessorDisciplinaDAO();
            
            if(idprofessor.isEmpty() || iddisciplina.isEmpty()){
                mensagem = "Campos obrigatórios deverão ser selecionados!";
            }else{
                if(aatiDAO.vincular(Integer.parseInt(idprofessor), Integer.parseInt(iddisciplina))){
                    mensagem = "Vinculado com sucesso!";
                }else{
                    mensagem = "Erro ao vincular!";
                }
            }
            
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar!";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_professor_disciplina.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
