package com.yiheidaodi.gims.dao;

/**
 * gims com.yiheidaodi
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-25 09:01.
 */

public class Person {

    private String id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
