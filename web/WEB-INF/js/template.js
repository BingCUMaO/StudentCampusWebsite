const avatar = new Vue({
    el: '#vueAvatar',
    data: {
        failMsg500: "登录失败",
        failMsg501: "您已登陆，若您想再次登录，请先注销目前的账号",
        failMsg502: "注销前请先登录",
        failMsg503: "注销失败",
        successMsg200: "登录成功",
        successMsg201: "注销成功"
    }
});


var hideQuery = function () {
    $('#query-container').hide();
}

var downAvatar = function () {
    $('#query-container').show();
}

var doDownAvartar = function () {

    $.ajax({
        url: '/preparedLoader/session/verifier',
        type: 'POST',
        success: function (areTrue) {
            if (areTrue == "true") {
                $('#dynamic').append("<a id='loadAvatarDownLoader' href='/fileLoader/avatar/download'></a>")
                $('#loadAvatarDownLoader').hide();
                $('#loadAvatarDownLoader')[0].click();
                $('#query-container').hide();
            } else if (areTrue == "false") {
                console.log("false")
                $('#dynamic').append("<a id='toLogin' href='/loginPage'></a>")
                $('#toLogin').hide();
                $('#toLogin')[0].click();
            }
        },
        error: function () {
            console.log("false")
            $('#dynamic').append("<a id='toLogin' href='/loginPage'></a>")
            $('#toLogin').hide();
            $('#toLogin')[0].click();
        }
    });


}


// 这样就可以不需要用到window.onload了
new Vue({
    el: '#query',
    mounted: function () {
        hideQuery()
    }
})
