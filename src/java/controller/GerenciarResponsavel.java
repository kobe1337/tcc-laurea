package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Responsavel;
import DAO.ResponsavelDAO;
import model.Usuario;

public class GerenciarResponsavel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";

        int idresponsavel = Integer.parseInt(request.getParameter("idresponsavel"));
        String acao = request.getParameter("acao");

        try {
            Responsavel res = new Responsavel();
            ResponsavelDAO resDAO = new ResponsavelDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    res = resDAO.getCarregaPorId(idresponsavel);
                    if (res.getIdresponsavel() > 0) {
                        RequestDispatcher disp
                                = getServletContext().getRequestDispatcher("/form_responsavel.jsp");
                        request.setAttribute("responsavel", res);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Responsavel não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            if (acao.equals("desativar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    res.setIdresponsavel(idresponsavel);
                    if (resDAO.desativar(res)) {
                        mensagem = "Desativado com sucesso!";
                    } else {
                        mensagem = "Erro ao desativar!";
                    }
                } else {
                    mensagem = "Acesso negado";
                }

            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_responsavel.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idresponsavel = request.getParameter("idresponsavel");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String status = request.getParameter("status");
        String idusuario = request.getParameter("usuario");
        String mensagem = "";

        Responsavel res = new Responsavel();
        if (!idresponsavel.isEmpty()) {
            res.setIdresponsavel(Integer.parseInt(idresponsavel));
        }
        try {
            ResponsavelDAO resDAO = new ResponsavelDAO();
            if (nome.isEmpty() || cpf.isEmpty() || status.isEmpty() || idusuario.isEmpty()) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {

                res.setNome(nome);
                res.setCpf(cpf);
                res.setRg(rg);
                res.setStatus(Integer.parseInt(status));

                Usuario u = new Usuario();
                u.setIdusuario(Integer.parseInt(idusuario));
                res.setUsuario(u);

                if (resDAO.gravar(res)) {
                    mensagem = "Gravado com sucesso";
                } else {
                    mensagem = "Erro ao gravar no banco";
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_responsavel.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
