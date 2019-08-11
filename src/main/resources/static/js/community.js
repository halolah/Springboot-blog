function post() {
    var parent_id = $("#com_question").val();
    var commentContent = $("#comment_content").val();
    var test = $("#test").val();
    console.log(parent_id);
    console.log(commentContent);

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parent:": parent_id,
            "content": commentContent,
            "type": 1,
            "id": test
        }),
        success: function (response) {
            if (response.code == 200) {
                $("#comment_section").hide();
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