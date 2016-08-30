package com.yiheidaodi.gims.model;

/**
 * gims com.yiheidaodi.gims.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-27 13:32.
 */

public class User {

    public static final int LEVEL_LOW = 0;
    public static final int LEVEL_MIDDLE = 1;
    public static final int LEVEL_HIGH = 2;


    private String id;
    private String userName;
    private String password;
    private String name;
    private String tel;
    private String email;
    private Dept dept;          //部门
    private Integer level;      //等级


}
