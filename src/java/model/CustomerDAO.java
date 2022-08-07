/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerDAO extends MyDAO {

    public List<Customer> getCustomerList() {
        List<Customer> t = new ArrayList<Customer>();
        xSql = "select * from Customer";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xCname, xCphone, xCaddress, xUsername, xPassword;
            int xCid;
            byte xStatus;
            Customer x;
            while (rs.next()) {
                xCid = rs.getInt("cid");
                xCname = rs.getString("cname");
                xCphone = rs.getString("cphone");
                xCaddress = rs.getString("cAddress");
                xUsername = rs.getString("username");
                xPassword = rs.getString("password");
                xStatus = rs.getByte("status");
                x = new Customer(xCid, xCname, xCphone, xCaddress, xUsername, xPassword, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Customer getCustomer(int xCid) {
        if (xCid == 0) {
            return (null);
        }
        Customer x = null;
        xSql = "select * from Customer where cid = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xCid);
            rs = ps.executeQuery();
            String xCname, xCphone, xCaddress, xUsername, xPassword;
            byte xStatus;
            while (rs.next()) {
                xCid = rs.getInt("cid");
                xCname = rs.getString("cname");
                xCphone = rs.getString("cphone");
                xCaddress = rs.getString("cAddress");
                xUsername = rs.getString("username");
                xPassword = rs.getString("password");
                xStatus = rs.getByte("status");
                x = new Customer(xCid, xCname, xCphone, xCaddress, xUsername, xPassword, xStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
     public void deleteById(int xCid) {
     xSql = "delete from Customer where cid=?";
     try {
        ps = con.prepareStatement(xSql);
        ps.setInt(1, xCid);
        ps.executeUpdate();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
      public void update(int xCid, Customer x) {
     xSql = "Update Customer set cname = ?, cphone = ?, cAddress = ?, username = ?, password= ?, status = ? where cid = ?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, x.getCname());
        ps.setString(2, x.getCphone());
        ps.setString(3, x.getcAddress());
        ps.setString(4, x.getUsername());
        ps.setString(5, x.getPassword());
        ps.setByte(6, x.getStatus());
        ps.setInt(7, xCid);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
     return;
  }
      public void insert(Customer x) {
        xSql = "insert into Customer (cname,cphone,cAddress,username,password,status) values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getCname());
            ps.setString(2, x.getCphone());
            ps.setString(3, x.getcAddress());
            ps.setString(4, x.getUsername());
            ps.setString(5, x.getPassword());
            ps.setByte(6, x.getStatus());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public Customer logincus(String xName, String xPass) {
      xSql = "select * from Customer where username = ? and password = ?";
      try {
        ps = con.prepareStatement(xSql);
        ps.setString(1, xName);
        ps.setString(2, xPass);
        rs = ps.executeQuery();
        while(rs.next()){
            return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5),rs.getString(6), rs.getByte(7));
        }
       rs.close();
       ps.close();
      }
       catch(Exception e) {
      }
     return null; 
   } 
}


