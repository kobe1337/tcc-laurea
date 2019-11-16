
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import DAO.AlunoDAO;
import model.Responsavel;
import model.Usuario;


public class GerenciarAluno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String mensagem="";
        
        int idaluno = Integer.parseInt(request.getParameter("idaluno"));
        String acao = request.getParameter("acao");
        
        
        try{
            Aluno a = new Aluno();
            AlunoDAO aDAO = new AlunoDAO();
            if(acao.equals("alterar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                a = aDAO.getCarregaPorId(idaluno);
                if(a.getIdaluno() > 0){
                    RequestDispatcher disp = 
                            getServletContext().getRequestDispatcher("/form_aluno.jsp");
                    request.setAttribute("aluno", a);
                    disp.forward(request, response);
                }else{
                    mensagem = "Aluno não encontrado";
                }
              }else{
                  mensagem = "Acesso negado";
              }  
            }
            
           if(acao.equals("desativar")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                a.setIdaluno(idaluno);
                if(aDAO.desativar(a)){
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
        out.println("location.href='listar_aluno.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String idaluno = request.getParameter("idaluno");
        String nome = request.getParameter("nome");
        String datanasc = request.getParameter("datanasc");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String status = request.getParameter("status");
        String idresponsavel = request.getParameter("responsavel");
        String idusuario = request.getParameter("usuario");
        String mensagem = "";
        
        Aluno a = new Aluno();
        if(!idaluno.isEmpty()){
            a.setIdaluno(Integer.parseInt(idaluno));
        }
        try{
            AlunoDAO aDAO = new AlunoDAO();
            if(nome.isEmpty() || status.isEmpty() || idresponsavel.isEmpty() 
                    ||idusuario.isEmpty()){
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            }else{
                
                a.setNome(nome);
                a.setDatanasc(datanasc);
                a.setCpf(cpf);
                a.setRg(rg);
                a.setStatus(Integer.parseInt(status));
                
                Responsavel res = new Responsavel();
                res.setIdresponsavel(Integer.parseInt(idresponsavel));
                a.setResponsavel(res);
                
                Usuario u = new Usuario();
                u.setIdusuario(Integer.parseInt(idusuario));
                a.setUsuario(u);
                
                
                if(aDAO.gravar(a)){
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
        out.println("location.href='listar_aluno.jsp';");
        out.println("</script>");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
