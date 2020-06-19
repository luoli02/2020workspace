package com.example.git.Demo;

import org.junit.Test;



 public abstract class Demo1{

     @Test
     public void T(){
        test();
     }

    public abstract void test();

}

class Demo2 extends Demo1{
    public void test(){
        System.out.println("Demo2");
    }

}


