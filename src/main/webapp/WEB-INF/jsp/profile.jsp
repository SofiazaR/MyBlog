<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet"/>
    <link href="WebContent/styles/default.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="WebContent/styles/fonts.css" rel="stylesheet" type="text/css" media="all"/>

    <title>${param.pageTitle}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<jsp:include page="views/_navbar.jsp"></jsp:include>
<div class="container">

    <div class="row justify-content-center">
        <h3>Change Password</h3>
        <div class="col-5 ">
            <form action="${pageContext.request.contextPath}/userProfile" method="post">
                <div class="form-group">
                    <label for="formGroupExampleInput"></label>
                    <input name="old_password" type="password" class="form-control" id="formGroupExampleInput"
                           placeholder="old password">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2"></label>
                    <input name="new_password" type="password" class="form-control" id="formGroupExampleInput2"
                           placeholder="new password">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput3"></label>
                    <input name="repeated_new_password" type="password" class="form-control" id="formGroupExampleInput3"
                           placeholder="repeat">
                </div>
                <button type="submit" class="btn btn-primary" value="Send">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="views/_footer.jsp"/>