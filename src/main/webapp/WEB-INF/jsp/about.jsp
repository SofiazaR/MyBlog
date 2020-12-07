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
<div id="wrapper">
    <div id="header-wrapper-root">
        <div id="header" class="container">
            <div id="logo">
                <h1> About me </h1>
            </div>
        </div>
    </div>
</div>
<div id="page" class="container">
    <div class="column1">
        <div class="title">
            <h3>Доброго времени суток</h3>
            <p>Меня зовут Софьяна тут пишу иногда я, а иногда личности из моей головы, потому что было бы странно, если бы в моем блоге писала бы не только я. Так что поиск по юзерам достаточно условный, знайте за всем стоит только один человек!</p>
        </div>
    </div>
</div>
<jsp:include page="views/_footer.jsp"/>