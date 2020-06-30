
// 注意使用<avatar-region></avatar-region>组件时，
// 记得于<avatar-region>的祖先标签中
// 必须至少有一个是用new Vue出来的。

// 否则就仅仅是加载这个script文件进去，
// 而vue却没不认识<avatar-region>标签






// 正确使用如下：

// <div id="app">
//     <avatar-region></avatar-region>
// </div>
//
// <script>
//     new Vue({
//         el : '#app'
//     })
// </script>

    Vue.component("avatar-region", {
        template: `
            <div>
                    <div id="linkAvatar" style="margin: 0 auto;"></div>
            </div>
        `,
        mounted: function () {
                $.ajax({
                    url: '/avatar/path',
                    type : 'POST',
                    success: function (url) {
                        // $('#linkAvatar').append('<img id="preview" style="height: 73px;width: 73px; border-radius: 50%; " src='+url+'>')
                        $('#linkAvatar').append('<img style="height: 73px;width: 73px; border-radius: 50%; " src='+url+'>')
                    },
                    error: function () {
                        const noAvatar = "/static/img/avatar/defaultAvatar.jpg";
                        // $('#linkAvatar').append('<img id="preview" style="height: 73px;width: 73px; border-radius: 50%;" src='+noAvatar+'>')
                        $('#linkAvatar').append('<img style="height: 73px;width: 73px; border-radius: 50%;" src='+noAvatar+'>')
                    }
                })
        }
    })