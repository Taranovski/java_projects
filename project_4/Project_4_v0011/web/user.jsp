<%-- 
    Document   : newjsp
    Created on : 23.12.2013, 17:33:26
    Author     : Alex
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope['language']}" />
<fmt:setBundle basename="${sessionScope['bundle']}" />

<!DOCTYPE html/text>
<html>
    <head>
        <title><fmt:message key="user.show" /></title>
    </head>
    <body>
        <fmt:message key="user.hello"/>
        <c:out value="${user.name}"/>

        <form method="post" action="./ControlServlet">
            <input type="hidden" name="command" value="getMenu"/>
            <fmt:message key="user.get" var="buttonValue" />
            <input type="submit" name="getMenu" value="${buttonValue}"/>
        </form>
    </body>
</html>
