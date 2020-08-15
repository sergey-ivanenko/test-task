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

    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css">
    <script src="${contextPath}/js/jquery-3.4.1.min.js"></script>

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

    <button type="button" id="logout" class="btn btn-info">Logout Basic Authentication</button>
</div>

<script>
    $("#logout").click(function() {
        $.ajax({
            type: 'GET',
            beforeSend: function (request) {
                request.setRequestHeader ("Authorization", "Basic " + btoa("log" + ":" + "out"));
            },
            url: '/welcome',
            error: function () {
                document.location = window.location.protocol + '//' + window.location.host + '/login?logout';
                //document.location = 'http://localhost:8080/login?logout';
            }
        })
    });
</script>

<script src="${contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>