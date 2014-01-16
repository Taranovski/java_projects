<%-- 
    Document   : userExit
    Created on : 07.01.2014, 12:05:28
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
        <title><fmt:message key="user.exit.title"/></title>
    </head>
    <body>
        <fmt:message key="user.exit.you.pay"/>
        <c:out value="${summ}"/>
        <br>
        <fmt:message key="user.exit.thanks"/>

    </body>
</html>
