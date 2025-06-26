package com.practice.week1.day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.practice.week1.day2")

public class BeanExample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanExample.class);
        Bike bike = context.getBean(Bike.class);
        bike.drive();
    }
}
