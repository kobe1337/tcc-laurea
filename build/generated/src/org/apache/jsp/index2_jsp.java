package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.UsuarioDAO;
import model.Usuario;
import java.util.ArrayList;
import controller.GerenciarLogin;
import controller.GerenciarLogin;
import model.Usuario;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menu.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title> Láurea </title>\r\n");
      out.write("        <meta charset=\"utf-8\"/>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,shrink-to-fit=no\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/normalize.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/reset.css\">\r\n");
      out.write("        <!-- Bootstrap versão 4.1 -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">document.documentElement.classList.add(\"js\");</script>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo/menu.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/painel.css\"/>\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/img/logo/logo_menu.png\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    Usuario ulogado = GerenciarLogin.verificarAcesso(request, response);
    request.setAttribute("ulogado", ulogado);

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\"/>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo/menu.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<div class=\"menu\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("        <img src=\"assets/img/logo/logo_menu.png\"> \r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    <a class=\"menu_item\" href=\"gerenciar_login.do\"> <div> <img src=\"assets/img/icone menu/sair.png\"> Sair </div> </a>\r\n");
      out.write("</div>   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row \">\r\n");
      out.write("            <div class=\"painel_novo col\">\r\n");
      out.write("                <ul class=\"list-group painel_novo\">\r\n");
      out.write("                    <li class=\"list-group-item ativo\">\r\n");
      out.write("                        O QUE HA DE NOVO?\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <i>Ultimos usuários cadastrados</i>\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\"> new </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            Marcos Felipe\r\n");
      out.write("                            <small>10.10.2010</small>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            Júlia Vaz\r\n");
      out.write("                            <small>10.10.2010</small>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            Paulo Henrique\r\n");
      out.write("                            <small>10.10.2010</small>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            Daniele Silva\r\n");
      out.write("                            <small>10.10.2010</small>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"painel_status col\">\r\n");
      out.write("                <ul class=\"list-group painel_novo\">\r\n");
      out.write("                    <li class=\"list-group-item ativo\">\r\n");
      out.write("                        STATUS DO SISTEMA\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/usuario.png\">\r\n");
      out.write("                            Usuários\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\">\r\n");
      out.write("                                ");
      DAO.UsuarioDAO uDAO = null;
      synchronized (_jspx_page_context) {
        uDAO = (DAO.UsuarioDAO) _jspx_page_context.getAttribute("uDAO", PageContext.PAGE_SCOPE);
        if (uDAO == null){
          uDAO = new DAO.UsuarioDAO();
          _jspx_page_context.setAttribute("uDAO", uDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(uDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/usuario.png\">\r\n");
      out.write("                            Alunos\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\">\r\n");
      out.write("                                ");
      DAO.AlunoDAO aDAO = null;
      synchronized (_jspx_page_context) {
        aDAO = (DAO.AlunoDAO) _jspx_page_context.getAttribute("aDAO", PageContext.PAGE_SCOPE);
        if (aDAO == null){
          aDAO = new DAO.AlunoDAO();
          _jspx_page_context.setAttribute("aDAO", aDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(aDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/usuario.png\">\r\n");
      out.write("                            Responsáveis\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\">\r\n");
      out.write("                                ");
      DAO.ResponsavelDAO rDAO = null;
      synchronized (_jspx_page_context) {
        rDAO = (DAO.ResponsavelDAO) _jspx_page_context.getAttribute("rDAO", PageContext.PAGE_SCOPE);
        if (rDAO == null){
          rDAO = new DAO.ResponsavelDAO();
          _jspx_page_context.setAttribute("rDAO", rDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(rDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/usuario.png\">\r\n");
      out.write("                            Professores\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\">\r\n");
      out.write("                                ");
      DAO.ProfessorDAO pDAO = null;
      synchronized (_jspx_page_context) {
        pDAO = (DAO.ProfessorDAO) _jspx_page_context.getAttribute("pDAO", PageContext.PAGE_SCOPE);
        if (pDAO == null){
          pDAO = new DAO.ProfessorDAO();
          _jspx_page_context.setAttribute("pDAO", pDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("                                \r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(pDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/turma.png\">\r\n");
      out.write("                            Turmas\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\"> \r\n");
      out.write("                                ");
      DAO.TurmaDAO tDAO = null;
      synchronized (_jspx_page_context) {
        tDAO = (DAO.TurmaDAO) _jspx_page_context.getAttribute("tDAO", PageContext.PAGE_SCOPE);
        if (tDAO == null){
          tDAO = new DAO.TurmaDAO();
          _jspx_page_context.setAttribute("tDAO", tDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(tDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/fatura.png\">\r\n");
      out.write("                            Faturas\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\">\r\n");
      out.write("                                ");
      DAO.MensalidadeDAO meDAO = null;
      synchronized (_jspx_page_context) {
        meDAO = (DAO.MensalidadeDAO) _jspx_page_context.getAttribute("meDAO", PageContext.PAGE_SCOPE);
        if (meDAO == null){
          meDAO = new DAO.MensalidadeDAO();
          _jspx_page_context.setAttribute("meDAO", meDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(meDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/livro.png\">\r\n");
      out.write("                            Atividades\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\">\r\n");
      out.write("                                ");
      DAO.AtividadeDAO atDAO = null;
      synchronized (_jspx_page_context) {
        atDAO = (DAO.AtividadeDAO) _jspx_page_context.getAttribute("atDAO", PageContext.PAGE_SCOPE);
        if (atDAO == null){
          atDAO = new DAO.AtividadeDAO();
          _jspx_page_context.setAttribute("atDAO", atDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("                                \r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(atDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                            <img src=\"assets/img/status_do_sistema/livro.png\">\r\n");
      out.write("                            Disciplinas\r\n");
      out.write("                            <span class=\"badge badge-primary badge-pill\">  \r\n");
      out.write("                                ");
      DAO.DisciplinaDAO dDAO = null;
      synchronized (_jspx_page_context) {
        dDAO = (DAO.DisciplinaDAO) _jspx_page_context.getAttribute("dDAO", PageContext.PAGE_SCOPE);
        if (dDAO == null){
          dDAO = new DAO.DisciplinaDAO();
          _jspx_page_context.setAttribute("dDAO", dDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("                                <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(dDAO.lista)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("</label>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ulogado!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ulogado.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ulogado != null && ulogado.perfil != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_forEach_0.setVar("menu");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ulogado.perfil.menus}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            ");
          if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("    \r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.exibir == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.link}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><div class=\"menu_item\" ><img src=\"assets/img/menu/painel.png\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.menu}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</div></a>                  \r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}
