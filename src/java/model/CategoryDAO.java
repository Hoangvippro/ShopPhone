/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends MyDAO {

    public List<Category> getCategoryList() {
        List<Category> t = new ArrayList<Category>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xCateName;
            int xCateID;
            byte xStatus;
            Category x;
            while (rs.next()) {
                xCateID = rs.getInt("cateID");
                xCateName = rs.getString("cateName");
                xStatus =  rs.getByte("status");
                x = new Category(xCateID, xCateName, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Category getCategory(int xCateID) {
        if (xCateID == 0) {
            return (null);
        }
        Category x = null;
        xSql = "select * from Category where cateID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xCateID);
            rs = ps.executeQuery();
            String xCateName;
            byte xStatus;
            while (rs.next()) {
                xCateID = rs.getInt("cateID");
                xCateName = rs.getString("cateName");
                xStatus =  rs.getByte("status");
                x = new Category(xCateID, xCateName, xStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}

