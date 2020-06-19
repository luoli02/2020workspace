package com.example.git.factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        Phone phone = xiaoMiFactory.makePhone();
        phone.make();

    }

}


interface AbstractFactory {
    Phone makePhone();
}

class XiaoMiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}

class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}


interface Phone {
    void make();
}


class IPhone implements Phone {

    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make iphone!");
    }
}

class MiPhone implements Phone {

    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make xiaomi phone!");
    }
}











