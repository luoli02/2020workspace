package com.example.zookeeper.zklock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Test {


    public  void aVoid() throws IOException {
        String resource = "1";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        List<Integer> integers = Arrays.asList(1);
        List<String> strings = Arrays.asList("1");

    }
    private String name;

    private Integer age;

    public Test(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Test() {
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Test.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }

    public Test(String name) {
        this.name = name;
    }



    public static void main(String[] args) {
        Test test = new Test();
        test.setName("luo");
        test.setAge(2);
        System.out.println(test);

    }
}
