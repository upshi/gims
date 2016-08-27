package com.yiheidaodi.gims.model;

/**
 * gims com.yiheidaodi.model
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-23 21:42.
 */

public class Address {

    private String province;
    private String city;
    private String area;
    private String detail;
    private String zipCode;

    public Address() {
    }

    public Address(String province, String city, String area, String detail, String zipCode) {
        this.province = province;
        this.city = city;
        this.area = area;
        this.detail = detail;
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", detail='" + detail + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
