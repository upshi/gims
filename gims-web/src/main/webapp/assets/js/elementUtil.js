/*初始化*/
function eleInit(tag, uuid) {
    var ele = {
        tag : tag ,
        uuid : uuid,
        name : '',
        columnName : '',
        isRequired : '',
        isVisible : '',
        hasCode : '',
        description : ''
    }

    //if(ele.tag == 0 || ele.tag == 3 || ele.tag == 5 || ele.tag == 6 || ele.tag == 7 || ele.tag == 9 || ele.tag == 11) {}
    if(ele.tag == 8) {
        ele.telDelimiter = '';
    }
    if(ele.tag == 10) {
        ele.dateDelimiter = '';
    }
    if(ele.tag == 15) {
        ele.tire = '';
    }
    if(ele.tag == 12 || ele.tag == 13) {
        ele.layout = '';
    }
    if(ele.tag == 14) {
        ele.innerWidth = '';
    }
    if(ele.tag == 1) {
        ele.defaultValue = '';
        ele.width = '';
    }
    if(ele.tag == 2) {
        ele.defaultValue = '';
        ele.rows = '';
        ele.width = '';
    }
    if(ele.tag == 4) {
        ele.isInteger = '';
        ele.minValue = '';
        ele.maxValue = '';
        ele.defaultValue = '';
        ele.innerWidth = '';
    }

    return ele;
}

/*生成uuid*/
function guid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    }

    return s4() + s4() + s4() + s4();
}

/* 设置中间和右边窗口的初始高度 */
var middleHeight = $(window).height() - 150;
$('.section_middle_content').css({"max-height":middleHeight});

var rightHeight = $(window).height() - 100;
$('.section_right_content').css({"max-height":rightHeight});

/* 监听中间和右边窗口的高度是否发生改变，如果改变，自动调整为当前窗口的高度 */
$(window).bind("resize",function() {
    var middleHeight = $(window).height() - 150;
    $('.section_middle_content').css({"max-height":middleHeight});

    var rightHeight = $(window).height() - 100;
    $('.section_right_content').css({"max-height":rightHeight});
});

