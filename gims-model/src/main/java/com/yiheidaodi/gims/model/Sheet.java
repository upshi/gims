package com.yiheidaodi.gims.model;

import java.util.List;

/**
 * gims com.yiheidaodi.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-23 20:27.
 */

public class Sheet {

    public static final Integer STATUS_CREATING = 0;
    public static final Integer STATUS_USING = 1;
    public static final Integer STATUS_USED = 2;

    private String id;
    private String name;        //表名称
    private List<Element> elements;
    private String createrId;           //创建者Id
    private String createTime;      //创建时间
    private String grade;           //年级
    private Integer status;         //状态

}
