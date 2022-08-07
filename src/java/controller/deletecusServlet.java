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
import model.Customer;
import model.CustomerDAO;

/**
 *
 * @author ASUS
 */
public class deletecusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xID = request.getParameter("cid");
        int xCid = Integer.parseInt(xID);
        CustomerDAO u = new CustomerDAO();
        Customer x = u.getCustomer(xCid);
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
        u.deleteById(xCid);
        response.sendRedirect("customerList.jsp");
    }

}