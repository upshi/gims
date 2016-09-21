var adminController = angular.module('collegeController', []);

/* 年级管理 */
adminController.controller('gradeListController', ['$scope', '$http', '$httpParamSerializerJQLike', function ($scope, $http, $httpParamSerializerJQLike) {
    $scope.init = function () {
        $http({
            method: 'POST',
            url: 'api/teachClass/gradeList',
            cache: false
        }).success(function (data) {
            $scope.grades = data.grades;
        });
    };

    $scope.newTeachClass = {
        grade: '',
        error: false,
        msg: ''
    };

    $scope.checkGradeName = function () {
        var error = false;
        $.each($scope.grades, function (i, n) {
            if ($scope.newTeachClass.grade == n.grade) {
                error = true;
                $scope.newTeachClass.error = true;
                $scope.newTeachClass.msg = '该年级已经存在';
                return false;
            }
        });

        if (!error) {
            $scope.newTeachClass.error = false;
        }
    }

    $scope.addGrade = function () {
        if (!$scope.newTeachClass.error) {
            $http({
                method: 'POST',
                url: 'api/teachClass/addGrade',
                data: $httpParamSerializerJQLike({grade: $scope.newTeachClass.grade}),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                cache: false
            }).success(function () {
                location.reload();
            });
        }
    }
}]);

adminController.controller('studentListController', ['$scope', '$http', 'Upload', '$httpParamSerializerJQLike',
                                            function ($scope, $http, Upload, $httpParamSerializerJQLike) {

    $scope.currentPage = 1;
    $scope.maxSize = 10;
    $scope.pageCount = 10;

    $scope.init = function () {
        $http({
            method: 'POST',
            url: 'api/student/studentList',
            cache: false
        }).success(function (data) {
            $scope.students = data.students;
            $scope.totals = data.totals;
        });
    };

    $scope.pageChanged = function() {
        $http({
            method: 'POST',
            url: 'api/student/studentList',
            data: $httpParamSerializerJQLike({page: $scope.currentPage, size:$scope.pageCount}),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            cache: false
        }).success(function (data) {
            $scope.students = data.students;
            $scope.totals = data.totals;
        });
    };

    $scope.upload = function() {
        console.log('in');
        Upload.upload({
            url: 'api/student/upload',
            fields: {'username': 'zouroto'}, // additional data to send
            file: $scope.file
        }).progress(function (evt) {
            var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
            console.log('progress: ' + progressPercentage + '% ' + evt.config.file.name);
        }).success(function (data, status, headers, config) {
            console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
        });
    };


}]);

adminController.controller('majorListController', ['$scope', '$http', '$filter', '$stateParams', '$httpParamSerializerJQLike',
    function ($scope, $http, $filter, $stateParams, $httpParamSerializerJQLike) {
        $scope.grade = $stateParams.grade;

        $scope.init = function () {
            $http({
                method: 'POST',
                url: 'api/teachClass/majorList',
                cache: false,
                data: $httpParamSerializerJQLike({grade: $scope.grade}),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
            }).success(function (data) {
                $scope.majors = $filter('filterEmpty')(data.majors, 'major');
            });
        };

        $scope.newTeachClass = {
            major: '',
            error: false,
            msg: ''
        };

        $scope.checkMajorName = function () {
            var error = false;
            $.each($scope.majors, function (i, n) {
                if ($scope.newTeachClass.major == n.major) {
                    error = true;
                    $scope.newTeachClass.error = true;
                    $scope.newTeachClass.msg = '该专业已经存在';
                    return false;
                }
            });

            if (!error) {
                $scope.newTeachClass.error = false;
            }
        }

        $scope.addMajor = function () {
            if (!$scope.newTeachClass.error) {
                $http({
                    method: 'POST',
                    url: 'api/teachClass/addMajor',
                    data: $httpParamSerializerJQLike({grade: $scope.grade, major: $scope.newTeachClass.major}),
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    cache: false
                }).success(function () {
                    location.reload();
                });
            }
        }
    }]);

adminController.controller('clazzListController', ['$scope', '$http', '$filter', '$stateParams', '$httpParamSerializerJQLike', function ($scope, $http, $filter, $stateParams, $httpParamSerializerJQLike) {
    $scope.grade = $stateParams.grade;
    $scope.major = $stateParams.major;

    $scope.init = function () {
        $http({
            method: 'POST',
            url: 'api/teachClass/clazzList',
            cache: false,
            data: $httpParamSerializerJQLike({grade: $scope.grade, major: $scope.major}),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
        }).success(function (data) {
            $scope.clazzs = $filter('filterEmpty')(data.clazzs, 'clazz');
        });
    };

    $scope.newTeachClass = {
        clazz: '',
        error: false,
        msg: ''
    };

    $scope.checkClazzName = function () {
        var error = false;
        $.each($scope.clazzs, function (i, n) {
            if ($scope.newTeachClass.clazz == n.clazz) {
                error = true;
                $scope.newTeachClass.error = true;
                $scope.newTeachClass.msg = '该班级已经存在';
                return false;
            }
        });

        if (!error) {
            $scope.newTeachClass.error = false;
        }
    }

    $scope.addClazz = function () {
        if (!$scope.newTeachClass.error) {
            $http({
                method: 'POST',
                url: 'api/teachClass/addClazz',
                data: $httpParamSerializerJQLike({
                    grade: $scope.grade,
                    major: $scope.major,
                    clazz: $scope.newTeachClass.clazz
                }),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                cache: false
            }).success(function () {
                location.reload();
            });
        }
    }
}]);

adminController.controller('createSheetController', ['$scope', '$http', '$filter', '$state', '$stateParams', '$httpParamSerializerJQLike', function ($scope, $http, $filter, $state, $stateParams, $httpParamSerializerJQLike) {
    $scope.init = function () {
        $http({
            method: 'POST',
            url: 'api/teachClass/gradeList',
            cache: false
        }).success(function (data) {
            $scope.grades = data.grades;
        });
    };

    $scope.sheet = {
        name : '',
        grade : ''
    };

    $scope.errorMsg = {
        error: false,
        msg: ''
    };

    $scope.checkName = function () {
        $http({
            method: 'POST',
            url: 'api/sheet/checkName',
            data: $httpParamSerializerJQLike({name: $scope.sheet.name}),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            cache: false
        }).success(function (data) {
            if (data.exist === 1) {
                $scope.errorMsg.msg = '您输入统计表名称已存在';
                $scope.errorMsg.error = true;
                return false;
            } else {
                $scope.errorMsg.error = false;
            }
        });
    }

    $scope.createSheet = function () {
        if (!$scope.errorMsg.error) {
            $http({
                method: 'POST',
                url: 'api/sheet/create',
                data: $httpParamSerializerJQLike($scope.sheet),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                cache: false
            }).success(function (data) {
                alert('创建成功');
                $state.go('index.sheet.designSheet', {'sheetId' : data.newSheet.id});
            });
        }
    }
}]);

adminController.controller('designSheetController', ['$scope', '$http', '$filter', '$state', '$stateParams', '$httpParamSerializerJQLike', function ($scope, $http, $filter, $state, $stateParams, $httpParamSerializerJQLike) {

    $scope.sheetId = $stateParams.sheetId;
    $scope.elements = {};

    $scope.onItemClick = function (tag) {
        $('#drop').append(items[tag]);
        /*自动生成元素唯一的标识uuid*/
        var uuid = guid();
        /*为每个新添加的元素添加uuid属性*/
        $("#drop li:last-child").attr("uuid", uuid);

        var ele = eleInit(tag, uuid);//数组初始化，保存元素的所有属性和对应的值
        ele.sheetId = $scope.sheetId;
        $scope.elements[uuid] = ele;

        /* 为每个中间的li标签添加点击事件 */
        $("#drop li:last-child").on('click', onElementClick);
        $("#drop li:last-child").mouseover(function () {
            $(this).siblings('li').removeClass('elementHover'); // 删除其他兄弟元素的样式
            $(this).addClass('elementHover'); // 添加当前元素的样式
        });
    };

    /*定义拖拽时，sortable 项目被约束的边界*/
    $('#drop').sortable({
        containment: "parent"
    });

    var onElementClick = function () {
        $('img').remove();
        var currentLi = this;
        $(this).focus();
        $(this).siblings('li').removeClass('elementClick'); // 删除其他兄弟元素的样式
        $(this).addClass('elementClick'); // 添加当前元素的样式

        $(this).append('<img src="assets/images/add.png" alt="复制" data-toggle="tooltip" data-placement="bottom" title="复制" style="position:absolute;bottom:-10px;right:40px;">');
        $(this).append('<img src="assets/images/subtract.png" alt="删除" data-toggle="tooltip" data-placement="bottom" title="删除" style="position:absolute;bottom:-10px;right:10px;">');

        $($(this).find('img')[0]).on('click', addEle);
        $($(this).find('img')[1]).on('click', delEle);

        /*获取当前点击元素的tag值*/
        var tag = $(this).attr('tag');
        /*将右边非公共属性删除，公共属性有6个，下标从0开始*/
        $('.section_right_content').children('div').eq(5).nextAll().remove();
        /*遍历mapper这个二维数组，获取当前元素类型：标签、单行文本...在右边追加其对应的属性*/
        $.each(mapper[tag], function (i, n) {
            $('.section_right_content').append(attributes[n]);
        })

        var uuid = $(this).attr('uuid');
        // var ele = JSON.parse(sessionStorage.getItem(uuid));
        var ele = $scope.elements[uuid];

        /* 给所有输入框绑定失焦事件，将最新的值保存到sessionStorage中 */
        $('.elementText').off('blur');
        $('.elementText').on('blur', function () {
            ele[$(this).attr('name')] = $(this).val();
            // sessionStorage.setItem(uuid, JSON.stringify(ele));
            $scope.elements[uuid] = ele;
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
            // sessionStorage.setItem(uuid, JSON.stringify(ele));
            $scope.elements[uuid] = ele;
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
            // sessionStorage.setItem(uuid, JSON.stringify(ele));
            $scope.elements[uuid] = ele;

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
    function addEle() {
        var tag = $(this).parent().attr('tag');
        $(this).parent().after(items[tag]);

        /*自动生成元素唯一的标识uuid*/
        var uuid = guid();
        /*为每个新添加的元素添加uuid属性*/
        $(this).parent().next().attr("uuid", uuid);

        var ele = eleInit(tag, uuid);//数组初始化，保存元素的所有属性和对应的值
        // sessionStorage.setItem(uuid, JSON.stringify(ele));
        $scope.elements[uuid] = ele;
        $(this).parent().next().click(onElementClick);
    }

    /* 点击中间li标签的"-"，删除当前li元素 */
    function delEle() {
        $(this).parent().remove();
        /* 删除sessionStorage里保存的数据 */
        // sessionStorage.removeItem($(e).parent().attr('uuid'));
        delete $scope.elements[$(this).parent().attr('uuid')];
        console.log($scope.elements);
    }

    $scope.save = function () {
        var lis = $('#drop').children('li');
        var data = [];
        angular.forEach($(lis), function (li, index) {
            var uuid = $(li).attr('uuid');
            $scope.elements[uuid].seq = index + 1;
            data.push($scope.elements[uuid]);
        });

        $http({
            method : 'POST',
            url : 'api/sheet/design',
            data: JSON.stringify(data),
            cache : false
        }).success(function(data){

        });
    }

}]);

adminController.controller('sheetListController', ['$scope', '$http', '$httpParamSerializerJQLike', function ($scope, $http, $httpParamSerializerJQLike) {
    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/sheet/sheetList',
            cache : false
        }).success(function(data){
            $scope.sheets = data.sheets;
        });
    };
}]);

adminController.controller('updateSheetController', ['$scope', '$http', '$filter', '$state', '$stateParams', '$httpParamSerializerJQLike', function ($scope, $http, $filter, $state, $stateParams, $httpParamSerializerJQLike) {

    $scope.sheetId = $stateParams.sheetId;
    
    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/sheet/getSheet',
            data: $httpParamSerializerJQLike({sheetId: $scope.sheetId}),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            cache : false
        }).success(function(data){
            if(data.result === 'success') {
                $scope.sheet = data.sheet;
                $scope.elements = data.elements;
            } else {
                $state.go('index.sheet.sheetList');
            }
        });
    }

}]);


/*
 * 设置
 */
