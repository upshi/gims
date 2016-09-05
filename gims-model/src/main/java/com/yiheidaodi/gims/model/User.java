package com.yiheidaodi.gims.model;

/**
 * gims com.yiheidaodi.gims.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-27 13:32.
 */

public class User {

    public static final int ROLE_DEPT = 0;
    public static final int ROLE_COLLEGE = 1;
    public static final int ROLE_ADMIN = 2;


    private String id;
    private String userName;
    private String password;
    private String name;
    private String tel;
    private String email;
    private Dept dept;          //部门
    private Integer role;      //等级

    public User() {}

    public User(String id, String userName, String password, String name, String tel, String email, Dept dept, Integer role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.dept = dept;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                ", role=" + role +
                '}';
    }
}
