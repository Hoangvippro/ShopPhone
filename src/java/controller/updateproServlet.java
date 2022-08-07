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
import model.Product;
import model.ProductDAO;

/**
 *
 * @author ASUS
 */
public class updateproServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xID = request.getParameter("pid");
        ProductDAO u = new ProductDAO();
        Product x = u.getProduct(xID);
        if (x == null) {
            pr.println("<h2> A student is not found</h2>");
            request.getRequestDispatcher("update.html").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updatepro.jsp").forward(request, response);
        }

    }

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
        sPrice = request.getParameter("price");
        sStatus = request.getParameter("status");
        sCateId = request.getParameter("cateID");
        boolean isOk = true;
        if (xPid == null || xPid.equals("")) {
            isOk = false;
        }
        if (xPname == null || xPname.trim().length() == 0 || xPname.trim().equals("Invalid name!")) {
            xPname = "Invalid name!";
            isOk = false;
        }
        if (xImage == null || xImage.trim().length() == 0 || xImage.trim().equals("Invalid image source!")) {
            xImage = "Invalid image source!";
            isOk = false;
        }
        if (sPrice == null || sPrice.trim().length() == 0) {
            xPrice = 0;
        } else {
            xPrice = Double.parseDouble(sPrice.trim());
        }
        if (sQuantity == null || sQuantity.trim().length() == 0) {
            xQuantity = 0;
        } else {
            xQuantity = Integer.parseInt(sQuantity.trim());
        }
        if (sStatus == null || sStatus.trim().length() == 0) {
            xStatus = 0;
        } else {
            xStatus = Integer.parseInt(sStatus.trim());
        }
        if (sCateId == null || sCateId.trim().length() == 0) {
            xCateId = 0;
        } else {
            xCateId = Integer.parseInt(sCateId.trim());
        }
        Product x = new Product(xPid, xImage, xPname, xQuantity, xPrice, xStatus, xCateId);
        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updatepro.jsp").forward(request, response);
            return;
        }
        ProductDAO u = new ProductDAO();
        u.update(xPid,x);
        response.sendRedirect("productList.jsp");
    }
}
    
