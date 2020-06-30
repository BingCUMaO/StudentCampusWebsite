jQuery(function () {
    // 取消浏览器默认行为

    // “正在收看...”动画
    // 获取.newsColumnNewsLabel的超链接文本
    var $newsColumnNewsLabelA = jQuery(".newsColumnNewsLabel>a");
    // 获取电视的label的文本
    var $newsColumnNewsLabelSpan = jQuery(".newsColumnPictureLabel>a>span");
    var $newsColumnNewsLabel = jQuery(".newsColumnNewsLabel>span");
    var presentIndex = 0;
    // 设置默认渲染
    var setIntervalTime = 4000;
    // 将label文本给电视的label文本
    setInterval(function () {
        // 文字消失-文字覆盖-文字淡入 -两次
        $newsColumnNewsLabelSpan.fadeToggle(setIntervalTime / 2, "linear", function () {
            // 文字覆盖
            $newsColumnNewsLabelSpan.text($newsColumnNewsLabelA.eq(presentIndex).text());
            jQuery(".newsColumnPictureLabel>a").attr("href", $newsColumnNewsLabelA.eq(presentIndex).attr("href"));

            $newsColumnNewsLabel.fadeOut(setIntervalTime / 6);
            $newsColumnNewsLabel.eq(presentIndex).fadeIn(setIntervalTime / 6);
            $(".newsColumnCenter>a>img").attr("src", "/static/img/TVPicture/news" + presentIndex + ".jpg");
            // 文字淡入
            $newsColumnNewsLabelSpan.fadeToggle(setIntervalTime / 2, "linear");
            presentIndex++;

            presentIndex %= 4;
        });
    }, setIntervalTime)

    // 文字跳动
    var labels = document.getElementsByClassName("label");
    function openTextJump(objArr, speed) {
        var spanIndex = 0;
        var spansLen = objArr.length;
        setInterval(function () {
            toggleClass(objArr[spanIndex], "spanJump");
            spanIndex++;
            spanIndex %= spansLen;
        }, speed)
    }
    openTextJump(labels[0].getElementsByTagName("span"), 350);
    openTextJump(labels[1].getElementsByTagName("span"), 300);
});