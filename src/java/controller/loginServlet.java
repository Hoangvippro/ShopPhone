/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.CustomerDAO;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ASUS
 */
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            String action = request.getParameter("action");
//            ProductDAO dao = new ProductDAO();
            String xName, xPass;
            xName = request.getParameter("user");
            xPass = request.getParameter("pass");
            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.getProductList();
            request.setAttribute("listP", list);
            CustomerDAO t = new CustomerDAO();
            Customer x = t.logincus(xName, xPass);
            if (x == null) {

                request.setAttribute("mess", "Username or password is incorrect");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
//                request.getSession().setAttribute("us", xName);
//                request.getSession().setAttribute("currUser", x);
                request.getSession().setAttribute("acc", x);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                //response.sendRedirect("homecontrol");
            }

//            if (action.equals("logout")) {
//                HttpSession session = request.getSession();
//                session.invalidate();
//                response.sendRedirect("homeCus?action=listAll");
//            }
//
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
