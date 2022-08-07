/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BillDAO extends MyDAO {

    public List<Bill> getBillList() {
        List<Bill> t = new ArrayList<Bill>();
        xSql = "select * from Bill";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xOid, xCname, xCphone, xCaddress;
            int xCid, xStatus;
            double xTotal;
            Date xDatecreate;
            Bill x;
            while (rs.next()) {
                xOid = rs.getString("oID");
                xDatecreate = rs.getDate("dateCreate");
                xCname = rs.getString("cname");
                xCphone = rs.getString("cphone");
                xCaddress = rs.getString("cAddress");
                xTotal = rs.getDouble("total");
                xStatus = rs.getByte("status");
                xCid = rs.getInt("cid");
                x = new Bill(xOid, xDatecreate, xCname, xCphone, xCaddress, xTotal, xStatus, xCid);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Bill getBill(String xOid) {
        if (xOid == null || xOid.trim().equals("")) {
            return (null);
        }
        Bill x = null;
        xSql = "select * from Bill where oID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xOid);
            rs = ps.executeQuery();
            String xCname, xCphone, xCaddress;
            int xCid, xStatus;
            double xTotal;
            Date xDatecreate;
            while (rs.next()) {
                xDatecreate = rs.getDate("dateCreate");
                xCname = rs.getString("cname");
                xCphone = rs.getString("cphone");
                xCaddress = rs.getString("cAddress");
                xTotal = rs.getDouble("total");
                xStatus = rs.getByte("status");
                xCid = rs.getInt("cid");
                x = new Bill(xOid, xDatecreate, xCname, xCphone, xCaddress, xTotal, xStatus, xCid);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}
