package com.example.zookeeper.entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {MyImportRegistrar.class})
public class MyConfig {

}
