package com.example.zookeeper.entity;

public class Demo {

    public static void main(String[] args) {

        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        boolean b = context.getBeanFactory().containsBean("com.example.zookeeper.entity.Person");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("BeanName：" + beanDefinitionName);
        }*/
        //从IOC容器中获取bean
        /*Person bean1 = context.getBean(Person.class);
        Person bean2 = context.getBean(Person.class);
        System.out.println(bean1 == bean2);*/
        /*Person person1 = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);
        System.out.println(person1 == person2);*/
    }
}
