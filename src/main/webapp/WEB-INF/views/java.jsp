<%@include file="/WEB-INF/includes/header.jsp"%>
<%@include file="/WEB-INF/includes/create_new_body.jsp"%>

<div class="container" id="main_container">

    <div class="page-header" id="banner">
        <div class="row">
            <div class="col-md-7">
                <p class="lead">Programming inside Java</p>
            </div>
        </div>
    </div>

    <c:forEach var="wiki" items="${wikiList}">
        <div class="bs-docs-section clearfix">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h3 class="bs-component">${wiki.dummyWikiTitle}</h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="content_wiki">
                        <p class="bs-component">${wiki.dummyWikiContent}</p>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>

</div>
<%@include file="/WEB-INF/includes/footer.jsp"%>