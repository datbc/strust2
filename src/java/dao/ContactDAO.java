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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sa
 */
public class ContactDAO {
    public int count(){
        int count = 0;
        Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM ContactTBL";
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
    
    public void insert(String firstname, String lastname, String phonenumber, int groupId){
          Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            String sql = "INSERT INTO ContactTBL VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, phonenumber);
            stmt.setInt(4, groupId);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Contact> select(){
        ArrayList<Contact> lista = new ArrayList<>();
         Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT *  FROM ContactTBL";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fir = rs.getString("first");
                String las = rs.getString("last");
                String phone = rs.getString("phone");
                int group= rs.getInt("group");
                Contact cont = new Contact(id, fir, las, phone, group);
                lista.add(cont);
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
    
    public void edit(int id, String fir, String las, String phone, int group){
          Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            String sql = "UPDATE ContactTBL SET first = ? , last = ?, phone = ? , groupId = ? WHERE id = " + id;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fir);
            stmt.setString(2, las);
            stmt.setString(3, phone);
            stmt.setInt(4, group);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id){
          Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            String sql = "DELETE FROM ContactTBL WHERE id = " + id;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return;
    }
    public Contact getContact(int id){
         Connection con = null;
        ConnectDB db = ConnectDB.getInstance();
        try {
            con = db.OpenConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM ContactTBL where id = "+id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String fir = rs.getString(1);
                String las = rs.getString(2);
                String phone = rs.getString(3);
                int group= rs.getInt(4);
                Contact cont = new Contact(id, fir, las, phone, group);
                return cont;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
