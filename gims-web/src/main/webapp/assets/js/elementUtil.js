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

    //if(ele.tag == 0 || ele.tag == 3 || ele.tag == 5 || ele.tag == 6 || ele.tag == 7 || ele.tag == 9 || ele.tag == 11 || ele.tag == 15) {}
    if(ele.tag == 8) {
        ele.telDelimiter = '';
    }
    if(ele.tag == 10) {
        ele.dateDelimiter = '';
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