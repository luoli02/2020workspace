package com.example.git.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {

        PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("MiPhone");            // make xiaomi phone!
        miPhone.make();
        IPhone iPhone = (IPhone) factory.makePhone("iPhone");    // make iphone!
        iPhone.make();



    }
}

/**
 * 告知工厂想买什么类型的手机
 */
class PhoneFactory {
    public Phone makePhone(String phoneType) {
        if (phoneType.equalsIgnoreCase("MiPhone")) {
            return new MiPhone();
        } else if (phoneType.equalsIgnoreCase("iPhone")) {
            return new IPhone();
        }
        return null;
    }
}

//自造手机的方法或接口
interface Phone {
    void make();
}


/**
 * 想生成Iphone就得实现Phone接口生成自己的手机
 */
class IPhone implements Phone {

    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make iphone!");
    }
}

/**
 * 想生成MiPhone就得实现Phone接口生产自己的手机
 */
class MiPhone implements Phone {

    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make xiaomi phone!");
    }
}

