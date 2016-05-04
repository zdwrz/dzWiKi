<%@include file="/WEB-INF/includes/header.jsp"%>
<%@include file="/WEB-INF/includes/create_new_body.jsp"%>
<%@include file="/WEB-INF/includes/update.jsp"%>
<%@include file="/WEB-INF/includes/deleteDialog.jsp"%>
<%@include file="/WEB-INF/includes/login.jsp"%>

<div class="container" id="main_container">

    <div class="page-header" id="banner">
        <div class="row">
            <div class="col-md-7">
                <p class="lead">Programming inside Java</p>
            </div>
        </div>
    </div>

    <c:forEach var="wiki" items="${wikiList}">
        <c:if test="${wiki.id != '0'}">
        <div class="bs-docs-section clearfix">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header wiki-title" >
                        <h3 class="bs-component" id="${wiki.id}">${wiki.wikiTitle}</h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="content_wiki" >
                        <p class="content_desc" > ${wiki.wikiContentBrief} </p>
                        <p class="content_full" style="display: none" id="full_content_${wiki.id}">${wiki.wikiContent}</p>
                        <span class="more">more...</span>
                    </div>
                </div>
            </div>
        </div>
        </c:if>
    </c:forEach>

</div>
<%@include file="/WEB-INF/includes/footer.jsp"%>
<script>window.submit_token = '${param["token"]}';</script>