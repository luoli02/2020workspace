package com.example.zookeeper.zklock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(5, 1, 3, 2, 4);
        List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());

        System.out.println(collect);
    }
}
