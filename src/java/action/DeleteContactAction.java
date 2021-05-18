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
public class DeleteContactAction {
    private String id;
    private ContactDAO contactDao = new ContactDAO();

    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }
    
    
    public DeleteContactAction() {
    }
    
    public String execute() throws Exception {
        contactDao.delete(Integer.parseInt(id));
        return "success";
    }
    
}
