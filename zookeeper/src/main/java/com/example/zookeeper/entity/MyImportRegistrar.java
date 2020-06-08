package com.example.zookeeper.entity;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //自定义一个BeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Teacher.class);
        //将这个BeanDefinition注册到BeanFactory的beanDefinitionMap中
        registry.registerBeanDefinition("teacher", rootBeanDefinition);
    }

}
