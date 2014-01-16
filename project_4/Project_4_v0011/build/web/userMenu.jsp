<%-- 
    Document   : userMenu
    Created on : 02.01.2014, 16:20:09
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
        <title><fmt:message key="user.menu.show"/></title>
    </head>
    <body>

        <table border="1">
            <tbody>
                <tr>
                    <td>
                        <fmt:message key="user.menu.dish"/>
                    </td>
                    <td>
                        <fmt:message key="user.menu.description"/>
                    </td>
                    <td>
                        <fmt:message key="user.menu.price"/>
                    </td>
                    <td>
                        <fmt:message key="user.menu.order"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <form method="post" action="./ControlServlet">
            <input type="hidden" name="command" value="submitOrder"/>
            <c:forEach items="${dishList}" var="dish">
                <table border="1">
                    <tbody>
                        <tr>
                            <my:TableItemDish dish="${dish}" name="true" description="true" price="true"/>
                            <th>
                                <input type="input" name="${dish.dishId}${dish.name}" value="0" />
                            </th>
                        </tr>
                    </tbody>
                </table>
            </c:forEach>
            <fmt:message key="user.menu.accept" var="orderButtonValue" />
            <input type="submit" name="order" value="${orderButtonValue}" />
        </form>
        <c:if test="${menuError == 1}">
            <fmt:message key="user.menu.error1"/>
        </c:if>
        <c:if test="${menuError == 2}">
            <fmt:message key="user.menu.error2"/>
        </c:if>


    </body>
</html>
