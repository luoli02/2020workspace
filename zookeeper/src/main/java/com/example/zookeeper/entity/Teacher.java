package com.example.zookeeper.entity;

public class Teacher {

    private String name;

    private Integer age;

    public Teacher() {
        System.out.println("teacher的构造方法执行了...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
