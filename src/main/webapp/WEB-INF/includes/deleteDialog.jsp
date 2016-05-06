<div class="modal fade" id="delete_wiki_modal_dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Delete</h4>
            </div>
            <form id="delete_form" class="form-horizontal"  method="post">
                <div class="modal-body">
                    <fieldset>
                        <p class="col-lg-9 ">Are you sure you want to delete this Wiki?</p>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-danger" id="delete_yes_button" data-loading-text="<i class='icon-spinner icon-spin icon-large'></i> Deleting...">Yes</button>
                </div>
            </form>
        </div>
    </div>
</div>