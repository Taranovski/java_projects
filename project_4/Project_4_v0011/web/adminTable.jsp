<%-- 
    Document   : adminTable
    Created on : 05.01.2014, 16:54:19
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="my" uri="//tlds/userTags.tld"%>

<fmt:setLocale value="${sessionScope['language']}" />
<fmt:setBundle basename="${sessionScope['bundle']}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="admin.table.title"/></title>
    </head>
    <body>
        <fmt:message key="admin.table.restrant.summ"/>
        <c:out value="${restrantSumm}"/>
        <br>
        <c:if test="${empty orderList}">
            <fmt:message key="admin.table.empty"/>
            <form method="post" action="./ControlServlet">
                <input type="hidden" name="command" value="orderTable"/>
                <fmt:message key="admin.order.table" var="buttonValue" />
                <input type="submit" name="getMenu" value="${buttonValue}"/>
            </form>
        </c:if>
        <c:if test="${not empty orderList}">
            <table border="1">
                <thead>
                    <tr>
                        <th>
                            <fmt:message key="admin.table.order.id"/>
                        </th>
                        <th>
                            <fmt:message key="admin.table.user.id"/>
                        </th>
                        <th>
                            <fmt:message key="admin.table.submit"/>
                        </th>
                    </tr>
                </thead>
            </table>
            <form method="post" action="./ControlServlet">
                <input type="hidden" name="command" value="orderTable"/>
                <input type="hidden" name="submitOrders" value="true"/>
                <c:forEach items="${orderList}" var="order">
                    <table border="1">
                        <tbody>
                            <tr>
                                <my:TableItemOrder order="${order}" orderId="true" userId="true"/>
                                <th>
                                        <input type="checkbox" name="orderId${order.orderId}userId${order.userId}" value="true" />
                                </th>
                            </tr>
                        </tbody>
                    </table>
                </c:forEach>
                <fmt:message key="admin.table.submit" var="orderButtonValue" />
                <input type="submit" name="order" value="${orderButtonValue}" />
            </form>
        </c:if>
    </body>
</html>
