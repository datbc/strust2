/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sa
 */
public class GroupDAO {
    public int count(){
        int count = 0;
        Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT groupid, name, description FROM GroupTBL";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count++;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }
    
     public void insert(int groupid, String name, String des) {
        Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            String sql = "INSERT INTO GroupTBL (groupid, Name, Description) VALUES (?,?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, groupid);
            stmt.setString(2, name);
            stmt.setString(3, des);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Group getGroup(int id) {
        Group group = null;
        Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT name, description from GroupTBL where groupid = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String name = rs.getString(1);
                String des = rs.getString(2);
                group = new Group(id, name, des);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return group;
    }

    public ArrayList<Group> select() {
        ArrayList<Group> lista = new ArrayList<>();
        Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM GroupTBL";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                Group gr = new Group(id, name, des);
                lista.add(gr);
            }
            rs.close();
            stmt.close();
            con.close();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Group getById(int id) {
        Group g = null;
        String sql = "Select * from GroupTBL Where groupid=" + id;
        Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int groupid = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                g = new Group(id, name, des);

            }
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception ex) {

        }
        return g;
    }
   
    public boolean updateData(int id, String name, String description) throws Exception {
        int result = 0;
        String sql = "Update GroupTBL Set name=?, description=? Where groupid=?;";

        try {
            Connection con = null;
            ConnectDB db = ConnectDB.getInstance();
            con = db.OpenConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setInt(3, id);
            result = stmt.executeUpdate();
            System.out.println("" + result);
           
            stmt.close();
            con.close();
        } catch (SQLException ex) {
          
        }
        return result > 0;
    }
}
