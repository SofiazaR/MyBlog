<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<body>>
<title>Admin</title>
<jsp:include page="views/_navbar.jsp"></jsp:include>

<form action="${pageContext.request.contextPath}/newPost" enctype="multipart/form-data" method="post">
    <input type="text" name="post_text">
    <input type="text" name="tags" placeholder="Введите тег в формате #тег <br> Напимер: #food">
    <input type="text" name="category" placeholder="Введите категорию">
    <input type="file" name="photo" multiple accept="image/*,image/jpeg" placeholder="photo">
    <button type="submit" value="send">send</button>
</form>

<jsp:include page="views/_footer.jsp"/>