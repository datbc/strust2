<%-- 
    Document   : AddGroup
    Created on : Mar 20, 2021, 10:18:15 AM
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
        <h1>Add a Group</h1>
    <s:form action="AddGroup" method="POST">
        <s:textfield name="groupname" label="Group"></s:textfield>
        <s:textfield name="description" label="Description"></s:textfield>
        <s:submit label="Submit"></s:submit>
    </s:form>       
    </body>
</html>
