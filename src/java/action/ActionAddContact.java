/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.Contact;
import dao.ContactDAO;
import java.util.ArrayList;

/**
 *
 * @author sa
 */
public class ActionAddContact extends ActionSupport {
    String fir,last,phone;
    int group;
    ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
    
    
    public ActionAddContact() {
    }
    
    public String execute() throws Exception {
        new ContactDAO().insert(fir, last, phone, group);
        contacts = new ContactDAO().select();
        return "success";
    }
    @Override
    public void validate(){
        if(fir.length()==0){
            addFieldError("fir","Please input firstname");
        }
        if(last.length()==0){
            addFieldError("last","Please input lastname");
        }else{
            if(!phone.matches("\\d+")){
                addFieldError("phone","Please input in number format");
            }
        }
    }

    public String getFir() {
        return fir;
    }

    public void setFir(String fir) {
        this.fir = fir;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
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
}
