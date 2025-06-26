package com.practice.week1.day7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.practice.week1.day7")
public class FinalProject {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FinalProject.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        vehicle.move();
    }
}
