package com.bianyiit.domain;

import java.io.Serializable;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-8-22 15:12
 * @Version 1.0
 */
public class Emp implements Serializable {
    private Integer id;
    private String ename;
    private double salary;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
