/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO extends MyDAO {

    public List<BillDetail> getBillDetailList() {
        List<BillDetail> t = new ArrayList<BillDetail>();
        xSql = "select * from BillDetail";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xPid, xOid;
            int xQuantity;
            double xPrice, xTotal;
            BillDetail x;
            while (rs.next()) {
                xPid = rs.getString("pid");
                xOid = rs.getString("oID");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getDouble("price");
                xTotal = rs.getDouble("total");
                x = new BillDetail(xPid, xOid, xQuantity, xPrice, xTotal);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public BillDetail getBillDetail(String xPid) {
        if (xPid == null || xPid.trim().equals("")) {
            return (null);
        }
        BillDetail x = null;
        xSql = "select * from Category where cateID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xPid);
            rs = ps.executeQuery();
            String xOid;
            int xQuantity;
            double xPrice, xTotal;
            while (rs.next()) {
                xPid = rs.getString("pid");
                xOid = rs.getString("oID");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getDouble("price");
                xTotal = rs.getDouble("total");
                x = new BillDetail(xPid, xOid, xQuantity, xPrice, xTotal);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}
