<div class="modal fade" id="login_wiki_modal_dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Login</h2>
            </div>
            <form id="login_form" class="form-horizontal"  method="post">
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label for="edit_title" class="col-lg-2 control-label">Title</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="edit_title" placeholder="Title" required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edit_content" class="col-lg-2 control-label">Content</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="edit_content" required="true"></textarea>
                                <span class="help-block">Shine your mind, no bullshit.</span>
                            </div>
                        </div>

                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" id="save_login_button" data-loading-text="<i class='icon-spinner icon-spin icon-large'></i> Updating...">login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="login">
    <div class="arrow-up"></div>
    <div class="formholder">
        <div class="randompad">
            <fieldset>
                <label name="email">Email</label>
                <input type="email" value="example@example.com" />
                <label name="password">Password</label>
                <input type="password" />
                <input type="submit" value="Login" />

            </fieldset>
        </div>
    </div>
</div>