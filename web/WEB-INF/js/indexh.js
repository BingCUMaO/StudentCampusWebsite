jQuery(function () {
    function objMove(obj, moveDirection, moveSpeed, targetAfterMove, callbackFun) {
        clearInterval(obj.SIID);
        var current = parseInt(getStyle(obj, moveDirection));
        if (current > targetAfterMove) {
            moveSpeed = -moveSpeed;
        }
        obj.SIID = setInterval(function () {
            var oldValue = parseInt(getStyle(obj, moveDirection));
            var newValue = oldValue + moveSpeed;
            if ((moveSpeed < 0 && newValue < targetAfterMove) || (moveSpeed > 0 && newValue > targetAfterMove)) {
                newValue = targetAfterMove;
            }
            obj.style[moveDirection] = newValue + "px";
            if (newValue == targetAfterMove) {
                clearInterval(obj.SIID);
                callbackFun && callbackFun();
            }
        }, 100);
    };
    function getStyle(obj, name) {
        if (window.getComputedStyle) {
            return getComputedStyle(obj, null)[name];
        } else {
            return obj.currentStyle[name];
        }
    };
    // 搜索栏动画
    var searchBarWidthStr = "180px";
    var searchBarWidth = 180;
    var winWidth = 0;
    jQuery(".searchBarBox>label>img").click(function () {
        // var searchBarWidthStr = jQuery("#searchBar").css('width');
        // var searchBarWidth = jQuery("#searchBar").width();
        if (window.innerWidth)
            winWidth = window.innerWidth;
        else if ((document.body) && (document.body.clientWidth))
            winWidth = document.body.clientWidth;
        if (winWidth > 900) {
            searchBarWidthStr = "180px";
            searchBarWidth = 180;
        }else {
            searchBarWidthStr = "90px";
            searchBarWidth = 90;
        }
        var $searchBar = jQuery("#searchBar");
        var searchBar = document.getElementById("searchBar");
        if ($searchBar.css('width') == searchBarWidthStr) {
            objMove(searchBar, "width", 50, 0, function () {
                $searchBar.css({
                    "padding": 0,
                    "border-top": 0,
                    "border-left": 0,
                    "border-right": 0,
                    "border-bottom": 0,
                });
            });

        } else {
            objMove(searchBar, "width", 50, searchBarWidth);
            $searchBar.css({
                "padding-left": "10px",
                "border": "2px solid black"
            });
        }
    });
});
