<%-- 
    Document   : ListContact
    Created on : Mar 15, 2021, 10:31:14 AM
    Author     : sa
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:bean var="dao" name="dao.ContactDAO"></s:bean>
<s:bean var="Gdao" name="dao.GroupDAO"></s:bean>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <h1>List of Contact</h1>
            <p>There are ${dao.count()} contacts in the list</p>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Group</th>
                    <th>Phone Number</th>
                    <th>Operations</th>
                </tr>
            </thead>
      
    <tbody>
        <c:forEach var="con" items="${dao.select()}">
            <tr>
                <td>${con.id}</td>
                <td>${con.fir}</td>
                <td>${con.las}</td>
                <c:set var="groupId" scope="page" value="${con.group}"/>
                <td>${Gdao.getGroup(groupId).name}</td>
                <td>${con.phone}</td>
                <td>                    
                        <button><a href="UpdateContactGet?id=${con.id}">Update</a></button>
                        <button><a href="DeleteContact?id=${con.id}">Delete</a></button>
                </td>    
            </tr>
        </c:forEach>   
        
    </tbody>
      </table>
    <a href="AddContact.jsp">
        <input type="button" value="Add Contact">
    </a>
      <a href="listGroup.jsp">
        <input type="button" value="List Group">
    </a>
    </body>
</html>
