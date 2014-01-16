<%-- 
    Document   : userReady
    Created on : 05.01.2014, 16:54:00
    Author     : Alex
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
        <c:if test="${empty summ}">
            <fmt:message key="user.table.order.processing"/>
            <form method="post" action="./ControlServlet">
                <input type="hidden" name="command" value="userCheckOrder"/>
                <fmt:message key="user.table.order.check" var="orderCheckButtonValue" />
                <input type="submit" name="order" value="${orderCheckButtonValue}" />
            </form>
        </c:if>
        <c:if test="${not empty summ}">
            <fmt:message key="user.table.order.done"/>
            <c:forEach items="${dishList}" var="dish">
                <table border="1">
                    <tbody>
                        <tr>
                            <my:TableItemDish dish="${dish}" name="true" contents="true"/>
                        </tr>
                    </tbody>
                </table>
            </c:forEach>
            <fmt:message key="user.table.order.cost"/>
            <c:out value="${summ}"/>
            <br>
            <form method="post" action="./ControlServlet">
                <input type="hidden" name="command" value="userPay"/>
                <fmt:message key="user.table.order.pay" var="orderCheckButtonValue" />
                <input type="submit" name="order" value="${orderCheckButtonValue}" />
            </form>
        </c:if>

    </body>
</html>
