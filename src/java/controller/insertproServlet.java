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
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ASUS
 */
public class insertproServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter pr = response.getWriter();
         response.sendRedirect("insertpro.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
         PrintWriter pr = response.getWriter();
        String xPid, xImage, xPname, sQuantity, sPrice, sStatus, sCateId;
        int xStatus,xCateId,xQuantity;
        double xPrice;
        xPid = request.getParameter("pid");
        xImage = request.getParameter("image");
        xPname = request.getParameter("pname");
        sQuantity = request.getParameter("quantity");
        xQuantity = Integer.parseInt(sQuantity.trim());
        sPrice = request.getParameter("price");
        xPrice = Double.parseDouble(sPrice.trim());
        sStatus = request.getParameter("status");
        xStatus = Integer.parseInt(sStatus.trim());
        sCateId = request.getParameter("cateID");
        xCateId = Integer.parseInt(sCateId.trim());
        ProductDAO u = new ProductDAO();
        Product x = u.getProduct(xPid);
        if(x != null) {
           pr.println("<h2> id = " + xPid + " already exists!");
           request.getRequestDispatcher("insertpro.jsp").include(request, response);
           return;
        }
        else {
            if(xPname.equals("T")&& xQuantity == 1){
                xPrice = 600;
            }
         x = new Product(xPid, xImage, xPname, xQuantity, xPrice, xStatus, xCateId);
         u.insert(x);
         //pr.print(xPid);
         response.sendRedirect("productList.jsp");
        }
      
    }
    }
