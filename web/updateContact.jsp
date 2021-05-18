<%-- 
    Document   : updateContact
    Created on : Mar 21, 2021, 7:59:14 PM
    Author     : sa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:bean var="Gdao" name="dao.GroupDAO"></s:bean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Contact </h1>
            <s:form action="UpdateContact" method="POST">

                <input name="fir" value="${contact.fir}"/><br>
                
                <input name="las" value="${contact.las}"/><br>
                <s:div>
                    Group
                    <select name="group">
                        <c:forEach var="gr" items="${Gdao.select()}" >
                            <c:if test="${contact.id == gr.id}">
                                <option selected value="${gr.id}">${gr.name}</option>
                            </c:if>
                                
                                <c:if test="${contact.id != gr.id}">
                                <option value="${gr.id}">${gr.name}</option>
                            </c:if>
                            
                        </c:forEach>
                        
                    </select>
                    
                </s:div>
                    <input name="phone" value="${contact.phone}"/><br>
                <s:submit label="Submit"></s:submit>
                    
            </s:form>
                    <a href="ListContact.jsp">Return to contact list</a>
    </body>
</html>
