var elements =
    [
        "<li tabindex='1' tag='0'><p>标签</p><p class='labelDis'>这里是标签的描述</p></li>",
        "<li tabindex='1' tag='1'><p>单行文本</p><input readonly type='text' class='longElement'></li>",
        "<li tabindex='1' tag='2' class='multiText'><p>多行文本</p><textarea row='3' disabled></textarea></li>",
        "<li tabindex='1' tag='3'><p>电子邮箱</p><input readonly type='text' class='middleElement'></li>",
        "<li tabindex='1' tag='4'><p>数字框</p><input readonly type='text' class='middleElement'></li>",
        "<li tabindex='1' tag='5'><p>身份证号</p><input readonly type='text' class='middleElement'></li>",
        "<li tabindex='1' tag='6'><p>邮政编码</p><input readonly type='text' class='shortElement'></li>",
        "<li tabindex='1' tag='7'><p>移动电话</p><input readonly type='text' class='shortElement'></li>",
        "<li tabindex='1' tag='8' class='special'><p>座机</p><span><input type='text' placeholder='区号' readonly>&nbsp;<b>-</b>&nbsp;</span><span><input type='text' placeholder='号码' class='shortElement'readonly>&nbsp;<b>-</b>&nbsp;</span><span><input type='text' placeholder='分机号' readonly></span></li>",
        "<li tabindex='1' tag='9'><p>地址</p><select class='address' disabled></select><select class='address' disabled></select><select class='address' disabled></select><input readonly type='text' placeholder='详细地址'></li>",
        "<li tabindex='1' tag='10' class='special'><p>日期</p><span><input type='text' placeholder='年' readonly>&nbsp;<b>-</b>&nbsp;</span><span><input type='text' placeholder='月' readonly>&nbsp;<b>-</b>&nbsp;</span><span><input type='text' placeholder='日' readonly></span></li>",
        "<li tabindex='1' tag='11'><p>年龄</p><select class='age' disabled></select></li>",
        "<li tabindex='1' tag='12' class='choose'><p>单选框</p><span><input type='radio' disabled>选项1</span><span><input type='radio' disabled>选项2</span><span><input type='radio' disabled>选项3</span></li>",
        "<li tabindex='1' tag='13' class='choose'><p>多选框</p><span><input type='checkbox' disabled>选项1</span><span><input type='checkbox' disabled>选项2</span><span><input type='checkbox' disabled>选项3</span></li>",
        "<li tabindex='1' tag='14'><p>下拉框</p><select disabled class='middleElement'></select></li>",
        "<li tabindex='1' tag='15'><p>多级下拉框</p><select class='pullDown' disabled></select><select class='pullDown' disabled></select></li>"
    ]
var attributes =
    [
        "<div class='form-group'><label class='control-label'>是否整数<span>&nbsp;(?)</span></label><br><label class='radio-inline'><input type='radio' value='1' name='isInteger' class='elementRadio'>是</label><label class='radio-inline'><input type='radio' value='0' name='isInteger' class='elementRadio'>否</label></div>",
        "<div class='form-group'><label class='control-label'>最小值<span>&nbsp;(?)</span></label><input class='form-control elementText' type='text' name='minValue'></div>",
        "<div class='form-group'><label class='control-label'>最大值<span>&nbsp;(?)</span></label><input class='form-control elementText' type='text' name='maxValue'></div>",
        "<div class='form-group'><label class='control-label'>最小长度<span>&nbsp;(?)</span></label><input class='form-control elementText' type='text' name='minLength'></div>",
        "<div class='form-group'><label class='control-label'>最大长度<span>&nbsp;(?)</span></label><input class='form-control elementText' type='text' name='maxLength'></div>",
        "<div class='form-group'><label class='control-label'>默认值<span>&nbsp;(?)</span></label><input class='form-control elementText' type='text' name='defaultValue'></div>",
        "<div class='form-group'><label class='control-label'>多行文本的行数<span>&nbsp;(?)</span></label><select class='form-control elementSelect' name='rows'><option value='3' selected>3</option><option value='5'>5</option><option value='10'>10</option><option value='15'>15</option><option value='20'>20</option></select></div>",
        "<div class='form-group'><label class='control-label'>宽度<span>&nbsp;(?)</span></label><select class='form-control elementSelect' name='width'><option value='2' selected>充满整行</option><option value='1'>整行的1/2</option><option value='0'>整行的1/3</option></select></div>",
        "<div class='form-group'><label class='control-label'>内宽<span>&nbsp;(?)</span></label><select class='form-control elementSelect' name='innerWidth'><option value='0'>短</option><option value='1'>中</option><option value='2' selected>长</option></select></div>",
        "<div class='form-group'><label class='control-label'>分隔符<span>&nbsp;(?)</span></label><select class='form-control elementSelect' name='telDelimiter'><option value='' selected>无</option><option value='-'>-</option><option value='()'>()</option></select></div>",
        "<div class='form-group'><label class='control-label'>分隔符<span>&nbsp;(?)</span></label><select class='form-control elementSelect' name='dateDelimiter'><option value='' selected>无</option><option value='-'>-</option><option value='/'>/</option></select></div>",
        "<div class='form-group'><label class='control-label'>布局<span>&nbsp;(?)</span></label><select class='form-control elementSelect' name='layout'><option value='1'>一列</option><option value='2'>两列</option><option value='3'>三列</option><option value='0'>自由</option></select></div>",
        "<div class='form-group'><label class='control-label'>层级<span>&nbsp;(?)</span></label><select class='form-control elementSelect' name='tire'><option value='2' selected>两级</option><option value='3'>三级</option><option value='4'>四级</option></select></div>"
    ]
var mapper = [
    [],//0
    [5, 7],//1
    [5, 6],//2
    [],//3
    [0, 1, 2, 5, 8],//4
    [],//5
    [],//6
    [],//7
    [9],//8
    [],//9
    [10],//10
    [],//11
    [11],//12
    [11],//13
    [8],//14
    [12]//15
]