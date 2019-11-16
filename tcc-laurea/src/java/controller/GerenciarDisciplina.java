
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disciplina;
import DAO.DisciplinaDAO;


public class GerenciarDisciplina extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        int iddisciplina = Integer.parseInt(request.getParameter("iddisciplina"));
        String acao = request.getParameter("acao");
        String mensagem="";
        Disciplina di = new Disciplina();
        try{
            DisciplinaDAO diDAO = new DisciplinaDAO();
            if(acao.equals("alterar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                di = diDAO.getCarregaPorId(iddisciplina);
                if(di.getIddisciplina() > 0){
                    RequestDispatcher disp = 
                            getServletContext().getRequestDispatcher("/form_disciplina.jsp");
                    request.setAttribute("disciplina", di);
                    disp.forward(request, response);
                }else{
                    mensagem = "Disciplina não encontrado";
                }
              }else{
                  mensagem = "Acesso negado";
              }  
            }
            
            if(acao.equals("excluir")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                di.setIddisciplina(iddisciplina);
                if(diDAO.excluir(di)){
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
        out.println("location.href='listar_disciplina.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String iddisciplina = request.getParameter("iddisciplina");
        String materia = request.getParameter("materia");
        String mensagem = "";
        
        Disciplina di = new Disciplina();
        if(!iddisciplina.isEmpty()){
            di.setIddisciplina(Integer.parseInt(iddisciplina));
        }
        try{
            DisciplinaDAO diDAO = new DisciplinaDAO();
            if(materia.isEmpty()){
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            }else{
                di.setMateria(materia);
                if(diDAO.gravar(di)){
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
        out.println("location.href='listar_disciplina.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
