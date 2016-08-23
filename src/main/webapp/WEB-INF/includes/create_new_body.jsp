<div class="modal fade" id="new_wiki_modal_dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Create a New Wiki</h4>
            </div>
            <form id="create_new_form" class="form-horizontal" action="/WEB-INF/views/index.jsp" method="post">
            <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label for="title" class="col-lg-2 control-label">Title</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="title" placeholder="Title" required="true">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="content" class="col-lg-2 control-label">Content</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="10" id="content" required="true"></textarea>
                                <span class="help-block">Shine your mind, no bullshit.</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Priority</label>
                            <div class="col-lg-10" id="priorityDiv">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="priority" id="priority1" value="important"
                                               checked=""/>
                                        Important
                                    </label>

                                    <label>
                                        <input type="radio" name="priority" id="priority2" value="middle"/>
                                        Middle
                                    </label>

                                    <label>
                                        <input type="radio" name="priority" id="priority3" value="low"/>
                                        Low
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="category" class="col-lg-2 control-label">Category</label>
                            <div class="col-lg-10">
                                <select class="form-control" id="category">
                                    <option>Java</option>
                                    <option>Database</option>
                                    <option>Other</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="label" class="col-lg-2 control-label">Label</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="label" placeholder="Label" required="true">
                            </div>
                        </div>
                    </fieldset>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" id="save_new_button" data-loading-text="<i class='icon-spinner icon-spin icon-large'></i> Saving...">Save Wiki</button>
            </div>
            </form>
        </div>
    </div>
</div>