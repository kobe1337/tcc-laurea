package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contrato;
import model.Mensalidade;
import DAO.MensalidadeDAO;

public class GerenciarMensalidade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";

        int idcontrato = Integer.parseInt(request.getParameter("idcontrato"));
        int idmensalidade = Integer.parseInt(request.getParameter("idmensalidade"));
        String acao = request.getParameter("acao");

        try {
            Mensalidade men = new Mensalidade();
            MensalidadeDAO menDAO = new MensalidadeDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    men = menDAO.getCarregaPorId(idcontrato, idmensalidade);
                    if (men.getIdmensalidade() > 0) {
                        RequestDispatcher disp
                                = getServletContext().getRequestDispatcher("/form_mensalidade.jsp");
                        request.setAttribute("mensalidade", men);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Mensalidade não encontrado";
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
        out.println("location.href='listar_mensalidade.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idmensalidade = request.getParameter("mensalidade");
        String idcontrato = request.getParameter("contrato");
        String mes = request.getParameter("mes");
        String valor = request.getParameter("valor");
        String datav = request.getParameter("datav");
        String datap = request.getParameter("datap");
        String multa = request.getParameter("multa");
        String desconto = request.getParameter("desconto");
        String status = request.getParameter("status");
        String mensagem = "";

        Mensalidade men = new Mensalidade();

        try {
            MensalidadeDAO menDAO = new MensalidadeDAO();

            men = menDAO.contarRegistro(Integer.parseInt(idcontrato), Integer.parseInt(idmensalidade));

            if (men.getNum() == 0) {

                if (idmensalidade.isEmpty() || idcontrato.isEmpty() || mes.isEmpty() ||valor.isEmpty()
                        || datav.isEmpty() || datap.isEmpty() || status.isEmpty()) {
                    
                    mensagem = "Campos obrigatórios deverão ser preenchidos";
                    
                } else {

                    Contrato con = new Contrato();

                    men.setIdmensalidade(Integer.parseInt(idmensalidade));

                    con.setIdcontrato(Integer.parseInt(idcontrato));
                    men.setContrato(con);

                    men.setMes(mes);
                    men.setValor(Double.parseDouble(valor));
                    men.setDatav(datav);
                    men.setDatap(datap);
                    men.setMulta(Double.parseDouble(multa));
                    men.setDesconto(Double.parseDouble(desconto));
                    men.setStatus(Integer.parseInt(status));

                    if (menDAO.gravar(men)) {
                        mensagem = "Gravado com sucesso";
                    } else {
                        mensagem = "Erro ao gravar no banco";
                    }
                }
            }
            
            if (men.getNum() == 1) {

                if (idmensalidade.isEmpty() || idcontrato.isEmpty() || mes.isEmpty() ||valor.isEmpty()
                        || datav.isEmpty() || datap.isEmpty() || status.isEmpty()) {
                    
                    mensagem = "Campos obrigatórios deverão ser preenchidos";
                    
                } else {

                    Contrato con = new Contrato();

                    men.setIdmensalidade(Integer.parseInt(idmensalidade));

                    con.setIdcontrato(Integer.parseInt(idcontrato));
                    men.setContrato(con);

                    men.setMes(mes);
                    men.setValor(Double.parseDouble(valor));
                    men.setDatav(datav);
                    men.setDatap(datap);
                    men.setMulta(Double.parseDouble(multa));
                    men.setDesconto(Double.parseDouble(desconto));
                    men.setStatus(Integer.parseInt(status));

                    if (menDAO.atualizar(men)) {
                        mensagem = "Gravado com sucesso";
                    } else {
                        mensagem = "Erro ao gravar no banco";
                    }
                }
            }
            
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_mensalidade.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
