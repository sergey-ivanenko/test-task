<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Log in with your account</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/style.css"/>

    <script src="${contextPath}/js/html5shiv.min.js"></script>
    <script src="${contextPath}/js/respond.min.js"></script>
    <script src="${contextPath}/js/jquery-3.4.1.min.js"></script>

</head>
<body>
<div class="modal-dialog modal-login">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Sign In</h4>
            <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
        </div>
        <div class="modal-body">
            <form id="login" <%--action="${contextPath}/login" method="post"--%>>
                <div class="form-group">
                    <span>${error}</span>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" class="form-control" name="login" placeholder="Login" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <%--<span>${error}</span>--%>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <input type="password" class="form-control" name="password" placeholder="Password"
                               required="required">
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block btn-lg">Sign In</button>
                </div>
                <%--<p class="hint-text"><a href="#">Forgot Password?</a></p>--%>
            </form>
        </div>
        <div class="modal-footer">Don't have an account? <a href="${contextPath}/registration">Create one</a></div>
    </div>
</div>

<script>

    $("#login").submit(function(event) {
        event.preventDefault();

        var form = $('#login').serializeArray();
        var formJsonObject = {};
        $.each(form, function(i, v) {
            formJsonObject[v.name] = v.value;
        });

        /*var user = $('input[name=login]').val();
        var password = $('input[name=password]').val();*/
        var data = 'login=' + $('input[name=login]').val() + '&password=' + $('input[name=password]').val();

        $.ajax({
            type: 'POST',
            url: '/login',
            /*dataType: 'json',*/
            data: /*JSON.stringify(formJsonObject)*/data,
            /*contentType: 'application/json; charset=utf-8',*/
            success: function(data) {
                window.location.href = '/welcome';
                console.log(data)
            },
            error: function(e) {
                console.log(e);
            }
        });
    });

</script>

<script src="${contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>