package com.example.zookeeper.entity;

public class Person {

    private String name;

    private Integer age;

    public Person() {
        System.out.println("person的构造方法执行了...");
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
