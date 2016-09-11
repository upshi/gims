package com.yiheidaodi.gims.model;

/**
 * gims com.yiheidaodi.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-23 20:27.
 */

public class Sheet {

    public static final int STATUS_CREATING = 0;
    public static final int STATUS_USING = 1;
    public static final int STATUS_USED = 2;

    private String id;
    private String name;        //表名称
    private String createrId;           //创建者Id
    private String createTime;      //创建时间
    private String owner;           //拥有者，学校或者某学院
    private String grade;           //年级
    private Integer status;         //状态

    public Sheet() {
    }

    public Sheet(String id, String name, String createrId, String createTime, String owner, String grade, Integer status) {
        this.id = id;
        this.name = name;
        this.createrId = createrId;
        this.createTime = createTime;
        this.owner = owner;
        this.grade = grade;
        this.status = status;
    }

    public static int getStatusCreating() {
        return STATUS_CREATING;
    }

    public static int getStatusUsing() {
        return STATUS_USING;
    }

    public static int getStatusUsed() {
        return STATUS_USED;
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

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createrId='" + createrId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", owner='" + owner + '\'' +
                ", grade='" + grade + '\'' +
                ", status=" + status +
                '}';
    }
}
