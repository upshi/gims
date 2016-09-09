package com.yiheidaodi.gims.model;

/**
 * gims com.yiheidaodi.gims.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-27 13:51.
 */

public class TeachClass {

    private String id;
    private String college;         //学院
    private String grade;           //年级
    private String major;           //专业
    private String clazz;           //班级

    public TeachClass() {
    }

    public TeachClass(String id, String college, String grade, String major, String clazz) {
        this.id = id;
        this.college = college;
        this.grade = grade;
        this.major = major;
        this.clazz = clazz;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "TeachClass{" +
                "id='" + id + '\'' +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }

}
