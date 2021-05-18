<%-- 
    Document   : listGroup
    Created on : Mar 20, 2021, 10:31:18 AM
    Author     : sa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:bean var="dao" name="dao.GroupDAO"></s:bean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Group</h1>
        <p>There are ${dao.count()} groups in the list</p>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>                    
                </tr>
            </thead>
            <tbody>
        <c:forEach var="group" items="${dao.select()}">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td>${group.des}</td>

         </c:forEach>       
            </tbody>
        </table>
    <a href="AddGroup.jsp">
        <input type="button" value="Add Group">
    </a>
    <a href="ListContact.jsp">
        <input type="button" value="List Contact">
    </a>
    </body>
    
</html>
