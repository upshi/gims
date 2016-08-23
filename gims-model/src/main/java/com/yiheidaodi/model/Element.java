package com.yiheidaodi.model;

/**
 * gims com.yiheidaodi.model.element
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-23 17:28.
 */

public class Element {

    /*
    * 0 => false
    * 1 => true
    * /

    /* 宽度 */
    public static final Integer WIDTH_HALF = 0;
    public static final Integer WIDTH_FULL = 1;

    /* 内宽 */

    public static final Integer INNER_WIDTH_SHORT = 0;
    public static final Integer INNER_WIDTH_MIDDLE = 1;
    public static final Integer INNER_WIDTH_LONG = 2;

    /* 分隔符 */
    public static final String DELIMITER_NONE = "";
    public static final String DELIMITER_MINUS = "-";
    public static final String DELIMITER_SLASH = "/";
    public static final String DELIMITER_PAREN = "()";

    /* 布局 */
    public static final Integer LAYOUT_FREE = 0;
    public static final Integer LAYOUT_SINGLE = 1;
    public static final Integer LAYOUT_DOUBLE = 2;
    public static final Integer LAYOUT_TRIPLE = 3;

    /* 类型 */
    public static final Integer TYPE_LABEL = 0;
    public static final Integer TYPE_SINGLE_TEXT = 1;
    public static final Integer TYPE_MULTI_TEXT = 2;
    public static final Integer TYPE_EMAIL = 3;


    public static final Integer TYPE_NUMBER = 4;
    public static final Integer TYPE_IDENTITY_NUMBER = 5;
    public static final Integer TYPE_ZIPCODE = 55;
    public static final Integer TYPE_MOBILEPHONE = 6;
    public static final Integer TYPE_TELEPHONE = 7;

    public static final Integer TYPE_ADDRESS = 8;
    public static final Integer TYPE_DATE = 9;
    public static final Integer TYPE_AGE = 10;

    public static final Integer TYPE_SINGLE_RADIO = 11;
    public static final Integer TYPE_MULTI_CHECKBOX = 12;
    public static final Integer TYPE_SINGLE_SELECT = 13;
    public static final Integer TYPE_MULTI_SELECT = 14;




    private String id;
    private String name;    //元素名
    private String columnName;  //列名
    private Integer width;   //宽度
    private Integer isRequired;     //是否必须
    private String defaultValue;    //默认值
    private Integer hasCode;    //是否有对应代码
    private Integer hasUploaded;    //是否已上传对应代码
    private String description;  //描述


    private String rows;    //多行文本框的行数
    private Integer isInteger;  //数字元素数字是否是整数
    private Integer minValue;   //数字元素的最小值
    private Integer maxValue;   //数字元素的最大值
    private String item;    //单选、多选、下拉等的项
    private Integer innerWidth;  //某些不宜过长的元素的内宽
    private Integer layout;      //单选、多选的布局

    private Integer minLength;  //最短长度
    private Integer maxLength;  //最大长度
    private String delimiter;   //固定电话或日期的分割符

    private String type;        //元素类型
    private Integer seq;        //序号
    private String sheetId;     //统计表id

}
