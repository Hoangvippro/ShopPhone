/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ASUS
 */
public class deleteproServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xID = request.getParameter("pid");
        ProductDAO u = new ProductDAO();
        Product x = u.getProduct(xID);
        if (xID.length() == 0) {
            pr.println("<h2> ID cannot emply! Try again</h2>");
            request.getRequestDispatcher("delete.jsp").include(request, response);
            return;
        }
        if (x == null) {
            pr.println("<h2> That car is not exist </h2>");
            request.getRequestDispatcher("list.jsp").include(request, response);
            return;
        }
        u.deleteById(xID);
        response.sendRedirect("productList.jsp");
    }

}