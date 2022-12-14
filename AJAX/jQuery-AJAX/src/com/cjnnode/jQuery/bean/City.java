package com.cjnnode.jQuery.bean;

/**
 * @program: AJAX
 * @description: 城市类
 * @author: 陈建南
 * @create: 2022-08-21 16:08
 **/
public class City {
    private int id;
    private String name;
    private int provinceId;

    public City() {
    }

    public City(int id, String name, int provinceId) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}