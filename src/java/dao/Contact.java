/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author sa
 */
public class Contact {
   private int id;
    private String fir;
    private String las;
    private String phone;
    private int group;

    public Contact() {
    }

    public Contact(int id, String fir, String las, String phone, int group) {
        this.id = id;
        this.fir = fir;
        this.las = las;
        this.phone = phone;
        this.group = group;
    }
    
    public Contact(String fir, String las, String phone, int group) {
        this.fir = fir;
        this.las = las;
        this.phone = phone;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFir() {
        return fir;
    }

    public void setFir(String fir) {
        this.fir = fir;
    }

    public String getLas() {
        return las;
    }

    public void setLas(String las) {
        this.las = las;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", fir=" + fir + ", las=" + las + ", phone=" + phone + ", group=" + group + '}';
    }
    
}
