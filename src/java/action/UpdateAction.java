/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.ContactDAO;

/**
 *
 * @author sa
 */
public class UpdateAction {
     String id;
    String fir,las, group, phone;
    public UpdateAction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String execute() throws Exception {
 ContactDAO contactDAO=new ContactDAO();
        contactDAO.edit(Integer.parseInt(id),fir, las, phone, Integer.parseInt(group));
        return "success";    }
    
    
}
