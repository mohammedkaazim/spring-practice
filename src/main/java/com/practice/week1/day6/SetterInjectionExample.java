package com.practice.week1.day6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.practice.week1.day6")
public class SetterInjectionExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SetterInjectionExample.class);
        Car car = context.getBean(Car.class);
        car.drive();
    }
}
