package com.yiheidaodi.gims.model;

/**
 * gims com.yiheidaodi.gims.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-27 14:01.
 */

public class Dept {

    private String id;
    private String name;    //部门名称
    private String office;  //办公室名称
    private Integer isCollege;  //是否是学院

    public Dept() {}

    public Dept(String id, String name, String office, Integer isCollege) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.isCollege = isCollege;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getIsCollege() {
        return isCollege;
    }

    public void setIsCollege(Integer isCollege) {
        this.isCollege = isCollege;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", office='" + office + '\'' +
                ", isCollege=" + isCollege +
                '}';
    }
}
