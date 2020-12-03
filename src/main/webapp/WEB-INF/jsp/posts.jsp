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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="views/_navbar.jsp"></jsp:include>
<jsp:useBean id="posts" scope="request" type="java.util.List"/>

<form id="MyForm">
    <h5>Search </h5>
    <input id="comment" type="text" name="tags" placeholder="Введите тег в формате #тег">
    <div class="btn btn-secondary" onclick="sendComment()">submit</div>

</form>

<div id="page" class="container">
    <c:forEach items="${posts}" var="post">
        <div class="column1">
            <div class="title">
                <h2>${post.id}</h2>
                <h2>${post.data}</h2>
                <h2>${post.userName}</h2>
            </div>
            <p class="mytext">${post.postText}</p>
            <img src="../WebContent/Images/${post.file_name}.${post.type}" width="270" height="270" alt="img">
        </div>
    </c:forEach>
</div>


<jsp:include page="views/_footer.jsp"/>
<script>
    function renderTable(posts) {
        let textCOM = '';
        $('#page').empty();
        let len = posts.length;
        for (let i = 0; i < len; i++) {
            let post = posts[i];
            let {postText} = post;
            let {id} = post;
            let {data} = post;
            var date = new Date(data);
            let format = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate()
            let {userName} = post;
            let {file_name} = post;
            let {type} = post;
            textCOM += " <div class=\"column1\">\n" +
                "            <div class=\"title\">\n" +
                "                <h2>"+id+"</h2>\n" +
                "                <h2>"+format+"</h2>\n" +
                "                <h2>"+userName+"</h2>\n" +
                "            </div>\n" +
                "            <p class=\"mytext\">"+postText+"</p>\n" +
                "            <img src=\"../WebContent/Images/"+file_name+"."+type+"\""+"width=\"270\" height=\"270\" alt=\"img\">\n" +
                "        </div>" ;
        }
        $('#page').append(textCOM);
    }

    function sendComment() {
        let comment = $('#comment').val();
        if (comment) {
            $('#comment').val('');
        }
        let data = {
            userName: comment,
        };

        $.ajax({
            type: "POST",

            data: JSON.stringify(data),
            success: (response) => {
                console.log(response);
                renderTable(response);
            },
            dataType: "json",
            contentType: "application/json"
        }).catch((err) => {
            console.log(err)
        })
    }

</script>

<style>
    .mytext {
        white-space: pre-wrap;
        white-space: -moz-pre-wrap;
        white-space: -o-pre-wrap;
        word-wrap: break-word;
    }
</style>