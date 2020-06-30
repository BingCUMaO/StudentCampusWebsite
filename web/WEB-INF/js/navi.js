if (/MSIE/i.test(navigator.userAgent)) {
    alert("IE浏览器异常,请更换其他浏览器");
    window.location.reload();
} else if ("ActiveXObject" in window) {
    alert("IE浏览器异常,请更换其他浏览器");
    window.location.reload();
}
