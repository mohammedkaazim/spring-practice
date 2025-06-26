package com.practice.week1.day3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.practice.week1.day3")

public class IoCExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(IoCExample.class);
        Car car = context.getBean(Car.class);
        car.start();
    }
}
