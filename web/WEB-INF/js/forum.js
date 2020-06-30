// by 吴柏龙
jQuery(function () {

    // 回到顶部
    let $backHeadBox = jQuery('#backHeadBox');
    jQuery(window).scroll(function () {
        let $headsHeight = jQuery('#backHeadBox').height() + jQuery("#narBarLabelBox").height() + jQuery("#forumPost").height()  ;
        if (jQuery(document.documentElement).scrollTop() + jQuery(document.body).scrollTop() >= $headsHeight) {
            $backHeadBox.css({
                display: "block"
            })
        } else {
            $backHeadBox.css({
                display: "none"
            })
        }
    });

    // 回到顶部
    $backHeadBox.click(function () {
        let $scrollTop = jQuery(document.documentElement).scrollTop() + jQuery(document.body).scrollTop();
        let moveTopAllTime = 500;
        let intervalTime = 50;
        let itemDistance = $scrollTop / (moveTopAllTime / intervalTime);
        let setIntervalID = setInterval(() => {
            $scrollTop -= itemDistance;
            if ($scrollTop <= 0) {
                $scrollTop = 0;
                clearInterval(setIntervalID);
            }
            jQuery("html,body").scrollTop($scrollTop);
        }, intervalTime);
    })
    var vm = new Vue({
        el: "#forumContent",
        data: {
            closeIndex: 0,
            activeUserAvatar: "../static/img/avatar/defaultAvatar.jpg",
            activeUserName: "张三",
            inputText: "",
            users: [{
                avatarSrc: "../static/img/avatar/defaultAvatar.jpg",
                userName: "李三",
                dynamicInformation: "番职网讯：（杨娇、司金芽报道）6月18日下午，管理学院通过腾讯会议举行2019-2020学年第二学期考前动员会，副院长胡子瑜、辅导员杨娇、党政办公室吴保茹以及各班学生代表共100多人参加会议。会上，胡子瑜指出，考风是衡量一个学校学风建设的重要指标，希望全体学生以诚信为本，守住底线，认真备考，考出佳绩。同时，她强调，处分不是目的，教育才是本真，关键在于提高学生的自立和自律意识。随后，杨娇宣读尚未解除处分的学生名单，劝诫各位同学引以为戒，自觉遵守各项规章制度，做到零违纪、零处分，共同维护学院学风学貌。接着，学生代表宣读倡议书，号召同学们在考试中自觉遵守考场纪律，展现自我真实水平。最后，班级学生代表集体宣誓，以诚信塑造品格，以诚信收获成功，以最好的心态取得优异成绩，并庄严地签下了承诺书。此次动员大会旨在深入落实学院学风建设，同时也深化了学子“自立自强，遵守考风考纪”的纪律意识。",
                dynamicPic: ""
            }, {
                avatarSrc: "../static/img/avatar/defaultAvatar.jpg",
                userName: "李四",
                dynamicInformation: "软件技术大赛副主持空缺，原主持带着她的小椅子跑了，紧急招人！！！",
                dynamicPic: "../static/img/cat.jpg"
            }, {
                avatarSrc: "../static/img/avatar/defaultAvatar.jpg",
                userName: "某人工智障搬运工",
                dynamicInformation: "日常来一发：花Q！！！",
                dynamicPic: ""
            }, {
                avatarSrc: "../static/img/avatar/defaultAvatar.jpg",
                userName: "jo厨",
                dynamicInformation: "《JOJO的奇妙冒险》是由日本漫画家荒木飞吕彦所创作的漫画作品，简称JOJO。其凛冽的画风，令人惊叹的剧情，这么多年以来几乎不会让人感到厌倦，是青少年漫画的必看作之一。至2016年单行本累计销量超过一亿册，曾在2006年日本文化厅媒体艺术节中评选为第二佳漫画，现连载已有八部作品。",
                dynamicPic: ""
            },
            ]
        },
        methods: {
            submitDynamic: function () {
                this.users.push({
                    avatarSrc: this.activeUserAvatar,
                    userName: this.activeUserName,
                    dynamicInformation: this.inputText
                });
            },
            openMoreNarBar: function (index) {
                let $moreNarBar = jQuery(".moreNarBar");
                console.log(index+$moreNarBar+this.close);
                if (index != this.close) {
                    $moreNarBar.eq(this.close).css({ display: "none" })
                    $moreNarBar.eq(index).css({ display: "flex" })
                } else if ($moreNarBar.eq(index).css("display") == "none" && index == this.close) {
                    $moreNarBar.eq(index).css({ display: "flex" })
                } else if ($moreNarBar.eq(index).css("display") == "flex" && index == this.close) {
                    $moreNarBar.eq(index).css({ display: "none" })
                }
                this.close = index;
            }
        },
    });
});