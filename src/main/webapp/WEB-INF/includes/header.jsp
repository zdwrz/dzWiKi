<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/wiki.css" rel="stylesheet" />
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

    <title>Aweiz Wiki</title>
    <meta name="description" content="Aweiz" />
    <meta name="keywords" content="DzTools" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" id="side_menu_button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" data-toggle="modal" data-target="#intro_modal_dialog">DZ Wiki</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/">All</a></li>
                <%--<li><a href="/wiki/db">Database</a></li>--%>
                <%--<li><a href="/wiki/java">Other</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Tools <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/YinCal-1.0/YinCal.xhtml">Chinese Calendar</a></li>
                        <li class="divider"></li>
                        <li><a href="/YinCal-1.0/DateCalculator.xhtml">Data Calculator</a></li>
                        <li class="divider"></li>
                        <li><a href="#">dawei.zhuang@outlook.com</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search" id="search_form">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" id="search_input"/>
                </div>
                <button type="button" class="btn btn-default" id="search_button"><span class="glyphicon glyphicon-search"></span></button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li id="new_wiki_link" style="display: none"><a href="#" data-toggle="modal" data-target="#new_wiki_modal_dialog"><span class='glyphicon glyphicon-plus'></span>New Wiki</a></li>
                <li><a href="#" id="edit_read_button">Read Mode</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="alert-box success" id="success_msg">Successfully Created a new Wiki.</div>
<div class="alert-box failure" id="error_msg">Fail</div>
<div class="modal fade" id="intro_modal_dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">About Me</h4>
            </div>
            <div class="modal-body">
                <blockquote>
                    <p>The whole side is developed by Me. Of course with the help of JQuery, Boostrap, Fontawesome, Spring, and MongoDB.</p>
                </blockquote>
                <blockquote class="blockquote-reverse">
                    <p>It is intended to record my knowledge as much as I can since I have a family history of Alzheimer's.</p>
                    <small>Dawei Zhuang</small>
                </blockquote>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="more_modal_dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Detail</h4>
            </div>
            <div class="modal-body">
                <textarea class="form-control" readonly="readonly" rows="20" id="more_content"></textarea>
            </div>
        </div>
    </div>
</div>

</body>
</html>
