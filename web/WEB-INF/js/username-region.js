
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

    Vue.component("username-region", {
        template: `
            <div>
                    <div id="linkUsername" style="margin: 0 auto; position: relative; left: 20px; top: -20px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis"></div>
            </div>
        `,
        mounted: function () {

                $.ajax({
                    url: '/preparedLoad/obtainable/username',
                    type: 'POST',
                    success: function (username) {
                        $('#linkUsername').append(
                            '<label style=' +
                            '       "font-size: 30px;       '+
                            "      font-family: 'Bell MT'                               "+
                            "      overflow: hidden; white-space: nowrap;   text-overflow: ellipsis                                       "+
                            '        ">                                                         '+
                            username+'</label>'
                        )
                        console.log("username："+username)
                    }
                })
        }
    })