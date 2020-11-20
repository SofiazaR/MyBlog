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
    <div id="header-wrapper">
        <div id="header" class="container">
            <div id="logo">
                <h1><a href="#">world</a></h1>
                <p>Design by <a href="https://github.com/SofiazaR" rel="nofollow">Sofiana</a></p>
            </div>
            <div id="social">
                <ul class="contact">
                    <li><a href="https://twitter.com/jujubemraz" class="icon icon-twitter"><span>Twitter</span></a></li>
                </ul>
            </div>
        </div>
        <div id="menu" class="container">
            <ul>
                <li class="current_page_item"><a href="#" accesskey="1" title="">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/posts" accesskey="1" title="">Post</a></li>
                <li><a href="#" accesskey="2" title="">Videos</a></li>
                <li><a href="#" accesskey="3" title="">About Me</a></li>
                <li><a href="#" accesskey="4" title="">Contact Me</a></li>
            </ul>
        </div>
    </div>
    <div id="page" class="container">
        <div class="column1">
            <div class="title">
                <h2>Тут Обо мне</h2>
            </div>

        <img src="WebContent/Images/me.jpg" width="270" height="270" alt=""/>
        <p>Тут обычно бывают интересные события</p>
        </div>
        <div class="column2">
            <div class="title">
                <h2>Последние рецепты</h2>
            </div>
            <img src="WebContent/Images/food.jpg" width="270" height="270" alt=""/>
            <p>Ребяточки, две недели жила в одиночестве, так что напишу вам рецептики, которые полюбились:</p>
            <p>🌿<a href="https://www.instagram.com/chto_gde_sofiko/" rel="nofollow">Суп с фрикадельками</a>🌿</p>
            <p>🌿<a href="https://www.instagram.com/chto_gde_sofiko/" rel="nofollow">Крылышки в духовке</a>🌿</p>
            <p>🌿<a href="https://www.instagram.com/chto_gde_sofiko/" rel="nofollow">Желе с фруктиками</a>🌿</p>
            <p>🌿<a href="https://www.instagram.com/chto_gde_sofiko/" rel="nofollow">Сладкий бутер</a>🌿</p>
        </div>
        <div class="column3">
            <div class="title">
                <h2>Путеводная звезда</h2>
            </div>
            <img src="WebContent/Images/travelIm.jpg" width="270" height="270" alt=""/>
            <p>Тут я рассказываю о моих любимых местах</p>
        </div>
        <div class="column4">
            <div class="title">
                <h2>Мои питомцы</h2>
            </div>
            <img src="WebContent/Images/Animal.jpg" width="270" height="270" alt=""/>
            <p>(которые еще живы)</p>
            <p>Раздел постоянно обновляется</p>
        </div>
    </div>
    <div id="portfolio-wrapper">
        <div id="portfolio" class="container">
            <div class="title">
            </div>
        </div>
    </div>
</div>
<jsp:include page="views/_footer.jsp"/>