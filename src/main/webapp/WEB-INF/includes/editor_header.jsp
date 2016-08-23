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
    <meta name="keywords" content="Aweiz wiki" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" id="side_menu_button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" data-toggle="modal" data-target="#intro_modal_dialog">DZ Wiki</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" id="editor_save_button" onclick="submitEditor()">Save</a></li>
                <li><a href="#" id="editor_cancel_button">Cancel</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="alert-box success" id="success_msg">Successfully Created a new Wiki.</div>
<div class="alert-box failure" id="error_msg">Fail</div>
<div class="alert-box warning" id="warning_msg">Warning</div>
<div class="modal fade" id="intro_modal_dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">About Me</h4>
            </div>
            <div class="modal-body">
                <blockquote>
                    <p>The whole app is developed by Me. Of course with the help of JQuery, Boostrap, Fontawesome, Spring, and MongoDB.</p>
                </blockquote>
                <blockquote class="blockquote-reverse">
                    <p>It is intended to record my knowledge as much as I can since I have a family history of Alzheimer's.</p>
                    <small>Dawei Zhuang</small>
                </blockquote>
            </div>
            <div class="modal-footer">
                    <small>Version Id:${version} Build at:${buildTime}</small>
            </div>
        </div>
    </div>
</div>

</body>
</html>
