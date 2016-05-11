/**
 * Created by daweizhuang on 4/26/16.
 */
//<![CDATA[

window.enableEdit = false;
window.dataOffSet = 10;
window.loadingNew = false;
window.stopload = false;
$(window).load(function(){
    $(window).scroll(function() {
        if($(window).scrollTop() + $(window).height() == $(document).height()) {
            loadMore();
        }
    });

    (function(){
        $('#edit_read_button').on(
            'click', function(){
                if ( $(this).text()== "Read Mode") {
                    $('.login').fadeToggle();
                }else{
                    $(this).text('Read Mode');
                    window.enableEdit = false;
                    $("#new_wiki_link").toggle();
                }
            }
        );
    })();
});
function loadMore(){
    if(window.loadingNew || window.stopload){ return ;}
    window.loadingNew = true;
    if(!checkToken()){return;}
    $.ajax({
        type: 'POST',
        dataType:'json',
        url: '/wiki/loadMore/',
        data: {"dataOffSet":dataOffSet,"token":window.submit_token},
        success: function (msg) {
            window.dataOffSet += 10;
            msg.forEach(function(item){
                if(item.id == 0){window.stopload = true; return false;}
                var new_element = $('<div class="bs-docs-section clearfix"> </div>');
                new_element.append('<div class="row"><div class="col-lg-12"><div class="page-header wiki-title" ><h3 class="bs-component" id="'+ item.id +'">'+item.title+'</h3></div></div></div>');
                new_element.append('<div class="row"><div class="col-lg-12"><div class="content_wiki" ><p class="content_desc" >'+ item.wikiContentBrief+' </p><p class="content_full" style="display: none" id="full_content_'+item.id+'">'+item.wikiContent+'</p> <span class="more">more...</span></div></div></div>');
                new_element.hide().appendTo('#main_container').fadeIn();
            });
        },
        error: function( jqXHR, textStatus){
            if(textStatus == 'timeout'){
                $("#error_msg").text('Cannot Load new records. Timeout.').fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
            }
        },
        statusCode: {
            333: function () {
                invalidToken();
            }
        },
        timeout: 10000
    });
    window.loadingNew = false;
}
window.wikiId = 0;

$(function(){
    var $button = $("<div id='edit-button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-pencil'></span>Edit</div>").click(function(event){
        window.wikiId = $(this).parent().siblings('.bs-component').attr('id');
        $('#update_wiki_modal_dialog').modal('toggle');
        var title = $("#"+wikiId).text();
        $("#edit_title").val(title);
        var content = $("#full_content_"+wikiId).text();
        $("#edit_content").val(content);

        //edit_title.text(title);
        // alert(title);
    });
    var $button_delete = $("<div id='delete-button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-trash'></span>Delete</div>").click(function(){
        window.wikiId = $(this).parent().siblings('.bs-component').attr('id');
        $('#delete_wiki_modal_dialog').modal('toggle');
    });

    var $button_box = $("<div id='button_menu' class='flow_button'></div>");
    $button_box.append($button);
    $button_box.append($button_delete);

    $( "#main_container" ).on( "mouseenter", ".wiki-title", function(event) {
        if (enableEdit == true) {
            // $(this).append($button);
            // $(this).append($button_delete);
            $(this).append($button_box);
            $button.hide().fadeIn(300);
            $button_delete.hide().fadeIn(300);
        }
    }).on( "mouseleave", ".wiki-title", function(event) {
        $button.hide();
        $button_delete.hide();
    });

    $('#main_container').on('click','.more',function(){
        // $(this).siblings(".content_full").toggle();
        // $(this).siblings(".content_desc").toggle();
        // if ( $(this).siblings(".content_full").css("display") == "none") {
        //     $(this).text('More...');
        // }else{
        //     $(this).text('Less...');
        // }
        var content = $(this).siblings(".content_full").text();
        $("#more_content").val(content);
        $('#more_modal_dialog').modal('toggle');
    });

    $('#search_reset_button').click(function(){
        if(!checkToken()){return;}
        var search_input = $('#search_input');
        if(search_input.val() != null){
            search_input.val("");
        }
        window.dataOffSet = 0;
        window.stopload = false;
        removeAllContent();
        loadMore();
        var sideButton = $("#side_menu_button");
        if(sideButton.attr("aria-expanded") === "true"){
            sideButton.trigger( "click" );
        }
    });
    $('#search_button').click(function(){
        if(!checkToken()){return;}
        var search_input = $('#search_input').val();
        if(search_input.trim() == ""){
            $("#error_msg").text('Nothing to search').fadeIn( 100 ).delay(400).fadeOut( 400 );
            return;
        }
        $.ajax({
            type: 'POST',
            dataType:'json',
            url: '/wiki/search/',
            data: {"searchInput":search_input,"token":window.submit_token},
            success: function (msg) {
                removeAllContent();
                window.stopload = true;
                if(msg.length < 1){ $("#warning_msg").text('No Result').fadeIn( 200 ).delay(800).fadeOut( 400 );return;}
                msg.forEach(function(item){
                    // if(item.id == 0){window.stopload = true; return false;}
                    // var new_element = $('<div class="bs-docs-section clearfix"> </div>');
                    // new_element.append('<div class="row"><div class="col-lg-12"><div class="page-header wiki-title" ><h3 class="bs-component" id="'+ item.id +'">'+item.title+'</h3></div></div></div>');
                    // new_element.append('<div class="row"><div class="col-lg-12"><div class="content_wiki" ><p class="content_desc" >'+ item.wikiContentBrief+' </p><p class="content_full" style="display: none" id="full_content_'+item.id+'">'+item.wikiContent+'</p> <span class="more">more...</span></div></div></div>');
                    // new_element.hide().appendTo('#main_container').fadeIn();
                    updateNewContents(item);
                });
                var sideButton = $("#side_menu_button");
                if(sideButton.attr("aria-expanded") === "true"){
                    sideButton.trigger( "click" );
                }
            },
            error: function( jqXHR, textStatus){
                if(textStatus == 'timeout'){
                    $("#error_msg").text('Error in Search, Timeout.').fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                }
            },
            statusCode: {
                333: function () {
                    invalidToken();
                }
            },
            timeout: 10000
        });
    });

});
function removeAllContent() {
    $(".bs-docs-section").fadeOut(200);
}
function updateNewContents(msg) {
    var $newWiki = $("<div class='bs-docs-section clearfix'> <div class='row'> <div class='col-lg-12'> " +
        "<div class='page-header wiki-title'><h3 class='bs-component' id='"+msg.id+"'>"+ msg.wikiTitle + "</h3> </div> </div></div> " +
        "<div class='row'> <div class='col-lg-12'> " +
        "<div class='content_wiki'> <p class='content_desc'>" + msg.wikiContentBrief + "</p> <p class='content_full' style='display: none' id='full_content_"+msg.id+"'>"+ msg.wikiContent+"</p> <span class='more'>more...</span></div> </div> </div> </div>").hide().fadeIn(800);

    $('#banner').after($newWiki);

}
function updateEditContents(msg) {
    $("#" + msg.id).closest(".bs-docs-section").hide();
    updateNewContents(msg);
}

function updateDeleteContents(msg) {
    $("#" + msg.id).closest(".bs-docs-section").fadeOut(800);

}
function checkToken(){
    if(window.submit_token ==''){
        $("#error_msg").text("Cannot submit without giving access code.").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
        return false;
    }
    return true;
}
function invalidToken(){
    $("#error_msg").text("Invalid Token used.").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
}
$(function () {

    $('#create_new_form').on('submit', function (e) {
        e.preventDefault();
        if(!checkToken()){return;}

        //save button so we can use later
        var submit_button = $(this).find("#save_new_button");

        //give button loading state
        submit_button.button('loading');
        $("#create_new_form :input").prop("disabled", true);

        var title = $("#title").val();
        var content = $("#content").val();
        var priority = $("#priorityDiv input[type='radio']:checked").val();
        var label = $("#label").val();
        var category = $("#category").val();
        $.ajax({
            type: 'POST',
            dataType:'json',
            url: '/wiki/save/',
            data: {"title":title,"content":content,"priority":priority,"label":label,"category":category,"token":window.submit_token},
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
                window.dataOffSet += 1;
            },
            error: function( jqXHR, textStatus, errorThrown){
                if(textStatus == 'timeout'){
                    $("#error_msg").text("Error in Create New Wiki,").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    submit_button.button('reset');
                    $("#create_new_form :input").prop("disabled", false);
                }
            },
            statusCode: {
                333: function () {
                    invalidToken();
                }
            },
            timeout: 10000
        });
    });

    $('#delete_form').on('submit', function (e) {
        e.preventDefault();
        if(!checkToken()){return;}
        var delete_button = $(this).find("#delete_yes_button");
        //give button loading state
        delete_button.button('loading');
        $.ajax({
            type: 'POST',
            dataType:'json',
            url: '/wiki/delete/',
            data: {"id":wikiId,"token":window.submit_token},
            success: function (msg) {
                //close the dialog
                $('#delete_wiki_modal_dialog').modal('toggle');
                //show success msg
                $("#success_msg").text("Deleted").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                //re - enable the button
                delete_button.button('reset');
                //update the content
                updateDeleteContents(msg);
                window.dataOffSet -= 1;
            },
            error: function( jqXHR, textStatus, errorThrown){
                if(textStatus == 'timeout'){
                    $("#error_msg").text("Error in Deleting.").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    delete_button.button('reset');
                }else{
                    delete_button.button('reset');
                }
            },
            statusCode: {
                333: function () {
                    invalidToken();
                }
            },
            timeout: 10000
        });
    });
    $('#login_form').on('submit', function (e) {
        e.preventDefault();
        if(!checkToken()){return;}
        var login_button = $(this).find("#login_button");
        //give button loading state
        login_button.button('loading');
        var userName = $("#login_user").val();
        var password = $("#login_pwd").val();
        $.ajax({
            type: 'POST',
            dataType:'text',
            url: '/wiki/login/',
            data: {"user":userName,"password":password,"token":window.submit_token},
            success: function (msg) {
                login_button.button('reset');
                if(msg == "fail"){
                    $("#error_msg").text("Incorrect username/password.").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    return;
                }
                window.submit_token = msg;
                $(".login").fadeOut(100);
                //clear
                $('#login_form').find("input[type=text], textarea").val("");
                $('#edit_read_button').text('Edit Mode');
                window.enableEdit = true;
                $("#new_wiki_link").toggle();
            },
            error: function( jqXHR, textStatus, errorThrown){
                if(textStatus == 'timeout'){
                    $("#error_msg").text("Error in Login.").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    login_button.button('reset');
                }else{
                    login_button.button('reset');
                }
            },
            statusCode: {
                333: function () {
                    invalidToken();
                }
            },
            timeout: 10000
        });
    });

    $('#update_form').on('submit', function (e) {
        e.preventDefault();
        if(!checkToken()){return;}
        var update_button = $(this).find("#save_update_button");
        //give button loading state
        update_button.button('loading');

        var title = $("#edit_title").val();
        var content = $("#edit_content").val();
        $("#update_form :input").prop("disabled", true);
        $.ajax({
            type: 'POST',
            dataType:'json',
            url: '/wiki/update/',
            data: {"id":wikiId,"title":title,"content":content,"token":window.submit_token},
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
                    $("#error_msg").text("Error in Updating").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    update_button.button('reset');
                }else{
                    update_button.button('reset');
                }
                $("#update_form :input").prop("disabled", false);
            },
            statusCode: {
                333: function () {
                    invalidToken();
                }
            },
            timeout: 10000
        });
    });
    $('#search_form').on('submit', function (e) {
        e.preventDefault();
        $('#search_button').click();
    });

});

$(document).mouseup(function (e)
{
    var container = $(".login");
    var link = $('#edit_read_button');
    if (!container.is(e.target) // if the target of the click isn't the container...
        && container.has(e.target).length === 0// ... nor a descendant of the container
        && !link.is(e.target))  //nor the link
    {
        container.fadeOut();
    }
});
//]]>
