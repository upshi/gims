package com.yiheidaodi.gims.test.dao;

import com.yiheidaodi.gims.model.Address;

/**
 * gims com.yiheidaodi.gims.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-26 13:26.
 */

public class Person {
    private String id;
    private String name;
    private int age;
    private Address address;

    public Person() {}

    public Person(String id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
