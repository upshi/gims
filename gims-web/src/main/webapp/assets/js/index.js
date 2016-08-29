sessionStorage.clear();

var myApp = angular.module('myApp', []);
myApp.controller('appController', function ($scope) {
    $scope.sheet = {
        sheetName: '表单名称',
        widthFull: true,
        widthHalf: true
    };
});

/*定义拖拽时，sortable 项目被约束的边界*/
$('#drop').sortable({
    containment: "parent"
});

var li = $(".section_left_content").children('li');

$(li).on('click', function () {
    var tag = $(this).attr('tag');
    $('#drop').append(elements[tag]);
    /*自动生成元素唯一的标识uuid*/
    var uuid = guid();
    /*为每个新添加的元素添加uuid属性*/
    $("#drop li:last-child").attr("uuid", uuid);

    var ele = eleInit(tag, uuid);//数组初始化，保存元素的所有属性和对应的值
    sessionStorage.setItem(uuid, JSON.stringify(ele));
    addClassHandle();
});

function addClassHandle() {
    $("#drop li:last-child").click(function () {
        $(this).focus();
        $(this).siblings('li').removeClass('elementClick'); // 删除其他兄弟元素的样式
        $(this).addClass('elementClick'); // 添加当前元素的样式

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
            if($(n).val() == ele[name]) {
                $(n).prop('checked', 'checked');//jquery1.9以上不能用attr()
                console.log($(n));
            } else {
                $(n).removeAttr('checked');
            }
        });

        /*给所有的select绑定change事件*/
        $('.elementSelect').off('change');
        $('.elementSelect').on('change', function () {
            ele[$(this).attr('name')] = $(this).val();
            sessionStorage.setItem(uuid, JSON.stringify(ele));
        });
        /* 把右边区域的值更新为当前ele里的值 */
        $.each($('.elementSelect'), function (i, n) {
            var name = $(n).attr('name');
            /*遍历当前select下的所有option，比较option的值和ele的是否相同*/
            $.each($(this).children('option'), function (index,opt) {
                if($(opt).val() == ele[name]) {
                    $(opt).attr('selected', 'selected');
                    $(opt).siblings().removeAttr('selected');//移除其他option的selected
                    return false;//跳出循环
                }
            })
        });
    });

    $("#drop li:last-child").mouseover(function () {
        $(this).siblings('li').removeClass('elementHover'); // 删除其他兄弟元素的样式
        $(this).addClass('elementHover'); // 添加当前元素的样式
    });
}