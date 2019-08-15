function post() {
    var parent_id = $("#com_question").val();
    var commentContent = $("#comment_content").val();
    var comment_parent = $("#comment_parent").val();
    if (!commentContent) {
        alert("回复内容不能为空");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parent:": parent_id,
            "content": commentContent,
            "type": 1,
            "id": comment_parent
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                // 未登陆情况
                if (response.code == 2003) {
                    // 确认登陆
                    var is_accepted = confirm(response.message);
                    if (is_accepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=f2cd43e0f2411e6b3ff8&redirect_uri=http://localhost:8081/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", "true");
                    } else {
                        alert(response.message);
                    }
                }
            }
            console.log(response);
        },
        dataType: "json"
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    console.log(commentId);
    var realId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parent:": commentId,
            "content": content,
            "type": 2,
            "id": realId
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                // 未登陆情况
                if (response.code == 2003) {
                    // 确认登陆
                    var is_accepted = confirm(response.message);
                    if (is_accepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=f2cd43e0f2411e6b3ff8&redirect_uri=http://localhost:8081/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", "true");
                    } else {
                        alert(response.message);
                    }
                }
            }
            console.log(response);
        },
        dataType: "json"
    });
}


/*
展开二级评论
 */
function collapseContent(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);


    // 折叠评论
    if (comments.hasClass("in")) {

        comments.removeClass("in");
        e.classList.remove("active")
    }
    // 展开评论
    else {
        // $.getJSON( "/comment/" +id, function( data ) {
        //     var items = [];
        //     $.each( data, function( key, val ) {
        //         items.push( "<li id='" + key + "'>" + val + "</li>" );
        //     });
        //
        //     $( "<ul/>", {
        //         "class": "my-new-list",
        //         html: items.join( "" )
        //     }).appendTo( "body" );
        // });


        $.getJSON("/comment/" + id, function (data) {
            var commentBody = $("#comment-body-" + id);
            var items = [];
            commentBody.appendChild();
            $.each(data.data, function (comment) {
                    var c = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments",
                        html: comment.content
                    });


                    items.push(c);
                    $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse sub-comments",
                        "id": "comment-" + id,
                        html: items.join("")
                    }).appendTo(commentBody);


                    comments.addClass("in");
                    e.classList.add("active");
                }
            );

        }
    }