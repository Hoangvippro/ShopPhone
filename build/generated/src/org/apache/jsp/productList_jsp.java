package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Product;
import java.util.List;
import model.ProductDAO;

public final class productList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    ProductDAO u = new ProductDAO();
    List<Product> lst = u.getProductList();

      out.write("  \n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("       <html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Product</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"css/manager.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"table-wrapper\">\n");
      out.write("        <h2> List of products </h2>\n");
      out.write("        <div class =\"tableProduct\">\n");
      out.write("        <table class=\"table table-striped table-hover\">\n");
      out.write("            <tr>\n");
      out.write("                <td> Product's ID </td>\n");
      out.write("                <td> Category ID </td>\n");
      out.write("                <td> Name </td>\n");
      out.write("                <td> Quantity </td>\n");
      out.write("                <td> Price </td>\n");
      out.write("                <td> Image </td>\n");
      out.write("                <td> Status </td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 for (Product x : lst) {
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( x.getPid() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( x.getCateID());
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( x.getPname() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( x.getQuantity());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( x.getPrice());
      out.write("</td>\n");
      out.write("                <!--<td width=\"250px\">");
      out.print( x.getImage());
      out.write("</td>-->\n");
      out.write("                <td width=\"250px\"><img src=\"");
      out.print( x.getImage());
      out.write("\" width=\"30%\" height=\"30%\" /></td>\n");
      out.write("                <td>");
      out.print( x.getStatus());
      out.write("</td>\n");
      out.write("                <td> <a href=\"deletepro?pid=");
      out.print( x.getPid() );
      out.write("\"> Delete  </td>\n");
      out.write("                <td> <a href=\"updatepro?pid=");
      out.print( x.getPid() );
      out.write("\"> Update  </td>\n");
      out.write("               <!--<td> <a href=\"delete?id=");
      out.print( x.getPid() );
      out.write("\"> Delete  </td>-->  \n");
      out.write("               <!--<td> <a href=\"updateCar.jsp?id=");
      out.print( x.getPid() );
      out.write("\"> Update  </td>-->  \n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>  \n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        <p><a href=\"insertpro.jsp\">Insert new Product</a>\n");
      out.write("        <p><button onclick='window.history.go(-1);'>Back to previous page</button>\n");
      out.write("        <p><a href=\"index.jsp\">Back to homepage</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
