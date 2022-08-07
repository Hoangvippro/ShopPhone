/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends MyDAO {

    public List<Product> getProductList() {
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xProID, xProName, xImage;
            int xQuantity, xStatus, xCateID;
            double xPrice;
            Product x;
            while (rs.next()) {
                xProID = rs.getString("pid");
                xProName = rs.getString("pname");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getDouble("price");
                xImage = rs.getString("image");
                xStatus = rs.getInt("status");
                xCateID = rs.getInt("cateID");

                    
                
                x = new Product(xProID, xImage, xProName, xQuantity, xPrice, xStatus, xCateID);
               
                
                t.add(x);
                
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Product getProduct(String xProID) {
        if (xProID == null || xProID.trim().equals("")) {
            return (null);
        }
        Product x = null;
        xSql = "select * from Product where pid = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xProID);
            rs = ps.executeQuery();
            String xProName, xImage;
            int xQuantity, xStatus, xCateID;
            double xPrice;
            if (rs.next()) {
                xProID = rs.getString("pid");
                xProName = rs.getString("pname");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getDouble("price");
                
                xImage = rs.getString("image");
                xStatus = rs.getInt("status");
                xCateID = rs.getInt("cateID");
                x = new Product(xProID, xImage, xProName, xQuantity, xPrice, xStatus, xCateID);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void deleteById(String xPid) {
        xSql = "delete from Product where pid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xPid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String xPid, Product x) {
        xSql = "Update Product set pname = ?, quantity = ?, price = ?, image = ?, status= ?, cateID = ? where pid = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getPname());
            ps.setInt(2, x.getQuantity());
            ps.setDouble(3, x.getPrice());
            ps.setString(4, x.getImage());
            ps.setInt(5, x.getStatus());
            ps.setInt(6, x.getCateID());
            ps.setString(7, xPid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void insert(Product x) {
        xSql = "insert into Product (pid,image,pname,quantity,price,status,cateID) values (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getPid());
            ps.setString(2, x.getImage());
            ps.setString(3, x.getPname());
            ps.setInt(4, x.getQuantity());
            ps.setDouble(5, x.getPrice());
            ps.setInt(6, x.getStatus());
            ps.setInt(7, x.getCateID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
