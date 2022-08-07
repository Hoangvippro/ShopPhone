/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
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
public class insertcusServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter pr = response.getWriter();
         response.sendRedirect("insertcus.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
         PrintWriter pr = response.getWriter();
        String sCid, xCname, xCphone, xCaddress, xUsername, xPasssword, sStatus;
        int xCid = 0;
        byte xStatus = 1;
        xCname = request.getParameter("cname");
        xCphone = request.getParameter("cphone");
        xCaddress = request.getParameter("cAddress");
        xUsername = request.getParameter("username");
        xPasssword = request.getParameter("password");
//        sStatus = request.getParameter("status");
//        xStatus = Byte.parseByte(sStatus.trim());
        CustomerDAO u = new CustomerDAO();
        Customer x = u.getCustomer(xCid);
        if(x != null) {
           pr.println("<h2> id = " + xCid + " already exists!");
           request.getRequestDispatcher("insertcus.jsp").include(request, response);
           return;
        }
        else {
         x = new Customer(xCid, xCname, xCphone, xCaddress, xUsername, xPasssword,xStatus);
         u.insert(x);
         response.sendRedirect("customerList.jsp");
        }
      
    }
    }
