<div class="modal fade" id="update_wiki_modal_dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Update</h4>
            </div>
            <form id="update_form" class="form-horizontal"  method="post">
                <div class="modal-body">
                    <fieldset>

                        <div class="form-group">
                            <label for="content" class="col-lg-2 control-label">Content</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="content" required="true"></textarea>
                                <span class="help-block">Shine your mind, no bullshit.</span>
                            </div>
                        </div>

                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" id="save_new_button" data-loading-text="<i class='icon-spinner icon-spin icon-large'></i> Updating...">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>