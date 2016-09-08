sessionStorage.clear();

var myApp = angular.module('myApp', []);
myApp.controller('appController', function ($scope) {
    $scope.sheet = {
        sheetName: '表单名称',
        widthFull: true,
        widthHalf: true
    };

    $scope.onclick = function (tag) {
        $('#drop').append(elements[tag]);
        /*自动生成元素唯一的标识uuid*/
        var uuid = guid();
        /*为每个新添加的元素添加uuid属性*/
        $("#drop li:last-child").attr("uuid", uuid);

        var ele = eleInit(tag, uuid);//数组初始化，保存元素的所有属性和对应的值
        sessionStorage.setItem(uuid, JSON.stringify(ele));
        addClassHandle();
    };
});

/*定义拖拽时，sortable 项目被约束的边界*/
$('#drop').sortable({
    containment: "parent"
});

function addClassHandle() {
    /* 为每个中间的li标签添加点击事件 */
    $("#drop li:last-child").click(clickHandle);

    $("#drop li:last-child").mouseover(function () {
        $(this).siblings('li').removeClass('elementHover'); // 删除其他兄弟元素的样式
        $(this).addClass('elementHover'); // 添加当前元素的样式
    });
}

var clickHandle = function () {
    $('img').remove();
    var currentLi = this;
    $(this).focus();
    $(this).siblings('li').removeClass('elementClick'); // 删除其他兄弟元素的样式
    $(this).addClass('elementClick'); // 添加当前元素的样式

    $(this).append('<img onclick="addEle(this)" src="assets/images/add.png" alt="复制" data-toggle="tooltip" data-placement="bottom" title="复制" style="position:absolute;bottom:-10px;right:40px;">');
    $(this).append('<img onclick="delEle(this)" src="assets/images/subtract.png" alt="删除" data-toggle="tooltip" data-placement="bottom" title="删除" style="position:absolute;bottom:-10px;right:10px;">');

    /*获取当前点击元素的tag值*/
    var tag = $(this).attr('tag');
    /*将右边非公共属性删除，公共属性有6个，下标从0开始*/
    $('.section_right_content').children('div').eq(5).nextAll().remove();
    /*遍历mapper这个二维数组，获取当前元素类型：标签、单行文本...在右边追加其对应的属性*/
    $.each(mapper[tag], function (i, n) {
        $('.section_right_content').append(attributes[n]);
    })

    var uuid = $(this).attr('uuid');
    var ele = JSON.parse(sessionStorage.getItem(uuid));

    /* 给所有输入框绑定失焦事件，将最新的值保存到sessionStorage中 */
    $('.elementText').off('blur');
    $('.elementText').on('blur', function () {
        ele[$(this).attr('name')] = $(this).val();
        sessionStorage.setItem(uuid, JSON.stringify(ele));
        /* 如果当前是name输入框，修改中间对应的显示的值 */
        if ($(this).attr('name') == 'name') {
            $(currentLi).find('p').first().html($(this).val());
        }
    });
    /* 把右边区域的值更新为当前ele里的值 */
    $.each($('.elementText'), function (i, n) {
        var name = $(n).attr('name');
        $(n).val(ele[name]);
    });

    /*给所有的radio绑定change事件*/
    $('.elementRadio').off('change');
    $('.elementRadio').on('change', function () {
        ele[$(this).attr('name')] = $(this).val();
        sessionStorage.setItem(uuid, JSON.stringify(ele));
    });
    /* 把右边区域的值更新为当前ele里的值 */
    $.each($('.elementRadio'), function (i, n) {
        var name = $(n).attr('name');
        if ($(n).val() == ele[name]) {
            $(n).prop('checked', 'checked');//jquery1.9以上不能用attr()
        } else {
            $(n).removeAttr('checked');
        }
    });

    /*给所有的select绑定change事件*/
    $('.elementSelect').off('change');
    $('.elementSelect').on('change', function () {
        ele[$(this).attr('name')] = $(this).val();
        sessionStorage.setItem(uuid, JSON.stringify(ele));

        /* 宽度：2-整行；1-整行的1/2，0-整行的1/3 */
        if ($(this).attr('name') == 'width') {
            $(currentLi).find('input').removeClass();
            if (ele.width == 2) {
                $(currentLi).find('input').addClass('longElement');
            } else if (ele.width == 1) {
                $(currentLi).find('input').addClass('middleElement');
            } else {
                $(currentLi).find('input').addClass('shortElement');
            }
        }

        /* 内宽：2-长；1-中，0-短 */
        if ($(this).attr('name') == 'innerWidth') {
            $(currentLi).find('input').removeClass();
            $(currentLi).find('select').removeClass();
            if (ele.innerWidth == 2) {
                $(currentLi).find('input').addClass('middleElement');
                $(currentLi).find('select').addClass('middleElement');
            } else if (ele.innerWidth == 1) {
                $(currentLi).find('input').addClass('shortElement');
                $(currentLi).find('select').addClass('shortElement');
            } else {
                $(currentLi).find('input').addClass('shorterElement');
                $(currentLi).find('select').addClass('shorterElement');
            }
        }

        /* 布局：0-自由，1-1列，2-2列，3-3列 */
        if ($(this).attr('name') == 'layout') {
            if (ele.layout == 2) {
                $($(currentLi)[0]).removeAttr("style");
                $($(currentLi).find('span')[0]).removeAttr("style");
                $($(currentLi).find('span')[1]).removeAttr("style");
                $($(currentLi).find('span')[2]).removeAttr("style");
                $($(currentLi).find('span')[2]).css({"float": "left","margin-top": "-66px","margin-left": "300px"});
            } else if (ele.layout == 3) {
                $($(currentLi)[0]).removeAttr("style");
                $($(currentLi).find('span')[0]).removeAttr("style");
                $($(currentLi).find('span')[1]).removeAttr("style");
                $($(currentLi).find('span')[2]).removeAttr("style");
                $($(currentLi).find('span')[0]).css({"margin-left": "0"});
                $($(currentLi).find('span')[1]).css({"float": "left", "margin": "-33px 100px 0 150px"});
                $($(currentLi).find('span')[2]).css({"float": "left","margin-left": "300px","margin-top": "-33px"});
            } else if(ele.layout == 0) {
                $($(currentLi)[0]).removeAttr("style");
                $($(currentLi).find('span')[0]).removeAttr("style");
                $($(currentLi).find('span')[1]).removeAttr("style");
                $($(currentLi).find('span')[2]).removeAttr("style");
                $($(currentLi)[0]).css({"height":"70px"});
                $($(currentLi).find('span')[0]).css({"float": "left","margin":"0 10px 0 0"});
                $($(currentLi).find('span')[1]).css({"float": "left","margin":"0 10px 0 0"});
                $($(currentLi).find('span')[2]).css({"float": "left","margin":"0 10px 0 0"});
            }else{
                $($(currentLi)[0]).removeAttr("style");
                $($(currentLi).find('span')[0]).removeAttr("style");
                $($(currentLi).find('span')[1]).removeAttr("style");
                $($(currentLi).find('span')[2]).removeAttr("style");
            }
        }
        /* 多级下拉框的层级：2-2级，3-3级，4-4级 */
        if ($(this).attr('name') == 'tire') {
            if(ele.tire == 3) {
                $($(currentLi)[0]).children('select').eq(1).nextAll().remove();
                $('.pullDown').css({"width":"270px"});
                $($(currentLi)[0]).append('<select class="pullDown" disabled></select>');
                $('.pullDown').css({"width":"183px"});
            } else if(ele.tire == 4) {
                $($(currentLi)[0]).children('select').eq(1).nextAll().remove();
                $('.pullDown').css({"width":"270px"});
                $($(currentLi)[0]).append('<select class="pullDown" disabled></select>');
                $($(currentLi)[0]).append('<select class="pullDown" disabled></select>');
                $('.pullDown').css({"width":"137px"});
            } else {
                $($(currentLi)[0]).children('select').eq(1).nextAll().remove();
                $('.pullDown').css({"width":"270px"});
            }
        }
    });
    /* 把右边区域的值更新为当前ele里的值 */
    $.each($('.elementSelect'), function (i, n) {
        var name = $(n).attr('name');
        /*遍历当前select下的所有option，比较option的值和ele的是否相同*/
        $.each($(this).children('option'), function (index, opt) {
            if ($(opt).val() == ele[name]) {
                $(opt).attr('selected', 'selected');
                $(opt).siblings().removeAttr('selected');//移除其他option的selected
                return false;//跳出循环;
            }
        })
    });
}

/* 点击中间li标签的"+"，添加一个相同li元素 */
function addEle(e) {
    var tag = $(e).parent().attr('tag');
    $(e).parent().after(elements[tag]);

    /*自动生成元素唯一的标识uuid*/
    var uuid = guid();
    /*为每个新添加的元素添加uuid属性*/
    $(e).parent().next().attr("uuid", uuid);

    var ele = eleInit(tag, uuid);//数组初始化，保存元素的所有属性和对应的值
    sessionStorage.setItem(uuid, JSON.stringify(ele));
    $(e).parent().next().click(clickHandle);
}

/* 点击中间li标签的"-"，删除当前li元素 */
function delEle(e) {
    $(e).parent().remove();
    /* 删除sessionStorage里保存的数据 */
    sessionStorage.removeItem($(e).parent().attr('uuid'));
}