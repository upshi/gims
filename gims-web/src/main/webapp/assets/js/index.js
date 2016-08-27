/*读取json文件，获得所有的标签*/
var json =
[
    "<li><p>标签</p><p class='labelDis'>这里是标签的描述</p></li>",
    "<li><p>单行文本</p><input readonly type='text'></li>",
    "<li class='multiText'><p>多行文本</p><textarea row='3' disabled></textarea></li>",
    "<li><p>电子邮箱</p><input readonly type='text'></li>",
    "<li><p>数字框</p><input readonly type='text'></li>",
    "<li><p>身份证号</p><input readonly type='text'></li>",
    "<li><p>邮政编码</p><input readonly type='text'></li>",
    "<li><p>移动电话</p><input readonly type='text'></li>",
    "<li><p>座机</p><input readonly type='text'></li>",
    "<li><p>地址</p><input readonly type='text'></li>",
    "<li class='special'><p>日期</p><span><input type='text' placeholder='年' readonly><label>-</label></span><span><input type='text' placeholder='月' readonly><label>-</label></span><span><input type='text' placeholder='日' readonly></span></li>",
    "<li><p>年龄</p><select class='age' disabled></select></li>",
    "<li class='choose'><p>单选框</p><span><input type='radio' disabled>选项1</span><span><input type='radio' disabled>选项2</span><span><input type='radio' disabled>选项3</span></li>",
    "<li class='choose'><p>多选框</p><span><input type='checkbox' disabled>选项1</span><span><input type='checkbox' disabled>选项2</span><span><input type='checkbox' disabled>选项3</span></li>",
    "<li><p>下拉框</p><select class='pullDown' disabled></select></li>",
    "<li><p>多级下拉框</p><select class='pullDown' disabled></select><select class='pullDown' disabled></select></li>"
]

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
    var eleTag = $(this).attr('tag');
    $('#drop').append(json[eleTag]);
    addClassHandle();
});

function addClassHandle() {
    $("#drop li:last-child").click(function () {
        $(this).focus();
        $(this).siblings('li').removeClass('elementClick'); // 删除其他兄弟元素的样式
        $(this).addClass('elementClick'); // 添加当前元素的样式
        console.log($($(this).children('p')[0]).text());
    });

    $("#drop li:last-child").mouseover(function () {
        $(this).siblings('li').removeClass('elementHover'); // 删除其他兄弟元素的样式
        $(this).addClass('elementHover'); // 添加当前元素的样式
    });
}