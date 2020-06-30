// 吴柏龙制 功能：改变标签样式、获取标签样式、拖动
function getStyle(obj, name) {
    if (window.getComputedStyle) {
        return getComputedStyle(obj, null)[name];
    } else {
        return obj.currentStyle[name];
    }
};
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
function drag(obj) {
    obj.onmousedown = function (box1MouseDownEvent) {
        var box1MouseClientX = box1MouseDownEvent.clientX - obj.offsetLeft;
        var box1MouseClientY = box1MouseDownEvent.clientY - obj.offsetTop;
        console.log(box1MouseClientX + "+" + box1MouseClientY);
        document.onmousemove = function (moveEvent) {
            var left = moveEvent.clientX;
            var top = moveEvent.clientY;
            obj.style.top = top - box1MouseClientY + "px";
            obj.style.left = left - box1MouseClientX + "px";
        };
        document.onmouseup = function () {
            document.onmousemove = null;
        };
        return false;
    };
};
function addClass(obj, cN) {
    if (hasClass(obj, cN)) {
        return;
    } else {
        obj.className = obj.className + cN;
    }
};
function hasClass(obj, cN) {
    var regEx = new RegExp("\\b" + cN + "\\b");
    return regEx.test(obj.className);
};
function removeClass(obj, cN) {
    var regEx = new RegExp("\\b" + cN + "\\b");
    obj.className = obj.className.replace(cN, "");
};
function toggleClass(obj, cN) {
    if (hasClass(obj, cN)) {
        removeClass(obj, cN);
    } else {
        obj.className = obj.className + " " + cN;
    }
};