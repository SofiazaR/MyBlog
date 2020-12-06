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
<div id="wrapper">
    <div id="header-wrapper-videos">
        <div id="header" class="container">
            <div id="logo">
                <h1> Videos </h1>
            </div>
        </div>
    </div>

    <div id="page" class="container">
        <jsp:useBean id="videos" scope="request" type="java.util.List"/>
        <c:forEach items="${videos}" var="video">
            <div class="co-video1">
                <div class="title">
                    <h2>${video.resume}</h2>
                </div>
                <iframe width="560" height="315" src="${video.link}" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
            </div>
        </c:forEach>
    </div>

</div>
<jsp:include page="views/_footer.jsp"/>