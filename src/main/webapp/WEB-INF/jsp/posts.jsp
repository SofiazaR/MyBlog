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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="views/_navbar.jsp"></jsp:include>
<jsp:useBean id="posts" scope="request" type="java.util.List"/>
<h3>Приветики, тут всякие написанные мною штуки, их даже можно почитать</h3>
<div class="comments w-75 mx-auto" id="commentsList">
    <h1>FROM JSP USERS</h1>
    <div>
        <table> 
            <tr>
                <th>ID</th>
                <th>FIRST NAME</th>
                <th>LAST NAME</th>
            </tr>

            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.data}</td>
                    <td>${post.userName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="views/_footer.jsp"/>
