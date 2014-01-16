<%-- 
    Document   : admin
    Created on : 23.12.2013, 17:33:54
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope['language']}" />
<fmt:setBundle basename="${sessionScope['bundle']}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="admin.title"/></title>
    </head>
    <body>
        <fmt:message key="admin"/>
        <c:out value="${user.name}"/>
        
        <form method="post" action="./ControlServlet">
            <input type="hidden" name="command" value="orderTable"/>
            <fmt:message key="admin.order.table" var="buttonValue" />
            <input type="submit" name="getMenu" value="${buttonValue}"/>
        </form>
    </body>
</html>
