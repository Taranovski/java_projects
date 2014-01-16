<%-- 
    Document   : userTable
    Created on : 02.01.2014, 9:45:37
    Author     : Тарановский
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" uri="//tlds/userTags.tld" %>

<fmt:setLocale value="${sessionScope['language']}" />
<fmt:setBundle basename="${sessionScope['bundle']}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="user.table.title"/></title>
    </head>
    <body>
        <fmt:message key="user.table.order.number"/>
        <c:out value="${orderNumber}"/>
        
        <br>
        <fmt:message key="user.table.order.content"/>

        <c:forEach items="${dishList}" var="dish">
            <table border="1">
                <tbody>
                    <tr>
                        <my:TableItemDish dish="${dish}" name="true" description="true"/>
                    </tr>
                </tbody>
            </table>
        </c:forEach>
        <fmt:message key="user.table.order.processing"/>
        <form method="post" action="./ControlServlet">
            <input type="hidden" name="command" value="userCheckOrder"/>
            <fmt:message key="user.table.order.check" var="orderCheckButtonValue" />
            <input type="submit" name="order" value="${orderCheckButtonValue}" />
        </form>

    </body>
</html>
