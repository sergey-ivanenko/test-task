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

    <title>Registration Form</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${contextPath}/css/style.css"/>

    <script src="${contextPath}/js/html5shiv.min.js"></script>
    <script src="${contextPath}/js/respond.min.js"></script>
    <script src="${contextPath}/js/jquery-3.4.1.min.js"></script>
    <%--<script>
        $("registration").submit(function(event) {
            event.preventDefault();
            $data = $(this).serialize();
            if(!$(this).attr("action")) { var $url = document.location.href; } else { var $url = $(this).attr("action"); }
            //if(!$(this).attr("method")) { var $method = "post"; } else { var $method = $(this).attr("method"); }
            $.ajax({
                url: $url,
                type: "POST",
                data: $data,
                dataType: "json",
                success: function(data){
                    console.log(data);
                }
            });
        });
    </script>--%>
</head>
<body>
<div class="signup-form">
    <form id="registration" <%--action="${contextPath}/users/add" method="post"--%>>
        <h2>Register</h2>
        <p class="hint-text">Create your account. It's free and only takes a minute.</p>
        <div class="form-group">
            <input type="text" class="form-control" name="login" placeholder="Login" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="fullName" placeholder="Full Name" required="required">
        </div>
        <%--<div class="form-group">
            <input type="email" class="form-control" name="email" placeholder="Email" required="required">
        </div>--%>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password"
                   required="required">
        </div>
        <div class="form-group">
            <button id="submit-btn" type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form>
    <div class="text-center">Already have an account? <a href="${contextPath}/login">Sign in</a></div>
</div>


<script>
    $("#registration").submit(function (event) {
        /*$("#registration").on('submit', function(event) {*/
        event.preventDefault();
        var form = $('#registration').serializeArray();
        var formJsonObject = {};
        $.each(form, function (i, v) {
            formJsonObject[v.name] = v.value;
        });

        $.ajax({
            type: 'POST',
            url: '/users/add',
            dataType: 'json',
            data: JSON.stringify(formJsonObject),
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                window.location.href = '/welcome';
                //console.log(data)
            },
            error: function (e) {
                console.log(e);
            }
        });


        /*$data = $(this).serialize();
        let data = $(this).serialize();*/
        //var formData = JSON.stringify($("#registration").serializeArray());

        //console.log(formData);

        /*$.ajax({
            type: 'POST',
            url: 'http://localhost:8080//users/add',
            dataType: 'json',
            data: formData,
            contentType: 'application/json',
            success: function(data) {
                alert(data)
            }
        });*/

        /*$.ajax({
            type: "POST",
            url: "/users/add",
            data: formData,
            success: function(){console.log(data);},
            dataType: "json",
            contentType : "application/json",
            error: function(e) {
                console.log(e);
            }
        });*/
        //if(!$(this).attr("action")) { var $url = document.location.href; } else { var $url = $(this).attr("action"); }
        //if(!$(this).attr("method")) { var $method = "post"; } else { var $method = $(this).attr("method"); }
        /*$.ajax({
            url: $url,
            type: /!*$method*!/'post',
            data: $data,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function(data){
                console.log(data);
            }
        });*/
        /*$.ajax({
            type: 'POST',
            url: $url,
            data: JSON.stringify($data),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function(data){
                console.log(data);
            },
            error: function(e) {
                console.log(e);
            },
        });*/
    });
</script>
<script src="${contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>