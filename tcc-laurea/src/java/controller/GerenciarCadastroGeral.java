package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import DAO.CadastroGeralDAO;
import model.CadastroGeral;
import model.Contrato;
import model.Mensalidade;
import model.Responsavel;
import model.Usuario;
import model.Perfil;

public class GerenciarCadastroGeral extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String nome_al = request.getParameter("nome_al");
        String datanasc_al = request.getParameter("datanasc_al");
        String cpf_al = request.getParameter("cpf_al");
        String rg_al = request.getParameter("rg_al");
        String status_al = request.getParameter("status_al");
        String nome_u_al = request.getParameter("nome_u_al");
        String login_al = request.getParameter("login_al");
        String senha_al = request.getParameter("senha_al");
        String status_u_al = request.getParameter("status_u_al");
        String perfil_al = request.getParameter("perfil_al");
        String nome_res = request.getParameter("nome_res");
        String cpf_res = request.getParameter("cpf_res");
        String rg_res = request.getParameter("rg_res");
        String status_res = request.getParameter("status_res");
        String nome_u_res = request.getParameter("nome_u_res");
        String login_res = request.getParameter("login_res");
        String senha_res = request.getParameter("senha_res");
        String status_u_res = request.getParameter("status_u_res");
        String perfil_res = request.getParameter("perfil_res");
        String datacontrato = request.getParameter("datacontrato");
        String qtd_parcelas = request.getParameter("qtd_parcelas");
        String status_con = request.getParameter("status_con");
        String serie = request.getParameter("serie");
        String escola = request.getParameter("escola");
        String mes_i = request.getParameter("mes_i");
        String datav = request.getParameter("datav");
        String valor_men = request.getParameter("valor_men");
        String desconto_men = request.getParameter("desconto_men");

        String mensagem = "";

        Aluno a = new Aluno();
        Responsavel res = new Responsavel();
        Usuario u = new Usuario();
        Perfil p = new Perfil();
        Contrato con = new Contrato();
        Mensalidade men = new Mensalidade();

        try {
            CadastroGeral cg1, cg2, cg3, cg4, cg5 = new CadastroGeral();
            CadastroGeralDAO cgDAO = new CadastroGeralDAO();

            String t1, t2, t3, t4, t5, t6;

            if (nome_u_res.isEmpty()) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {

                // Aqui é gravado o Usuário do Responsável
                p.setIdperfil(Integer.parseInt(perfil_res));

                u.setPerfil(p);
                u.setNome(nome_u_res);
                u.setLogin(login_res);
                u.setSenha(senha_res);
                u.setStatus(Integer.parseInt(status_u_res));
                res.setUsuario(u);
                if (cgDAO.gravarUsuarioResponsavel(res)) {
                    t1 = "1";
                } else {
                    t1 = "0";
                }

                // Aqui é gravado o Usuário do Aluno
                p.setIdperfil(Integer.parseInt(perfil_al));

                u.setPerfil(p);
                u.setNome(nome_u_al);
                u.setLogin(login_al);
                u.setSenha(senha_al);
                u.setStatus(Integer.parseInt(status_u_al));
                a.setUsuario(u);
                if (cgDAO.gravarUsuarioAluno(a)) {
                    t2 = "1";
                } else {
                    t2 = "0";
                }

                // Aqui é puxado o Idusuario referente ao responsável
                cg1 = cgDAO.getCarregaPorIdUsuarioResp(nome_u_res);

                // Aqui é puxado o Idusuario referente ao aluno
                cg2 = cgDAO.getCarregaPorIdUsuarioAlun(nome_u_al);

                // Aqui é gravado o cadastro do Responsável
                res.setNome(nome_res);
                res.setCpf(cpf_res);
                res.setRg(rg_res);
                res.setStatus(Integer.parseInt(status_res));
                if (cgDAO.gravarResponsavel(res, cg1.getResponsavel().getUsuario().getIdusuario())) {
                    t3 = "1";
                } else {
                    t3 = "0";
                }

                // Aqui é puxado o Idresponsavel relativo ao responsável do aluno
                cg3 = cgDAO.getCarregaPorIdResponsavel(nome_res);

                // Aqui é gravado o cadastro do Aluno
                a.setNome(nome_al);
                a.setDatanasc(datanasc_al);
                a.setCpf(cpf_al);
                a.setRg(rg_al);
                a.setStatus(Integer.parseInt(status_al));
                if (cgDAO.gravarAluno(a, cg3.getResponsavel().getIdresponsavel(),
                        cg2.getAluno().getUsuario().getIdusuario())) {
                    t4 = "1";
                } else {
                    t4 = "0";
                }

                // Aqui é puxado o Idaluno relativo ao aluno, dono do contrato
                cg4 = cgDAO.getCarregaPorIdAlunoCon(nome_al, nome_res,
                        cg3.getResponsavel().getIdresponsavel());

                // Aqui se calcula o preço do contrato
                double preco = cgDAO.calcularPrecoCon(Double.parseDouble(valor_men),
                        Integer.parseInt(qtd_parcelas), Double.parseDouble(desconto_men));

                // Aqui é gravado o contrato do Aluno
                con.setDatacontrato(datacontrato);
                con.setParcela(Integer.parseInt(qtd_parcelas));
                con.setStatus(Integer.parseInt(status_con));
                con.setSerie(serie);
                con.setEscola(escola);
                if (cgDAO.gravarContrato(con, preco, cg4.getAluno().getIdaluno())) {
                    t5 = "1";
                } else {
                    t5 = "0";
                }

                // Aqui é puxado o Idcontrato relativo ao contrato gerado anteriormente
                cg5 = cgDAO.getCarregaPorIdContrato(cg4.getAluno().getIdaluno(),
                        cg3.getResponsavel().getIdresponsavel());

                // Aqui é gerada todas as Mensalidades
                if (cgDAO.gerarMensalidades(Integer.parseInt(mes_i), datav,
                        Integer.parseInt(qtd_parcelas), Double.parseDouble(valor_men),
                        Double.parseDouble(desconto_men), cg5.getContrato().getIdcontrato())) {
                    t6 = "1";
                } else {
                    t6 = "0";
                }

                if (t1.equals("1") && t2.equals("1") && t3.equals("1") &&
                    t4.equals("1") && t5.equals("1") && t6.equals("1")) {
                    mensagem = "Todos os dados foram gravados com sucesso!!";
                } else {
                    mensagem = "Ops! Algo deu errado!";
                }

            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }

        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_aluno.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
