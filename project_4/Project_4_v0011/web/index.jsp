<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<c:set var="bundle" value="localisation.text" scope="session"/>
<fmt:setLocale value="${sessionScope['language']}" />
<fmt:setBundle basename="${sessionScope['bundle']}" />
<!DOCTYPE html/text>
<head>
    <title><fmt:message key="index.title" /></title>
</head>
<body>
    <form method="post" action="./index.jsp">
        <select id="language" name="language" onchange="submit()">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
        </select>
    </form>

    <fmt:message key="index.hello"/><br>

    <form method="post" action="./ControlServlet">
        <input type="hidden" name="command" value="login"/>
        <label for="username"><fmt:message key="index.login.label.username" />:</label>
        <input type="text" id="username" name="username">
        <br>
        <label for="password"><fmt:message key="index.login.label.password" />:</label>
        <input type="password" id="password" name="password">
        <br>
        <fmt:message key="index.login.button.submit" var="buttonValue" />
        <input type="submit" name="submit" value="${buttonValue}">
    </form>

    <c:if test = "${not empty login_error}">
        <fmt:message key="index.login.error"/>
        <c:set var="login_error" value="0"/>
    </c:if>
    <br>

</body>
</html>