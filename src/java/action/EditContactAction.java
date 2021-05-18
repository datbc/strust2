/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.Contact;
import dao.ContactDAO;

/**
 *
 * @author sa
 */
public class EditContactAction extends ActionSupport {
    private String id;
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public EditContactAction() {
    }
    
    public String execute() throws Exception {
        contact = new ContactDAO().getContact(Integer.parseInt(id));
        return "success";
    }
    
}
