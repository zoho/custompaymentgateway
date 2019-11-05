package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class paypage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<style type=\"text/css\">\n");
      out.write("  @import url(https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic);\n");
      out.write("* {\n");
      out.write("  margin: 0;\n");
      out.write("  padding: 10;\n");
      out.write("  box-sizing: border-box;\n");
      out.write("  -webkit-box-sizing: border-box;\n");
      out.write("  -moz-box-sizing: border-box;\n");
      out.write("  -webkit-font-smoothing: antialiased;\n");
      out.write("  -moz-font-smoothing: antialiased;\n");
      out.write("  -o-font-smoothing: antialiased;\n");
      out.write("  font-smoothing: antialiased;\n");
      out.write("  text-rendering: optimizeLegibility;\n");
      out.write("}\n");
      out.write("\n");
      out.write("body {\n");
      out.write("  font-family: \"Roboto\", Helvetica, Arial, sans-serif;\n");
      out.write("  font-weight: 100;\n");
      out.write("  font-size: 20px;\n");
      out.write("  line-height: 30px;\n");
      out.write("  color: #777;\n");
      out.write("  background: #8000ff;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("  max-width: 400px;\n");
      out.write("  width: 100%;\n");
      out.write("  margin: 0 auto;\n");
      out.write("  position: relative;\n");
      out.write("  color: #897;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container h1{\n");
      out.write("  max-width: 400px;\n");
      out.write("  width: 100%;\n");
      out.write("  margin: 0 auto;\n");
      out.write("  position: relative;\n");
      out.write("  color: #777;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#paypage {\n");
      out.write("  background: #F9F9F9;\n");
      out.write("  padding: 50px;\n");
      out.write("  margin: 150px 0;\n");
      out.write("  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\n");
      out.write("}\n");
      out.write("\n");
      out.write("#paypage h1 {\n");
      out.write("  position: all;\n");
      out.write("  font-family: \"Comic Sans MS\", cursive, sans-serif;\n");
      out.write("  font-weight: 100;\n");
      out.write("  display: block;\n");
      out.write("  font-size: 30px;\n");
      out.write("  line-height: 70px;\n");
      out.write("  color: #777;\n");
      out.write("}\n");
      out.write("\n");
      out.write("fieldset {\n");
      out.write("  font-family: \"Comic Sans MS\", cursive, sans-serif;\n");
      out.write("  border: medium none !important;\n");
      out.write("  margin: 0 0 10px;\n");
      out.write("  font-weight: 10;\n");
      out.write("  display: block;\n");
      out.write("  font-size: 20px;\n");
      out.write("  min-width: 100%;\n");
      out.write("  padding: 0;\n");
      out.write("  width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("#paypage input[type=\"submit\"] {\n");
      out.write("  font-family: \"Comic Sans MS\", cursive, sans-serif;\n");
      out.write("  cursor: pointer;\n");
      out.write("  width: 40%;\n");
      out.write("  border: none;\n");
      out.write("  background: #8000ff;\n");
      out.write("  color: #FFF;\n");
      out.write("  margin: 0 0 5px;\n");
      out.write("  padding: 10px;\n");
      out.write("  font-size: 15px;\n");
      out.write("}\n");
      out.write("#paypage input[type=\"number\"] {\n");
      out.write("  font-family: \"Comic Sans MS\", cursive, sans-serif;\n");
      out.write("  cursor: auto;\n");
      out.write("  width: 100%;\n");
      out.write("  border: none;\n");
      out.write("  background: #8080ff;\n");
      out.write("  color: #FFF;\n");
      out.write("  margin: 0 0 5px;\n");
      out.write("  padding: 10px;\n");
      out.write("  font-size: 15px;\n");
      out.write("}\n");
      out.write("#paypage input[type=\"password\"] {\n");
      out.write("  cursor: auto;\n");
      out.write("  width: 100%;\n");
      out.write("  border: none;\n");
      out.write("  background: #8080ff;\n");
      out.write("  color: #FFF;\n");
      out.write("  margin: 0 0 5px;\n");
      out.write("  padding: 10px;\n");
      out.write("  font-size: 15px;\n");
      out.write("}\n");
      out.write("#paypage select{\n");
      out.write("  font-family: \"Comic Sans MS\", cursive, sans-serif;\n");
      out.write("  cursor: auto;\n");
      out.write("  width: 100%;\n");
      out.write("  border: none;\n");
      out.write("  background: #8080ff;\n");
      out.write("  color: #FFF;\n");
      out.write("  margin: 0 0 5px;\n");
      out.write("  padding: 20px;\n");
      out.write("  font-size: 15px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<title>PayZ Payment Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">  \n");
      out.write("<form id=\"paypage\" action=\"/zhpay/makepayment\" method=\"post\">\n");
      out.write("\t\t\t<h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${invoiceNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("    <fieldset>\n");
      out.write("      <LABEL>Card Number </LABEL>\n");
      out.write("      <select id = \"card\" name=\"card_number\">\n");
      out.write("                  <option value = \"4111111111111111\">4111111111111111 (Success)</option>\n");
      out.write("                  <option value = \"4222222222222220\">4222222222222220 (Failure)</option>\n");
      out.write("              </select>\n");
      out.write("    <fieldset>\n");
      out.write("      <input type=\"hidden\" name=\"reference_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reference_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("    </fieldset>\n");
      out.write("    <fieldset></fieldset>\n");
      out.write("    <fieldset>\n");
      out.write("      <input type=\"submit\" value=\" Pay ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${amount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" tabindex=\"4\">\n");
      out.write("    </fieldset>\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
}
