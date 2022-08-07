/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AdminDAO extends MyDAO{
    
 public List<Admin> getAdminList() {
        List<Admin> t = new ArrayList<Admin>();
        xSql = "select * from admin";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xUsername, xPassword;
            int xAdminid;
            Admin x;
            while (rs.next()) {
                xAdminid = rs.getInt("adminID");
                xUsername = rs.getString("username");
                xPassword = rs.getString("password");
                x = new Admin(xAdminid, xUsername, xPassword);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
   public Admin loginAdmin(String xName, String xPass) {
      xSql = "select * from admin where username = ? and password = ?";
      try {
        ps = con.prepareStatement(xSql);
        ps.setString(1, xName);
        ps.setString(2, xPass);
        rs = ps.executeQuery();
        while(rs.next()){
            return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
        }
       rs.close();
       ps.close();
      }
       catch(Exception e) {
      }
     return null; 
   } 
}
