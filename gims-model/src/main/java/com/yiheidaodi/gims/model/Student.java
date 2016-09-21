package com.yiheidaodi.gims.model;

/**
 * gims com.yiheidaodi.gims.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-27 13:37.
 */

public class Student {

    private String id;
    private String studentNo;
    private String password;
    private String name;
    private TeachClass teachClass;      //教学班级
    private String tel;             //手机
    private String email;           //邮箱
    private String idNo;            //身份证号

    public Student() {
    }

    public Student(String id, String studentNo, String password, String name, TeachClass teachClass, String tel, String email, String idNo) {
        this.id = id;
        this.studentNo = studentNo;
        this.password = password;
        this.name = name;
        this.teachClass = teachClass;
        this.tel = tel;
        this.email = email;
        this.idNo = idNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
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

    public TeachClass getTeachClass() {
        return teachClass;
    }

    public void setTeachClass(TeachClass teachClass) {
        this.teachClass = teachClass;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", teachClass=" + teachClass +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", idNo='" + idNo + '\'' +
                '}';
    }
}
