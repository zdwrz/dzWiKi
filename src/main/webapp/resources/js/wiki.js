/**
 * Created by daweizhuang on 4/26/16.
 */
//<![CDATA[
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
});//]]>
    
$(function(){
    var $button = $("<div id='edit-button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-pencil'></span>Edit</div>").click(function(){
        // var html = $(this).parent().html();
        // html = cleanSource(html);
        // $("#source-modal pre").text(html);
        // $("#source-modal").modal();
        alert("A");
    });
    var $button_delete = $("<div id='delete-button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-trash'></span>Delete</div>").click(function(){
        // var html = $(this).parent().html();
        // html = cleanSource(html);
        // $("#source-modal pre").text(html);
        // $("#source-modal").modal();
        alert("A");
    });

    // $('.bs-component [data-toggle="popover"]').popover();
    // $('.bs-component [data-toggle="tooltip"]').tooltip();

    // $(".bs-component").hover(function(){
    //     $(this).append($button);
    //     $(this).append($button_delete);
    //     $button.show();
    //     $button_delete.show();
    // }, function(){
    //     $button.hide();
    //     $button_delete.hide();
    // });

    $( "#main_container" ).on( "mouseenter", ".bs-component", function(event) {
        $(this).append($button);
        $(this).append($button_delete);
        $button.show();
        $button_delete.show();
    }).on( "mouseleave", ".bs-component", function(event) {
        $button.hide();
        $button_delete.hide();
    });
   

});

function updateContents(msg) {
    var $newWiki = $("<div class='bs-docs-section clearfix'> <div class='row'> <div class='col-lg-12'> " +
        "<div class='page-header'><h3 class='bs-component'>" + msg.title + "</h3> </div> </div></div> " +
        "<div class='row'> <div class='col-lg-12'> " +
        "<div class='content_wiki'> <p class='bs-component'>" + msg.content + "</p> </div> </div> </div> </div>").hide().fadeIn(600);

    $('#banner').after($newWiki);
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
                $("#success_msg").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                //re - enable the button
                submit_button.button('reset');
                //re-enable the form inputs
                $("#create_new_form :input").prop("disabled", false);
                //update the content
                updateContents(msg);
            },
            error: function( jqXHR, textStatus, errorThrown){
                if(textStatus == 'timeout'){
                    $("#error_msg").fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
                    submit_button.button('reset');
                    $("#create_new_form :input").prop("disabled", false);
                }
            },
            timeout: 10000
        });

 //      setTimeout(function () {}, 100000);
        //reset state
       // submit_button.button('reset');

    });

});

