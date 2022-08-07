/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDAO;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ASUS
 */
public class updatecusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xID = request.getParameter("cid");
        int xCid = Integer.parseInt(xID);
        CustomerDAO u = new CustomerDAO();
        Customer x = u.getCustomer(xCid);
        if (x == null) {
            pr.println("<h2> A student is not found</h2>");
            request.getRequestDispatcher("update.html").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updatecus.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pr = response.getWriter();
        String sCid, xCname, xCphone, xCaddress, xUsername, xPasssword, sStatus;
        int xCid;
        byte xStatus;
        sCid = request.getParameter("cid");
        xCname = request.getParameter("cname");
        xCphone = request.getParameter("cphone");
        xCaddress = request.getParameter("cAddress");
        xUsername = request.getParameter("username");
        xPasssword = request.getParameter("password");
        sStatus = request.getParameter("status");
        boolean isOk = true;
        if (sCid == null || sCid.trim().length() == 0) {
            xCid = 0;
        } else {
            xCid = Integer.parseInt(sCid.trim());
        }
        if (xCname == null || xCname.trim().length() == 0 || xCname.trim().equals("Invalid name!")) {
            xCname = "Invalid name!";
            isOk = false;
        }
        if (xCphone == null || xCphone.trim().length() == 0 || xCphone.trim().equals("Invalid phone number!")) {
            xCphone = "Invalid phone number!";
            isOk = false;
        }
        if (xCaddress == null || xCaddress.trim().length() == 0 || xCaddress.trim().equals("Invalid address!")) {
            xCaddress = "Invalid address!";
            isOk = false;
        }
        if (xUsername == null || xUsername.trim().length() == 0 || xUsername.trim().equals("Invalid username!")) {
            xUsername = "Invalid username!";
            isOk = false;
        }
        if (xPasssword == null || xPasssword.trim().length() == 0 || xPasssword.trim().equals("Invalid password!")) {
            xCaddress = "Invalid password!";
            isOk = false;
        }
        if (sStatus == null || sStatus.trim().length() == 0) {
            xStatus = 0;
        } else {
            xStatus = Byte.parseByte(sStatus.trim());
        }
        Customer x = new Customer(xCid, xCname, xCphone, xCaddress, xUsername, xPasssword, xStatus);
        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updatecus.jsp").forward(request, response);
            return;
        }
        CustomerDAO u = new CustomerDAO();
        u.update(xCid,x);
        response.sendRedirect("customerList.jsp");
    }
}
    

