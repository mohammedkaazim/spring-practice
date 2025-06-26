package com.practice.week1.day5;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public void start() {
        System.out.println("Engine started with Constructor Injection.");
    }
}
