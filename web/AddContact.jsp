<%-- 
    Document   : AddContact
    Created on : Mar 15, 2021, 9:33:17 AM
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
        <h1>Add Contact </h1>
            <s:form action="AddContact" method="POST">
                <s:textfield name="fir" label="FirstName"></s:textfield>
                <s:textfield name="last" label="LastName"></s:textfield>
                <s:div>
                    Group
                    <select name="group">
                        <c:forEach var="gr" items="${Gdao.select()}" >
                            <option value="${gr.id}">${gr.name}</option>
                        </c:forEach>
                        
                    </select>
                    
                </s:div>
                <s:textfield name="phone" label="PhoneNumber"></s:textfield>  
                <s:submit label="Submit"></s:submit>
                    
            </s:form>
                    <a href="ListContact.jsp">Return to contact list</a>
    </body>
</html>

