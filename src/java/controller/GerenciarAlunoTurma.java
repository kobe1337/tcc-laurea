package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AlunoTurma;
import DAO.AlunoTurmaDAO;

public class GerenciarAlunoTurma extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem="";
        String acao = request.getParameter("acao");
        
        String idaluno = request.getParameter("idaluno");
        String idturma = request.getParameter("idturma");
        
        try{
            AlunoTurmaDAO atuDAO = new AlunoTurmaDAO();
            AlunoTurma atu = new AlunoTurma();
            
            if(acao.equals("desvincular")){
              if(GerenciarLogin.verificarPermissao(request, response)){
                
               if(atuDAO.desvincular(Integer.parseInt(idaluno), Integer.parseInt(idturma))){
                        mensagem = "Desvinculado com sucesso!";
                    }else{
                        mensagem = "Erro ao desvincular!";
                    }
                
              }else{
                  mensagem = "Acesso Negado";
              } 
            }
            
            if(acao.equals("alterar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                atu = atuDAO.getCarregaPorId(Integer.parseInt(idaluno), Integer.parseInt(idturma));
                if(atu.getAluno().getIdaluno() > 0){
                    RequestDispatcher disp = 
                            getServletContext().getRequestDispatcher("/form_aluno_turma.jsp");
                    request.setAttribute("alunoturma", atu);
                    disp.forward(request, response);
                }else{
                    mensagem = "Atividade não encontrado";
                }
              }else{
                  mensagem = "Acesso negado";
              }  
            }
            
        
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar o comando";
        } 
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_aluno_turma.jsp';");
        out.println("</script>");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idaluno = request.getParameter("idaluno");
        String idturma = request.getParameter("idturma");
        String data = request.getParameter("data");
        String frequencia = request.getParameter("frequencia");

        try {
            AlunoTurmaDAO atuDAO = new AlunoTurmaDAO();
            if (frequencia.equals("--")) {
                if (idaluno.isEmpty() || idturma.isEmpty() || data.isEmpty() || frequencia.isEmpty()) {
                    mensagem = "Campos obrigatórios deverão ser selecionados!";
                } else {
                    if (atuDAO.vincular(Integer.parseInt(idaluno), Integer.parseInt(idturma), data, frequencia)) {
                        mensagem = "Vinculado com sucesso!";
                    } else {
                        mensagem = "Erro ao vincular!";
                    }
                }
            } else {

                if (idaluno.isEmpty() || idturma.isEmpty() || data.isEmpty() || frequencia.isEmpty()) {
                    mensagem = "Campos obrigatórios deverão ser selecionados!";
                } else {
                    if (atuDAO.fazerChamada(data, frequencia, Integer.parseInt(idaluno), Integer.parseInt(idturma))) {
                        mensagem = "Realizado com sucesso!";
                    } else {
                        mensagem = "Erro ao realizar!";
                    }
                }

            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar!";
        }

        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_aluno_turma.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
