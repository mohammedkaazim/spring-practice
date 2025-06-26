package com.practice.week1.day6;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public void start() {
        System.out.println("Engine is started using setter injection.");
    }
}
