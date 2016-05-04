<%@include file="/WEB-INF/includes/header.jsp"%>

<div class="container" id="main_container">

    <div class="page-header" id="banner">
        <div class="row">
            <div class="col-md-7">
                <p class="lead">Programming inside Java</p>
            </div>
        </div>
    </div>

    <div class="modal fade" id="access_wiki_modal_dialog" data-keyboard="false" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Access</h4>
                </div>
                <form id="access_form" class="form-horizontal"  method="post" action="/wiki/validateAccessCode">
                    <div class="modal-body">
                        <fieldset>
                            <div class="form-group">
                                <label for="access_code" class="col-lg-4 control-label">Access Code</label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" id="access_code" name="access_code" placeholder="Access Code" required="true">
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" id="save_access_button" data-loading-text="<i class='icon-spinner icon-spin icon-large'></i>Validating...">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/footer.jsp"%>
<script>
    $("#access_wiki_modal_dialog").modal('toggle');
</script>
