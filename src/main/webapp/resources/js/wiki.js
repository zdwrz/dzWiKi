/**
 * Created by daweizhuang on 4/26/16.
 */
//<![CDATA[

window.enableEdit = false;
$(window).load(function(){
    $(window).scroll(function() {
        if($(window).scrollTop() + $(window).height() == $(document).height()) {
            //  $("#main_container").append("<div>a</div>");
            var new_element = $("<div>a</div><div>a</div><div>a</div><div>a</div><div>a</div>"+
                "<div>a</div><div>a</div><div>a</div><div>a</div><div>a</div>" + "<div>a</div><div>a</div><div>a</div><div>a</div><div>a</div>"+
                "<div>a</div><div>a</div><div>a</div><div>a</div><div>a</div>");
            new_element.hide().appendTo('#main_container').fadeIn();
        }
    });

    (function(){
        $('#edit_read_button').on(
            'click', function(){
                $("#new_wiki_link").toggle();
                if ( $(this).text()== "Edit Mode") {
                    $(this).text('Read Mode');
                    window.enableEdit = false;
                }else{
                    $(this).text('Edit Mode');
                    window.enableEdit = true;
                }
            }
        );
    })();
});//]]>


window.wikiId = 0;

$(function(){
    var $button = $("<div id='edit-button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-pencil'></span>Edit</div>").click(function(event){
        window.wikiId = $(this).siblings('.bs-component').attr('id');
        $('#update_wiki_modal_dialog').modal('toggle');
        var title = $("#"+wikiId).text();
        $("#edit_title").val(title);
        var content = $("#full_content_"+wikiId).text();
        $("#edit_content").val(content);

       //edit_title.text(title);
       // alert(title);
    });
    var $button_delete = $("<div id='delete-button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-trash'></span>Delete</div>").click(function(){
        window.wikiId = $(this).siblings('.bs-component').attr('id');
        $('#delete_wiki_modal_dialog').modal('toggle');
    });

    $( "#main_container" ).on( "mouseenter", ".wiki-title", function(event) {
        if (enableEdit == true) {
            $(this).append($button);
            $(this).append($button_delete);
            $button.hide().fadeIn(300);
            $button_delete.hide().fadeIn(300);
        }
    }).on( "mouseleave", ".wiki-title", function(event) {
            $button.hide();
            $button_delete.hide();
    });

    $('#main_container').on('click','.more',function(){
            $(this).siblings(".content_full").toggle();
            $(this).siblings(".content_desc").toggle();
            if ( $(this).siblings(".content_full").css("display") == "none") {
                $(this).text('More...');
            }else{
                $(this).text('Less...');
            }
        }
    );

});

function updateNewContents(msg) {
    var $newWiki = $("<div class='bs-docs-section clearfix'> <div class='row'> <div class='col-lg-12'> " +
        "<div class='page-header wiki-title'><h3 class='bs-component' id='title_"+msg.id+"'>"+ msg.wikiTitle + "</h3> </div> </div></div> " +
        "<div class='row'> <div class='col-lg-12'> " +
        "<div class='content_wiki'> <p class='content_desc'>" + msg.wikiContentBrief + "</p> <p class='content_full' style='display: none'>"+ msg.wikiContent+"</p> <span class='more'>more...</span></div> </div> </div> </div>").hide().fadeIn(800);

    $('#banner').after($newWiki);
}
function updateEditContents(msg) {
    updateDeleteContents(msg);
    updateNewContents(msg);
}

function updateDeleteContents(msg) {
    $("#" + msg.id).closest(".bs-docs-section").fadeOut(800);
}

$(function () {

    $('#create_new_form').on('submit', function (e) {

        //save button so we can use later
        var submit_button = $(this).find("#save_new_button");

        //give button loading state
        submit_button.button('loading');
        $("#create_new_form :input").prop("disabled", true);
        e.preventDefault();

        var title = $("#title").val();
        var content = $("#content").val();
        var priority = $("#priorityDiv input[type='radio']:checked").val();
        var label = $("#label").val();
        var category = $("#category").val();
        $.ajax({
            type: 'POST',
            dataType:'json',
            url: '/wiki/save/',
            data: {"title":title,"content":content,"priority":priority,"label":label,"category":category},
            success: function (msg) {
                //clear the form
                $('#create_new_form').find("input[type=text], textarea").val("");
                //close the dialog
                $('#new_wiki_modal_dialog').modal('toggle');
                //show success msg
                $("#success_msg").text("Created new Wiki.").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                //re - enable the button
                submit_button.button('reset');
                //re-enable the form inputs
                $("#create_new_form :input").prop("disabled", false);
                //update the content
                updateNewContents(msg);
            },
            error: function( jqXHR, textStatus, errorThrown){
                if(textStatus == 'timeout'){
                    $("#error_msg").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    submit_button.button('reset');
                    $("#create_new_form :input").prop("disabled", false);
                }else{
                    alert(textStatus);
                }
            },
            timeout: 10000
        });
    });

    $('#delete_form').on('submit', function (e) {
        var delete_button = $(this).find("#delete_yes_button");
        //give button loading state
        delete_button.button('loading');

        e.preventDefault();
        $.ajax({
            type: 'POST',
            dataType:'json',
            url: '/wiki/delete/',
            data: {"id":wikiId},
            success: function (msg) {
                //close the dialog
                $('#delete_wiki_modal_dialog').modal('toggle');
                //show success msg
                $("#success_msg").text("Deleted").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                //re - enable the button
                delete_button.button('reset');
                //update the content
                updateDeleteContents(msg);
            },
            error: function( jqXHR, textStatus, errorThrown){
                if(textStatus == 'timeout'){
                    $("#error_msg").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    delete_button.button('reset');
                }else{
                    alert(textStatus + jqXHR + errorThrown);
                    delete_button.button('reset');
                }
            },
            timeout: 10000
        });
    });

    $('#update_form').on('submit', function (e) {
        var update_button = $(this).find("#save_update_button");
        //give button loading state
        update_button.button('loading');

        e.preventDefault();
        var title = $("#edit_title").val();
        var content = $("#edit_content").val();
        $("#update_form :input").prop("disabled", true);
        $.ajax({
            type: 'POST',
            dataType:'json',
            url: '/wiki/update/',
            data: {"id":wikiId,"title":title,"content":content},
            success: function (msg) {
                //clear
                $('#update_form').find("input[type=text], textarea").val("");
                //close the dialog
                $('#update_wiki_modal_dialog').modal('toggle');
                //show success msg
                $("#success_msg").text("Updated").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                //re - enable the button
                update_button.button('reset');
                //update the content
                updateEditContents(msg);
                $("#update_form :input").prop("disabled", false);
            },
            error: function( jqXHR, textStatus, errorThrown){
                if(textStatus == 'timeout'){
                    $("#error_msg").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    update_button.button('reset');
                }else{
                    alert(textStatus + jqXHR + errorThrown);
                    update_button.button('reset');
                }
                $("#update_form :input").prop("disabled", false);
            },
            timeout: 10000
        });
    });

});

