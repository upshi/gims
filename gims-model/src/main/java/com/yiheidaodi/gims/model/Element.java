package com.yiheidaodi.gims.model;

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
    public static final int WIDTH_SHORT = 0;
    public static final int WIDTH_MIDDLE = 1;
    public static final int WIDTH_LONG = 2;

    /* 内宽 */

    public static final int INNER_WIDTH_SHORT = 0;
    public static final int INNER_WIDTH_MIDDLE = 1;
    public static final int INNER_WIDTH_LONG = 2;

    /* 分隔符 */
    public static final String DELIMITER_NONE = "";
    public static final String DELIMITER_MINUS = "-";
    public static final String DELIMITER_SLASH = "/";
    public static final String DELIMITER_PAREN = "()";

    /* 布局 */
    public static final int LAYOUT_FREE = 0;
    public static final int LAYOUT_SINGLE = 1;
    public static final int LAYOUT_DOUBLE = 2;
    public static final int LAYOUT_TRIPLE = 3;

    /* 可见性 */
    public static final int INVISIBLE = 0;
    public static final int VISIBLE = 1;

    /* 类型 */
    public static final int TYPE_LABEL = 0;
    public static final int TYPE_SINGLE_TEXT = 1;
    public static final int TYPE_MULTI_TEXT = 2;
    public static final int TYPE_EMAIL = 3;


    public static final int TYPE_NUMBER = 4;
    public static final int TYPE_IDENTITY_NUMBER = 5;
    public static final int TYPE_ZIPCODE = 55;
    public static final int TYPE_MOBILEPHONE = 6;
    public static final int TYPE_TELEPHONE = 7;

    public static final int TYPE_ADDRESS = 8;
    public static final int TYPE_DATE = 9;
    public static final int TYPE_AGE = 10;

    public static final int TYPE_SINGLE_RADIO = 11;
    public static final int TYPE_MULTI_CHECKBOX = 12;
    public static final int TYPE_SINGLE_SELECT = 13;
    public static final int TYPE_MULTI_SELECT = 14;
    public static final int TYPE_SEPARATION = 15;




    private String id;
    private String name;    //元素名
    private String columnName;  //列名
    private Integer width;   //宽度
    private Integer isRequired;     //是否必须
    private String defaultValue;    //默认值
    private Integer hasCode;    //是否有对应代码
    private Integer hasUploaded;    //是否已上传对应代码
    private String description;  //描述
    private Integer isVisible;  //学生是否可见


    private String rows;    //多行文本框的行数
    private Integer isInteger;  //数字元素数字是否是整数
    private Integer minValue;   //数字元素的最小值
    private Integer maxValue;   //数字元素的最大值
    private Integer tire;       //多级下拉框的层级
    private String item;    //单选、多选、下拉等的项
    private Integer innerWidth;  //某些不宜过长的元素的内宽
    private Integer layout;      //单选、多选的布局

    private Integer minLength;  //最短长度
    private Integer maxLength;  //最大长度
    private String delimiter;   //固定电话或日期的分割符

    private String type;        //元素类型
    private Integer seq;        //序号
    private String sheetId;     //统计表id

    public Element() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Integer getHasCode() {
        return hasCode;
    }

    public void setHasCode(Integer hasCode) {
        this.hasCode = hasCode;
    }

    public Integer getHasUploaded() {
        return hasUploaded;
    }

    public void setHasUploaded(Integer hasUploaded) {
        this.hasUploaded = hasUploaded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public Integer getIsInteger() {
        return isInteger;
    }

    public void setIsInteger(Integer isInteger) {
        this.isInteger = isInteger;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getTire() {
        return tire;
    }

    public void setTire(Integer tire) {
        this.tire = tire;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getInnerWidth() {
        return innerWidth;
    }

    public void setInnerWidth(Integer innerWidth) {
        this.innerWidth = innerWidth;
    }

    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", columnName='" + columnName + '\'' +
                ", width=" + width +
                ", isRequired=" + isRequired +
                ", defaultValue='" + defaultValue + '\'' +
                ", hasCode=" + hasCode +
                ", hasUploaded=" + hasUploaded +
                ", description='" + description + '\'' +
                ", isVisible=" + isVisible +
                ", rows='" + rows + '\'' +
                ", isInteger=" + isInteger +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", tire=" + tire +
                ", item='" + item + '\'' +
                ", innerWidth=" + innerWidth +
                ", layout=" + layout +
                ", minLength=" + minLength +
                ", maxLength=" + maxLength +
                ", delimiter='" + delimiter + '\'' +
                ", type='" + type + '\'' +
                ", seq=" + seq +
                ", sheetId='" + sheetId + '\'' +
                '}';
    }
}
