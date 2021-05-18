/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.GroupDAO;

/**
 *
 * @author sa
 */
public class AddGroupAction extends ActionSupport {
    int groupid;
    String groupname;
    String description;

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public AddGroupAction() {
    }
    
    public String execute() throws Exception {
        new GroupDAO().insert(groupid,groupname,description );
        return "success";
    }
    
}
