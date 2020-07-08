<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Log in with your account</title>
</head>
<body>
<div>
    <p>Hello ${greeting}</p>
    <p>Hello ${username}</p>
    <p>Hello ${role}</p>
</div>
<div>

    <form method="post" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout"/>
    </form>

    <form id="logoutForm" method="post" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <a href="#" onclick="document.forms['logoutForm'].submit()">
        <span class="glyphicon glyphicon-off"></span>Logout</a>
</div>

<script src="${contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>